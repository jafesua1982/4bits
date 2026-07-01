package tuti.desi.tp.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Propiedad propiedad;

    @Enumerated(EnumType.STRING)
    private EstadoPublicacion estado;

    private BigDecimal precioMensual;
    
    private String condiciones;
    private String descripcion;
    private LocalDate fechaPublicacion;
    
    private boolean eliminada = false;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistorialEstadoPublicacion> historialEstados = new ArrayList<>();

    public void agregarHistorial(EstadoPublicacion nuevoEstado) {
        HistorialEstadoPublicacion historial = new HistorialEstadoPublicacion(nuevoEstado, this);
        this.historialEstados.add(historial);
        this.estado = nuevoEstado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Propiedad getPropiedad() { return propiedad; }
    public void setPropiedad(Propiedad propiedad) { this.propiedad = propiedad; }
    public EstadoPublicacion getEstado() { return estado; }
    public void setEstado(EstadoPublicacion estado) { this.estado = estado; }
    public BigDecimal getPrecioMensual() { return precioMensual; }
    public void setPrecioMensual(BigDecimal precioMensual) { this.precioMensual = precioMensual; }
    
    public String getCondiciones() { return condiciones; }
    public void setCondiciones(String condiciones) { this.condiciones = condiciones; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    
    public boolean isEliminada() { return eliminada; }
    public void setEliminada(boolean eliminada) { this.eliminada = eliminada; }
    public List<HistorialEstadoPublicacion> getHistorialEstados() { return historialEstados; }
    public void setHistorialEstados(List<HistorialEstadoPublicacion> historialEstados) { this.historialEstados = historialEstados; }
}