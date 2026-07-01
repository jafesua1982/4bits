package tuti.desi.tp.presentacion.publicaciones;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;

public class PublicacionForm {

	private Long id;

	@NotNull(message = "La propiedad es obligatoria")
	private Long idPropiedad;

	@NotNull(message = "El precio es obligatorio")
	@DecimalMin(value = "0.01", message = "Debe ser mayor a 0")
	private BigDecimal precioMensual;

	@NotBlank(message = "Las condiciones son obligatorias")
	private String condiciones;

	@NotBlank(message = "La descripcion es obligatoria")
	private String descripcion;

	@NotNull(message = "La fecha es obligatoria")
	private LocalDate fechaPublicacion;

	@NotNull(message = "El estado es obligatorio")
	private EstadoPublicacion estado = EstadoPublicacion.ACTIVA;


	public PublicacionForm() {
	}

	public PublicacionForm(Publicacion pub) {
		this.id = pub.getId();
		this.idPropiedad = pub.getPropiedad().getId();
		this.precioMensual = pub.getPrecioMensual();
		this.condiciones = pub.getCondiciones();
		this.descripcion = pub.getDescripcion();
		this.fechaPublicacion = pub.getFechaPublicacion();
		this.estado = pub.getEstado();
	}

	public Publicacion toPojo() {
		Publicacion pub = new Publicacion();
		pub.setId(id);
		pub.setPrecioMensual(precioMensual);
		pub.setCondiciones(condiciones);
		pub.setDescripcion(descripcion);
		pub.setFechaPublicacion(fechaPublicacion);
		pub.setEstado(estado);
		return pub;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(Long idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public BigDecimal getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(BigDecimal precioMensual) {
		this.precioMensual = precioMensual;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public EstadoPublicacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoPublicacion estado) {
		this.estado = estado;
	}
}

