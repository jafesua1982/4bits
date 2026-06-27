package tuti.desi.tp.servicios;

import java.util.List;
import tuti.desi.tp.entidades.Provincia;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.provincias.ProvinciasBuscarForm;

public interface ProvinciaService {

	List<Provincia> getAll();
	
	Provincia getById(Long id);
	
	List<Provincia> filter(ProvinciasBuscarForm filter) throws Excepcion;
	
	void deleteByid(Long id);

	void save(Provincia c) throws Excepcion;
}