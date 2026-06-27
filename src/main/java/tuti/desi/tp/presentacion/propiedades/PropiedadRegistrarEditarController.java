package tuti.desi.tp.presentacion.propiedades;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import tuti.desi.tp.entidades.Ciudad;
import tuti.desi.tp.entidades.Persona;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.TipoPropiedad;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.servicios.CiudadService;
import tuti.desi.tp.servicios.PersonaService;
import tuti.desi.tp.servicios.PropiedadService;

@Controller
@RequestMapping("/propiedadEditar")
public class PropiedadRegistrarEditarController {

	@Autowired
	private PropiedadService servicioPropiedades;

	@Autowired
	private CiudadService servicioCiudad;

	@Autowired
	private PersonaService servicioPersona;

	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.GET)
	public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
		if (id.isPresent())
			modelo.addAttribute("formBean", new PropiedadForm(servicioPropiedades.getById(id.get())));
		else
			modelo.addAttribute("formBean", new PropiedadForm());
		return "propiedadEditar";
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

	@ModelAttribute("allPersonas")
	public List<Persona> getAllPersonas() {
		return servicioPersona.getAll();
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		try {
			servicioPropiedades.deleteById(id);
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		return "redirect:/propiedadesBuscar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid PropiedadForm formBean,
			BindingResult result, ModelMap modelo, @RequestParam String action) {

		if (action.equals("actionAceptar")) {
			if (result.hasErrors()) {
				modelo.addAttribute("formBean", formBean);
				return "propiedadEditar";
			} else {
				try {
					Propiedad p = formBean.toPojo();
					p.setCiudad(servicioCiudad.getById(formBean.getIdCiudad()));
					p.setPropietario(servicioPersona.getById(formBean.getIdPropietario()));
					servicioPropiedades.save(p);
					return "redirect:/propiedadesBuscar";
				} catch (Excepcion e) {
					if (e.getAtributo() == null)
						result.addError(new ObjectError("globalError", e.getMessage()));
					else
						result.addError(new FieldError("formBean", e.getAtributo(), e.getMessage()));
					modelo.addAttribute("formBean", formBean);
					return "propiedadEditar";
				}
			}
		} else if (action.equals("actionCancelar")) {
			modelo.clear();
			return "redirect:/propiedadesBuscar";
		}
		return "redirect:/";
	}
}