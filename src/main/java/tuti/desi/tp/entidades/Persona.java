package tuti.desi.tp.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100, message = "El nombre es obligatorio")
    private String nombre;

    @Size(min = 1, max = 100, message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El DNI/CUIT es obligatorio")
    @Column(nullable = false, unique = true, length = 11)
    private String dniCuit;

    @Size(min = 1, max = 30, message = "El teléfono es obligatorio")
    private String telefono;

    @Email(message = "El email no es válido")
    private String email;

    @Size(min = 1, max = 200, message = "El domicilio es obligatorio")
    private String domicilio;

    @ManyToOne
    private Ciudad ciudad;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getDniCuit() { return dniCuit; }
    public void setDniCuit(String dniCuit) { this.dniCuit = dniCuit; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
    public Ciudad getCiudad() { return ciudad; }
    public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }
    public String getNombreCompleto() { return apellido + ", " + nombre; }
}