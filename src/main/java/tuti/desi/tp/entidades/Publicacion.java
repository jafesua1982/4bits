package tuti.desi.tp.entidades;

import tuti.desi.tp.entidades.enums.EstadoPublicacion;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private Propiedad propiedad;
	
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<HistorialEstadoPublicacion> historialEstados = new java.util.ArrayList<>();

    public void agregarHistorial(EstadoPublicacion nuevoEstado) {
        HistorialEstadoPublicacion historial = new HistorialEstadoPublicacion(this, nuevoEstado);
        this.historialEstados.add(historial);
        this.estado = nuevoEstado;
    }

	@Column(precision = 12, scale = 2)
	private BigDecimal precioMensual;

	@Column(columnDefinition = "TEXT")
	private String condiciones;

	@Column(columnDefinition = "TEXT")
	private String descripcion;

	private LocalDate fechaPublicacion;

	@Enumerated(EnumType.STRING)
	private EstadoPublicacion estado = EstadoPublicacion.ACTIVA;
	
	private boolean eliminada = false;


	public Long getId() { 
		return id; 
	}

	public void setId(Long id) { 
		this.id = id; 
	}

	
	public Propiedad getPropiedad() { 
		return propiedad; 
	}

	public void setPropiedad(Propiedad propiedad) { 
		this.propiedad = propiedad; 
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
	
	public boolean isEliminada() {
		return eliminada;
	}
	
	public void setEliminada(boolean eliminada) {
		this.eliminada = eliminada;
	}

}