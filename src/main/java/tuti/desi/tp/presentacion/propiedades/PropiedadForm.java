package tuti.desi.tp.presentacion.propiedades;

import jakarta.validation.constraints.*;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.TipoPropiedad;

public class PropiedadForm {

	private Long id;

	@NotBlank(message = "La dirección es obligatoria")
	private String direccion;

	@NotNull(message = "La ciudad es obligatoria")
	private Long idCiudad;

	@NotNull(message = "El tipo es obligatorio")
	private TipoPropiedad tipo;

	@NotNull(message = "Los ambientes son obligatorios")
	@Min(1)
	private Integer cantidadAmbientes;

	@NotNull(message = "Los metros son obligatorios")
	@DecimalMin("1.0")
	private Double metrosCuadrados;

	private String descripcion;

	private String comodidades;

	@NotNull(message = "El estado es obligatorio")
	private EstadoDisponibilidad estadoDisponibilidad = EstadoDisponibilidad.DISPONIBLE;

	@NotNull(message = "El propietario es obligatorio")
	private Long idPropietario;


	public PropiedadForm() {
	}

	public PropiedadForm(Propiedad p) {
		this.id = p.getId();
		this.direccion = p.getDireccion();
		this.idCiudad = p.getCiudad() != null ? p.getCiudad().getId() : null;
		this.tipo = p.getTipo();
		this.cantidadAmbientes = p.getCantidadAmbientes();
		this.metrosCuadrados = p.getMetrosCuadrados();
		this.descripcion = p.getDescripcion();
		this.comodidades = p.getComodidades();
		this.estadoDisponibilidad = p.getEstadoDisponibilidad();
		this.idPropietario = p.getPropietario() != null ? p.getPropietario().getId() : null;
	}

	public Propiedad toPojo() {
		Propiedad p = new Propiedad();
		p.setId(id);
		p.setDireccion(direccion);
		p.setTipo(tipo);
		p.setCantidadAmbientes(cantidadAmbientes);
		p.setMetrosCuadrados(metrosCuadrados);
		p.setDescripcion(descripcion);
		p.setComodidades(comodidades);
		p.setEstadoDisponibilidad(estadoDisponibilidad);
		return p;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
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

	public Integer getCantidadAmbientes() {
		return cantidadAmbientes;
	}

	public void setCantidadAmbientes(Integer cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}

	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getComodidades() {
		return comodidades;
	}

	public void setComodidades(String comodidades) {
		this.comodidades = comodidades;
	}

	public EstadoDisponibilidad getEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}

	public void setEstadoDisponibilidad(EstadoDisponibilidad estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}

	public Long getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Long idPropietario) {
		this.idPropietario = idPropietario;
	}
}