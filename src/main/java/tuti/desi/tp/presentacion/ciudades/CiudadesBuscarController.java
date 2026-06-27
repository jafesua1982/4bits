package tuti.desi.tp.presentacion.ciudades;

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
import jakarta.validation.Valid;
import tuti.desi.tp.entidades.Ciudad;
import tuti.desi.tp.entidades.Provincia;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.servicios.CiudadService;
import tuti.desi.tp.servicios.ProvinciaService;

@Controller
@RequestMapping("/ciudadesBuscar")
public class CiudadesBuscarController {

	@Autowired
	private ProvinciaService servicioProvincias;
	
	@Autowired
	private CiudadService servicioCiudad;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		CiudadesBuscarForm form = new CiudadesBuscarForm();
		form.setProvincias(servicioProvincias.getAll());
		modelo.addAttribute("formBean", form);
		return "ciudadesBuscar";
	}

	@ModelAttribute("allProvincias")
	public List<Provincia> getAllProvincias() {
		return servicioProvincias.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid CiudadesBuscarForm formBean,
			BindingResult result, ModelMap modelo, @RequestParam String action) throws Excepcion {

		if (action.equals("actionBuscar")) {
			try {
				List<Ciudad> ciudades = servicioCiudad.filter(formBean);
				modelo.addAttribute("resultados", ciudades);
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
				result.addError(error);
			}
			modelo.addAttribute("formBean", formBean);
			return "ciudadesBuscar";
		} else if (action.equals("actionCancelar")) {
			modelo.clear();
			return "redirect:/";
		} else if (action.equals("actionRegistrar")) {
			modelo.clear();
			return "redirect:/ciudadEditar";
		}
		return "redirect:/";
	}
}