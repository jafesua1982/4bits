package tuti.desi.tp.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import tuti.desi.tp.entidades.enums.EstadoContrato;

@Entity
public class HistorialEstadoContrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Contrato contrato;

	@Enumerated(EnumType.STRING)
	private EstadoContrato estado;

	private LocalDateTime fechaHora;


	public HistorialEstadoContrato() {
	}

	public HistorialEstadoContrato(Contrato contrato, EstadoContrato estado) {
		this.contrato = contrato;
		this.estado = estado;
		this.fechaHora = LocalDateTime.now();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public EstadoContrato getEstado() {
		return estado;
	}

	public void setEstado(EstadoContrato estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
}