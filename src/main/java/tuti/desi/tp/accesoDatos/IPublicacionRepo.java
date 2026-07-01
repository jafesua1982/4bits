package tuti.desi.tp.accesoDatos;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;

public interface IPublicacionRepo extends JpaRepository<Publicacion, Long> {

    boolean existsByPropiedadIdAndEstadoAndEliminadaFalse(Long propiedadId, EstadoPublicacion estado);

    @Query("SELECT COUNT(p)>0 FROM Publicacion p WHERE p.propiedad.id=:idPropiedad AND p.estado=:estado AND p.id<>:id AND p.eliminada = false")
    boolean existeOtraActiva(@Param("idPropiedad") Long idPropiedad, @Param("estado") EstadoPublicacion estado, @Param("id") Long id);


    @Query("SELECT p FROM Publicacion p WHERE p.eliminada = false " +
           "AND (:idPropiedad IS NULL OR p.propiedad.id=:idPropiedad) " +
           "AND (:idCiudad IS NULL OR p.propiedad.ciudad.id=:idCiudad) " +
           "AND (:estado IS NULL OR p.estado=:estado) " +
           "AND (:precioMin IS NULL OR p.precioMensual>=:precioMin) " +
           "AND (:precioMax IS NULL OR p.precioMensual<=:precioMax)")
    List<Publicacion> filter(@Param("idPropiedad") Long idPropiedad, 
                             @Param("idCiudad") Long idCiudad, 
                             @Param("estado") EstadoPublicacion estado, 
                             @Param("precioMin") BigDecimal precioMin, 
                             @Param("precioMax") BigDecimal precioMax);

	boolean existsByPropiedadIdAndEstado(Long id, EstadoPublicacion activa);
}