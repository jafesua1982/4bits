package tuti.desi.tp.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.tp.accesoDatos.IProvinciaRepo;
import tuti.desi.tp.entidades.Provincia;
import tuti.desi.tp.excepciones.EntidadNoEncontradaException;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.provincias.ProvinciasBuscarForm;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	IProvinciaRepo repo;

	@Override
	public List<Provincia> getAll() {
		return repo.findAll();
	}

	@Override
	public Provincia getById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadNoEncontradaException("la provincia", id));
	}

	@Override
	public void deleteByid(Long id) {
		if (!repo.existsById(id)) {
			throw new EntidadNoEncontradaException("la provincia", id);
		}
		repo.deleteById(id);
	}

	@Override
	public List<Provincia> filter(ProvinciasBuscarForm filter) throws Excepcion {
		if (filter.getNombre() == null)
			return repo.findAll();
		else
			return repo.findByNombre(filter.getNombre());
	}

	@Override
	public void save(Provincia p) throws Excepcion {
		if (p.getId() == null) {
			if (!repo.findByNombre(p.getNombre()).isEmpty())
				throw new Excepcion("Ya existe una provincia con el mismo nombre");
			else
				repo.save(p);
		} else {
			if (!repo.findByNombreAndIdNot(p.getNombre(), p.getId()).isEmpty())
				throw new Excepcion("Existe otra provincia con el mismo nombre");
			else
				repo.save(p);
		}
	}
}