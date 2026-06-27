package tuti.desi.tp.entidades;

import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.TipoPropiedad;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Propiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, max = 200, message = "La dirección es obligatoria")
	private String direccion;

	@ManyToOne(optional = false)
	private Ciudad ciudad;

	@Enumerated(EnumType.STRING)
	private TipoPropiedad tipo;

	@Min(value = 1, message = "Debe ser al menos 1")
	private Integer cantidadAmbientes;

	@DecimalMin(value = "1.0", message = "Debe ser mayor a 0")
	private Double metrosCuadrados;

	private String descripcion;
	
	private String comodidades;

	@Enumerated(EnumType.STRING)
	private EstadoDisponibilidad estadoDisponibilidad = EstadoDisponibilidad.DISPONIBLE;

	@ManyToOne(optional = false)
	private Persona propietario;


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
	
	public Ciudad getCiudad() { 
		return ciudad; 
	}
	
	public void setCiudad(Ciudad ciudad) { 
		this.ciudad = ciudad; 
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
	
	public Persona getPropietario() { 
		return propietario; 
	}
	
	public void setPropietario(Persona propietario) { 
		this.propietario = propietario; 
	}
}