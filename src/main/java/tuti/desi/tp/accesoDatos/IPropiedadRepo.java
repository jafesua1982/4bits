package tuti.desi.tp.accesoDatos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.TipoPropiedad;

@Repository
public interface IPropiedadRepo extends JpaRepository<Propiedad, Long> {

	boolean existsByDireccionIgnoreCaseAndCiudadId(String direccion, Long ciudadId);

	@Query("SELECT COUNT(p)>0 FROM Propiedad p WHERE LOWER(p.direccion)=LOWER(:direccion) AND p.ciudad.id=:ciudadId AND p.id<>:id")
	boolean existeOtraConMismaDireccion(@Param("direccion") String direccion, @Param("ciudadId") Long ciudadId, @Param("id") Long id);

	@Query("SELECT p FROM Propiedad p WHERE (:direccion IS NULL OR LOWER(p.direccion) LIKE LOWER(CONCAT('%',:direccion,'%'))) AND (:idCiudad IS NULL OR p.ciudad.id=:idCiudad) AND (:tipo IS NULL OR p.tipo=:tipo) AND (:estado IS NULL OR p.estadoDisponibilidad=:estado)")
	List<Propiedad> filter(@Param("direccion") String direccion, @Param("idCiudad") Long idCiudad, @Param("tipo") TipoPropiedad tipo, @Param("estado") EstadoDisponibilidad estado);

	List<Propiedad> findByEstadoDisponibilidad(EstadoDisponibilidad estado);
}