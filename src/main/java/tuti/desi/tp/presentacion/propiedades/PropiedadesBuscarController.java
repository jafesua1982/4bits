package tuti.desi.tp.presentacion.propiedades;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tuti.desi.tp.entidades.Ciudad;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.TipoPropiedad;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.servicios.CiudadService;
import tuti.desi.tp.servicios.PropiedadService;

@Controller
@RequestMapping("/propiedadesBuscar")
public class PropiedadesBuscarController {

	@Autowired
	private PropiedadService servicioPropiedades;

	@Autowired
	private CiudadService servicioCiudad;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		modelo.addAttribute("formBean", new PropiedadesBuscarForm());
		return "propiedadesBuscar";
	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return servicioCiudad.getAll();
	}

	@ModelAttribute("allTipos")
	public TipoPropiedad[] getAllTipos() {
		return TipoPropiedad.values();
	}

	@ModelAttribute("allEstados")
	public EstadoDisponibilidad[] getAllEstados() {
		return EstadoDisponibilidad.values();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") PropiedadesBuscarForm formBean,
			BindingResult result, ModelMap modelo, @RequestParam String action) throws Excepcion {

		if (action.equals("actionBuscar")) {
			try {
				List<Propiedad> propiedades = servicioPropiedades.filter(formBean);
				modelo.addAttribute("resultados", propiedades);
			} catch (Exception e) {
				result.addError(new ObjectError("globalError", e.getMessage()));
			}
			modelo.addAttribute("formBean", formBean);
			return "propiedadesBuscar";
		} else if (action.equals("actionCancelar")) {
			modelo.clear();
			return "redirect:/";
		} else if (action.equals("actionRegistrar")) {
			modelo.clear();
			return "redirect:/propiedadEditar";
		}
		return "redirect:/";
	}
}