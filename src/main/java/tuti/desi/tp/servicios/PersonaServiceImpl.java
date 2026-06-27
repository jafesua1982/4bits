package tuti.desi.tp.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.tp.accesoDatos.IPersonaRepo;
import tuti.desi.tp.entidades.Persona;
import tuti.desi.tp.excepciones.EntidadNoEncontradaException;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.personas.PersonasBuscarForm;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	IPersonaRepo repo;

	@Override
	public List<Persona> getAll() {
		return repo.findAll();
	}

	@Override
	public Persona getById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadNoEncontradaException("la persona", id));
	}

	@Override
	public List<Persona> filter(PersonasBuscarForm filter) {
		if (filter.getNombre() == null && filter.getDniCuit() == null)
			return repo.findAll();
		else
			return repo.filter(filter.getNombre(), filter.getDniCuit());
	}

	@Override
	public void save(Persona p) throws Excepcion {
		boolean duplicado = p.getId() == null
				? repo.existsByDniCuit(p.getDniCuit())
				: repo.existsByDniCuitAndIdNot(p.getDniCuit(), p.getId());
				
		if (duplicado)
			throw new Excepcion("Ya existe una persona con ese DNI/CUIT", "dniCuit");
			
		repo.save(p);
	}

	@Override
	public void deleteById(Long id) {
		if (!repo.existsById(id))
			throw new EntidadNoEncontradaException("la persona", id);
		repo.deleteById(id);
	}
}