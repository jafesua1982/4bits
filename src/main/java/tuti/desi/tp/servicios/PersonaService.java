package tuti.desi.tp.servicios;

import java.util.List;
import tuti.desi.tp.entidades.Persona;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.personas.PersonasBuscarForm;

public interface PersonaService {

	List<Persona> getAll();
	
	Persona getById(Long id);
	
	List<Persona> filter(PersonasBuscarForm filter);
	
	void save(Persona p) throws Excepcion;
	
	void deleteById(Long id);
}