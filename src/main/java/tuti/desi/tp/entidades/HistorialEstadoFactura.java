package tuti.desi.tp.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import tuti.desi.tp.entidades.enums.EstadoFactura;

@Entity
public class HistorialEstadoFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Factura factura;

	@Enumerated(EnumType.STRING)
	private EstadoFactura estado;

	private LocalDateTime fechaHora;


	public HistorialEstadoFactura() {
	}

	public HistorialEstadoFactura(Factura factura, EstadoFactura estado) {
		this.factura = factura;
		this.estado = estado;
		this.fechaHora = LocalDateTime.now();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public EstadoFactura getEstado() {
		return estado;
	}

	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
}