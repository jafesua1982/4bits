package tuti.desi.tp.entidades;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;

@Entity
public class HistorialEstadoPublicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Publicacion publicacion;

	@Enumerated(EnumType.STRING)
	private EstadoPublicacion estado;

	private LocalDateTime fechaHora;


	public HistorialEstadoPublicacion() {
	}

	public HistorialEstadoPublicacion(Publicacion publicacion, EstadoPublicacion estado) {
		this.publicacion = publicacion;
		this.estado = estado;
		this.fechaHora = LocalDateTime.now();
	}


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

	public EstadoPublicacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoPublicacion estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
}