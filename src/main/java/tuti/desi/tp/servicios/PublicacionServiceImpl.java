package tuti.desi.tp.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import tuti.desi.tp.accesoDatos.IPublicacionRepo;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    private final IPublicacionRepo repo;

    public PublicacionServiceImpl(IPublicacionRepo repo) {
        this.repo = repo;
    }

    @Override
    public Publicacion guardar(Publicacion publicacion) throws Exception {

        if (publicacion.getEstado() == EstadoPublicacion.ACTIVA && 
            repo.existsByPropiedadIdAndEstado(publicacion.getPropiedad().getId(), EstadoPublicacion.ACTIVA)) {
            throw new Exception("La propiedad ya tiene una publicación activa.");
        }
        
        publicacion.agregarHistorial(publicacion.getEstado());
        
        return repo.save(publicacion);
    }

    @Override
    public List<Publicacion> listarTodas() {

        return repo.filter(null, null, null, null, null);
    }

    @Override
    public void eliminar(Long id) {
        Publicacion publicacion = buscarPorId(id);
        
        if (publicacion == null) {
            throw new RuntimeException("Publicación no encontrada.");
        }
        
        if (publicacion.getEstado() != EstadoPublicacion.ACTIVA) {
            throw new RuntimeException("Solo pueden eliminarse publicaciones en estado ACTIVA.");
        }

        publicacion.setEliminada(true);
        repo.save(publicacion);
    }

    @Override
    public Publicacion buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}