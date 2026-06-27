package tuti.desi.tp.presentacion.ciudades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tuti.desi.tp.entidades.Ciudad;

public class CiudadForm {

	private Long id;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String nombre;
	
	@NotNull
	private Long idProvincia;

	public CiudadForm() {}

	public CiudadForm(Ciudad c) {
		this.id = c.getId();
		this.nombre = c.getNombre();
		this.idProvincia = c.getProvincia().getId();
	}

	public Ciudad toPojo() {
		Ciudad c = new Ciudad();
		c.setId(this.id);
		c.setNombre(this.nombre);
		return c;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}
}