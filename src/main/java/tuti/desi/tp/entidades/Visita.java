package tuti.desi.tp.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import tuti.desi.tp.entidades.enums.EstadoVisita;

@Entity
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private Publicacion publicacion;

	private LocalDateTime fechaHora;

	@Enumerated(EnumType.STRING)
	private EstadoVisita estado = EstadoVisita.PENDIENTE;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public EstadoVisita getEstado() {
		return estado;
	}

	public void setEstado(EstadoVisita estado) {
		this.estado = estado;
	}
}