package tuti.desi.tp.accesoDatos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tuti.desi.tp.entidades.Provincia;

public interface IProvinciaRepo extends JpaRepository<Provincia, Long> {

	List<Provincia> findByNombre(String nombre);
	
	List<Provincia> findByNombreAndIdNot(String nombre, Long idDistintoDe);
}