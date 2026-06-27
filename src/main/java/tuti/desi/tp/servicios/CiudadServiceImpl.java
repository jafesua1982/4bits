package tuti.desi.tp.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.tp.accesoDatos.ICiudadRepo;
import tuti.desi.tp.entidades.Ciudad;
import tuti.desi.tp.excepciones.EntidadNoEncontradaException;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.ciudades.CiudadesBuscarForm;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	ICiudadRepo repo;

	@Override
	public List<Ciudad> getAll() {
		return repo.findAll();
	}

	@Override
	public Ciudad getById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadNoEncontradaException("la ciudad", id));
	}

	@Override
	public void deleteByid(Long id) {
		if (!repo.existsById(id)) {
			throw new EntidadNoEncontradaException("la ciudad", id);
		}
		repo.deleteById(id);
	}

	@Override
	public List<Ciudad> filter(CiudadesBuscarForm filter) throws Excepcion {
		if (filter.getNombre() == null && filter.getProvinciaSeleccionada() == null)
			return repo.findAll();
		else
			return repo.findByNombreOrIdProvincia(filter.getNombre(), filter.getProvinciaSeleccionada());
	}

	@Override
	public void save(Ciudad c) throws Excepcion {
		if (c.getId() == null) {
			if (!repo.findByNombreAndIdProvincia(c.getNombre(), c.getProvincia().getId()).isEmpty())
				throw new Excepcion("Ya existe esa ciudad en la misma provincia");
			else
				repo.save(c);
		} else {
			if (!repo.findOtraCiudadByNombreAndProvincia(c.getNombre(), c.getProvincia().getId(), c.getId()).isEmpty())
				throw new Excepcion("Existe otra ciudad con el mismo nombre en la misma provincia");
			else
				repo.save(c);
		}
	}
}