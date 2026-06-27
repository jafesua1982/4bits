package tuti.desi.tp.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
import tuti.desi.tp.entidades.enums.EstadoFactura;
import tuti.desi.tp.entidades.enums.MedioPago;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private Contrato contrato;

	private String conceptoFacturado;

	private LocalDate fechaEmision;

	private LocalDate fechaVencimiento;

	@Column(precision = 12, scale = 2)
	private BigDecimal importe;

	@Enumerated(EnumType.STRING)
	private EstadoFactura estado = EstadoFactura.PENDIENTE;

	private LocalDate fechaPago;

	@Enumerated(EnumType.STRING)
	private MedioPago medioPago;

	@Column(precision = 12, scale = 2)
	private BigDecimal importePagado;

	@Column(precision = 12, scale = 2)
	private BigDecimal interes;


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

	public String getConceptoFacturado() {
		return conceptoFacturado;
	}

	public void setConceptoFacturado(String conceptoFacturado) {
		this.conceptoFacturado = conceptoFacturado;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public EstadoFactura getEstado() {
		return estado;
	}

	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public BigDecimal getImportePagado() {
		return importePagado;
	}

	public void setImportePagado(BigDecimal importePagado) {
		this.importePagado = importePagado;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}
}