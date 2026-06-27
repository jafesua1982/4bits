package tuti.desi.tp.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import tuti.desi.tp.entidades.enums.EstadoIncidente;

@Entity
public class HistorialEstadoIncidente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Incidente incidente;

	@Enumerated(EnumType.STRING)
	private EstadoIncidente estado;

	private LocalDateTime fechaHora;


	public HistorialEstadoIncidente() {
	}

	public HistorialEstadoIncidente(Incidente incidente, EstadoIncidente estado) {
		this.incidente = incidente;
		this.estado = estado;
		this.fechaHora = LocalDateTime.now();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}

	public EstadoIncidente getEstado() {
		return estado;
	}

	public void setEstado(EstadoIncidente estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
}