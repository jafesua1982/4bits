package tuti.desi.tp.servicios;

import java.util.List;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.presentacion.publicaciones.PublicacionesBuscarForm;

public interface PublicacionService {

	List<Publicacion> getAll();

	Publicacion getById(Long id);

	List<Publicacion> filter(PublicacionesBuscarForm filter);

	void save(Publicacion p) throws Excepcion;

	void deleteById(Long id);
}
