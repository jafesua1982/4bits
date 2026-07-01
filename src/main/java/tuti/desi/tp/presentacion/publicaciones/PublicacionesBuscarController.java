package tuti.desi.tp.presentacion.publicaciones;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import tuti.desi.tp.entidades.Ciudad;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.servicios.CiudadService;
import tuti.desi.tp.servicios.PropiedadService;
import tuti.desi.tp.servicios.PublicacionService;

@Controller
@RequestMapping("/publicacionesBuscar")
public class PublicacionesBuscarController {

	@Autowired
	private PublicacionService servicioPublicaciones;

	@Autowired
	private PropiedadService servicioPropiedades;

	@Autowired
	private CiudadService servicioCiudad;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		modelo.addAttribute("formBean", new PublicacionesBuscarForm());
		return "publicacionesBuscar";
	}

	@ModelAttribute("allPropiedades")
	public List<Propiedad> getAllPropiedades() {
		return servicioPropiedades.getAll();
	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return servicioCiudad.getAll();
	}

	@ModelAttribute("allEstados")
	public EstadoPublicacion[] getAllEstados() {
		return EstadoPublicacion.values();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") PublicacionesBuscarForm formBean,
			BindingResult result, ModelMap modelo, @RequestParam String action) throws Excepcion {

		if (action.equals("actionBuscar")) {
			try {
				List<Publicacion> publicaciones = servicioPublicaciones.filter(formBean);
				modelo.addAttribute("resultados", publicaciones);
			} catch (Exception e) {
				result.addError(new ObjectError("globalError", e.getMessage()));
			}
			modelo.addAttribute("formBean", formBean);
			return "publicacionesBuscar";
		} else if (action.equals("actionCancelar")) {
			modelo.clear();
			return "redirect:/";
		} else if (action.equals("actionRegistrar")) {
			modelo.clear();
			return "redirect:/publicacionEditar";
		}
		return "redirect:/";
	}
}
