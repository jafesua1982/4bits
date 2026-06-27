package tuti.desi.tp.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;

@Entity
public class HistorialEstadoPropiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Propiedad propiedad;

	@Enumerated(EnumType.STRING)
	private EstadoDisponibilidad estado;

	private LocalDateTime fechaHora;

	public HistorialEstadoPropiedad() {
	}

	public HistorialEstadoPropiedad(Propiedad propiedad, EstadoDisponibilidad estado) {
		this.propiedad = propiedad;
		this.estado = estado;
		this.fechaHora = LocalDateTime.now();
	}

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

	public EstadoDisponibilidad getEstado() {
		return estado;
	}

	public void setEstado(EstadoDisponibilidad estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
}