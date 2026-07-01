package tuti.desi.tp.accesoDatos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tuti.desi.tp.entidades.Ciudad;

public interface ICiudadRepo extends JpaRepository<Ciudad, Long> {

	@Query("SELECT c FROM Ciudad c WHERE c.nombre like :nombre or c.provincia.id=:idProvincia")
	List<Ciudad> findByNombreOrIdProvincia(String nombre, Long idProvincia);

	@Query("SELECT c FROM Ciudad c WHERE c.nombre like :nombre and c.provincia.id=:idProvincia")
	List<Ciudad> findByNombreAndIdProvincia(String nombre, Long idProvincia);

	@Query("SELECT c FROM Ciudad c WHERE c.nombre like :nombre and c.provincia.id=:idProvincia and c.id<>:idDistintoDe")
	List<Ciudad> findOtraCiudadByNombreAndProvincia(String nombre, Long idProvincia, Long idDistintoDe);
}