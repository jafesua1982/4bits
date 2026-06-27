package tuti.desi.tp.presentacion.propiedades;

import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.TipoPropiedad;

public class PropiedadesBuscarForm {

	private String direccion;
	private Long idCiudad;
	private TipoPropiedad tipo;
	private EstadoDisponibilidad estado;

	public String getDireccion() {
		if (direccion != null && !direccion.isBlank())
			return direccion.trim();
		else
			return null;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public TipoPropiedad getTipo() {
		return tipo;
	}

	public void setTipo(TipoPropiedad tipo) {
		this.tipo = tipo;
	}

	public EstadoDisponibilidad getEstado() {
		return estado;
	}

	public void setEstado(EstadoDisponibilidad estado) {
		this.estado = estado;
	}
}