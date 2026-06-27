package tuti.desi.tp.presentacion.personas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tuti.desi.tp.entidades.Ciudad;
import tuti.desi.tp.entidades.Persona;
import tuti.desi.tp.servicios.CiudadService;
import tuti.desi.tp.servicios.PersonaService;

@Controller
@RequestMapping("/personasBuscar")
public class PersonasBuscarController {

	@Autowired
	private PersonaService servicioPersona;
	
	@Autowired
	private CiudadService servicioCiudad;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		modelo.addAttribute("formBean", new PersonasBuscarForm());
		return "personasBuscar";
	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return servicioCiudad.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(PersonasBuscarForm formBean, BindingResult result,
			ModelMap modelo, @RequestParam String action) {

		if (action.equals("Buscar")) {
			List<Persona> personas = servicioPersona.filter(formBean);
			modelo.addAttribute("formBean", formBean);
			modelo.addAttribute("resultados", personas);
			return "personasBuscar";
		}
		
		if (action.equals("Cancelar")) {
			modelo.clear();
			return "redirect:/";
		}
		
		if (action.equals("Registrar")) {
			modelo.clear();
			return "redirect:/personasEditar";
		}
		
		return "redirect:/";
	}
}