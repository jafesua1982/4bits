package tuti.desi.tp.presentacion.personas;

import jakarta.validation.constraints.*;
import tuti.desi.tp.entidades.Persona;

public class PersonaForm {

	private Long id;
	
	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 100)
	private String nombre;
	
	@NotBlank(message = "El apellido es obligatorio")
	@Size(max = 100)
	private String apellido;
	
	@NotBlank(message = "El DNI/CUIT es obligatorio")
	private String dniCuit;
	
	@NotBlank(message = "El teléfono es obligatorio")
	@Size(max = 30)
	private String telefono;
	
	@Email(message = "El email no es válido")
	private String email;
	
	@NotBlank(message = "El domicilio es obligatorio")
	@Size(max = 200)
	private String domicilio;
	
	private Long idCiudad;


	public PersonaForm() {
	}

	public PersonaForm(Persona p) {
		this.id = p.getId();
		this.nombre = p.getNombre();
		this.apellido = p.getApellido();
		this.dniCuit = p.getDniCuit();
		this.telefono = p.getTelefono();
		this.email = p.getEmail();
		this.domicilio = p.getDomicilio();
		this.idCiudad = p.getCiudad() == null ? null : p.getCiudad().getId();
	}

	public Persona toPojo() {
		Persona p = new Persona();
		p.setId(id);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setDniCuit(dniCuit);
		p.setTelefono(telefono);
		p.setEmail(email);
		p.setDomicilio(domicilio);
		return p;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDniCuit() {
		return dniCuit;
	}

	public void setDniCuit(String dniCuit) {
		this.dniCuit = dniCuit;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
}