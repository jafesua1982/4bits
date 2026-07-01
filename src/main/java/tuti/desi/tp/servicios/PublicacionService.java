package tuti.desi.tp.servicios;


import java.math.BigDecimal;
import java.util.List;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;

public interface PublicacionService {
    Publicacion guardar(Publicacion publicacion) throws Exception;
    
    void eliminar(Long id) throws Exception;
    Publicacion buscarPorId(Long id);
	List<Publicacion> filtrar(Long idPropiedad, Long idCiudad, EstadoPublicacion estado, BigDecimal precioMin,
			BigDecimal precioMax);
}