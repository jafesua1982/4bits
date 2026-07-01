package tuti.desi.tp.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import tuti.desi.tp.entidades.HistorialEstadoPropiedad;

public interface IHistorialEstadoPropiedadRepo extends JpaRepository<HistorialEstadoPropiedad, Long> {
}