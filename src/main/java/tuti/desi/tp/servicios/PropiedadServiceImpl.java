package tuti.desi.tp.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.tp.accesoDatos.IPropiedadRepo;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.excepciones.EntidadNoEncontradaException;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.propiedades.PropiedadesBuscarForm;

@Service
public class PropiedadServiceImpl implements PropiedadService {

	@Autowired
	IPropiedadRepo repo;

	@Override
	public List<Propiedad> getAll() {
		return repo.findAll();
	}

	@Override
	public Propiedad getById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadNoEncontradaException("la propiedad", id));
	}

	@Override
	public List<Propiedad> filter(PropiedadesBuscarForm filter) {
		if (filter.getDireccion() == null && filter.getIdCiudad() == null
				&& filter.getTipo() == null && filter.getEstado() == null)
			return repo.findAll();
		else
			return repo.filter(filter.getDireccion(), filter.getIdCiudad(),
					filter.getTipo(), filter.getEstado());
	}

	@Override
	public void save(Propiedad p) throws Excepcion {
		if (p.getId() == null) {
			if (repo.existsByDireccionIgnoreCaseAndCiudadId(p.getDireccion(), p.getCiudad().getId()))
				throw new Excepcion("Ya existe una propiedad con esa dirección en la misma ciudad", "direccion");
			
			if (p.getEstadoDisponibilidad() == null)
				p.setEstadoDisponibilidad(EstadoDisponibilidad.DISPONIBLE);
			
			repo.save(p);
		} else {
			if (repo.existeOtraConMismaDireccion(p.getDireccion(), p.getCiudad().getId(), p.getId()))
				throw new Excepcion("Existe otra propiedad con esa dirección en la misma ciudad", "direccion");
			
			repo.save(p);
		}
	}

	@Override
	public void deleteById(Long id) {
		if (!repo.existsById(id))
			throw new EntidadNoEncontradaException("la propiedad", id);
		
		repo.deleteById(id);
	}
}