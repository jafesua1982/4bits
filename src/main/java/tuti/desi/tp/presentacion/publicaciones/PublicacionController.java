package tuti.desi.tp.presentacion.publicaciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;
import tuti.desi.tp.servicios.PublicacionService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping
    public List<Publicacion> listar(
            @RequestParam(required = false) Long idPropiedad,
            @RequestParam(required = false) Long idCiudad,
            @RequestParam(required = false) EstadoPublicacion estado,
            @RequestParam(required = false) BigDecimal precioMin,
            @RequestParam(required = false) BigDecimal precioMax) {
        
        return publicacionService.filtrar(idPropiedad, idCiudad, estado, precioMin, precioMax);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Publicacion publicacion) {
        try {
            return ResponseEntity.ok(publicacionService.guardar(publicacion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            publicacionService.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}