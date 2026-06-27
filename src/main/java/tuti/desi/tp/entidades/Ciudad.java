package tuti.desi.tp.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100, message = "El nombre es obligatorio")
    private String nombre;

    @ManyToOne(optional = false)
    private Provincia provincia;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Provincia getProvincia() { return provincia; }
    public void setProvincia(Provincia provincia) { this.provincia = provincia; }
}