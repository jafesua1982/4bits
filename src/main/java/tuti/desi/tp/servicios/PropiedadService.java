package tuti.desi.tp.servicios;

import java.util.List;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.propiedades.PropiedadesBuscarForm;

public interface PropiedadService {

	List<Propiedad> getAll();
	
	Propiedad getById(Long id);
	
	List<Propiedad> filter(PropiedadesBuscarForm filter);
	
	void save(Propiedad p) throws Excepcion;
	
	void deleteById(Long id);
}