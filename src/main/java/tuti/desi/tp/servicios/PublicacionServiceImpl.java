package tuti.desi.tp.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.tp.accesoDatos.IPublicacionRepo;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;
import tuti.desi.tp.excepciones.EntidadNoEncontradaException;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.publicaciones.PublicacionesBuscarForm;

@Service
public class PublicacionServiceImpl implements PublicacionService {

	@Autowired
	IPublicacionRepo repo;

	@Override
	public List<Publicacion> getAll() {
		return repo.findAll();
	}

	@Override
	public Publicacion getById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadNoEncontradaException("la publicacion", id));
	}

	@Override
	public List<Publicacion> filter(PublicacionesBuscarForm filter) {
		if (filter.getIdPropiedad() == null && filter.getIdCiudad() == null
				&& filter.getEstado() == null && filter.getPrecioMin() == null
				&& filter.getPrecioMax() == null)
			return repo.findAll();
		else
			return repo.filter(filter.getIdPropiedad(), filter.getIdCiudad(),
					filter.getEstado(), filter.getPrecioMin(), filter.getPrecioMax());
	}

	@Override
	public void save(Publicacion p) throws Excepcion {
		if (p.getId() == null) {
			if (p.getPropiedad().getEstadoDisponibilidad() != EstadoDisponibilidad.DISPONIBLE)
				throw new Excepcion("Solo se puede publicar una propiedad en estado DISPONIBLE", "idPropiedad");

			if (repo.existsByPropiedadIdAndEstado(p.getPropiedad().getId(), EstadoPublicacion.ACTIVA))
				throw new Excepcion("Ya existe una publicacion activa para esta propiedad", "idPropiedad");

			p.setEstado(EstadoPublicacion.ACTIVA);
			repo.save(p);

		} else {
			Publicacion existente = getById(p.getId());

			if (p.getEstado() == EstadoPublicacion.ACTIVA && existente.getEstado() != EstadoPublicacion.ACTIVA) {
				if (repo.existeOtraActiva(existente.getPropiedad().getId(), EstadoPublicacion.ACTIVA, existente.getId()))
					throw new Excepcion("Ya existe otra publicacion activa para esta propiedad", "estado");

				if (existente.getPropiedad().getEstadoDisponibilidad() != EstadoDisponibilidad.DISPONIBLE)
					throw new Excepcion("La propiedad no esta disponible", "estado");
			}

			repo.save(p);
		}
	}

	@Override
	public void deleteById(Long id) {
		Publicacion p = getById(id);

		if (p.getEstado() != EstadoPublicacion.ACTIVA)
			throw new RuntimeException("Solo se pueden eliminar publicaciones en estado ACTIVA");

		repo.deleteById(id);
	}
}
