package tuti.desi.tp.servicios;

import java.util.List;
import tuti.desi.tp.entidades.Ciudad;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.ciudades.CiudadesBuscarForm;

public interface CiudadService {

	List<Ciudad> getAll();
	
	Ciudad getById(Long id);
	
	List<Ciudad> filter(CiudadesBuscarForm filter) throws Excepcion;
	
	void deleteByid(Long id);

	void save(Ciudad c) throws Excepcion;
}