package tuti.desi.tp.presentacion.publicaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import tuti.desi.tp.entidades.Propiedad;
import tuti.desi.tp.entidades.Publicacion;
import tuti.desi.tp.entidades.enums.EstadoDisponibilidad;
import tuti.desi.tp.entidades.enums.EstadoPublicacion;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.servicios.PropiedadService;
import tuti.desi.tp.servicios.PublicacionService;
import tuti.desi.tp.presentacion.propiedades.PropiedadesBuscarForm;

@Controller
@RequestMapping("/publicacionEditar")
public class PublicacionRegistrarEditarController {

	@Autowired
	private PublicacionService servicioPublicaciones;

	@Autowired
	private PropiedadService servicioPropiedades;

	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.GET)
	public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
		if (id.isPresent())
			modelo.addAttribute("formBean", new PublicacionForm(servicioPublicaciones.getById(id.get())));
		else
			modelo.addAttribute("formBean", new PublicacionForm());
		return "publicacionEditar";
	}

	@ModelAttribute("allPropiedades")
	public List<Propiedad> getAllPropiedades() {
		return servicioPropiedades.getAll();
	}

	@ModelAttribute("propiedadesDisponibles")
	public List<Propiedad> getPropiedadesDisponibles() {
		PropiedadesBuscarForm f = new PropiedadesBuscarForm();
		f.setEstado(EstadoDisponibilidad.DISPONIBLE);
		return servicioPropiedades.filter(f);
	}

	@ModelAttribute("allEstados")
	public EstadoPublicacion[] getAllEstados() {
		return EstadoPublicacion.values();
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		try {
			servicioPublicaciones.deleteById(id);
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		return "redirect:/publicacionesBuscar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid PublicacionForm formBean,
			BindingResult result, ModelMap modelo, @RequestParam String action) {

		if (action.equals("actionAceptar")) {
			if (result.hasErrors()) {
				modelo.addAttribute("formBean", formBean);
				return "publicacionEditar";
			} else {
				try {
					Publicacion pub = formBean.toPojo();
					pub.setPropiedad(servicioPropiedades.getById(formBean.getIdPropiedad()));
					servicioPublicaciones.save(pub);
					return "redirect:/publicacionesBuscar";
				} catch (Excepcion e) {
					if (e.getAtributo() == null)
						result.addError(new ObjectError("globalError", e.getMessage()));
					else
						result.addError(new FieldError("formBean", e.getAtributo(), e.getMessage()));
					modelo.addAttribute("formBean", formBean);
					return "publicacionEditar";
				}
			}
		} else if (action.equals("actionCancelar")) {
			modelo.clear();
			return "redirect:/publicacionesBuscar";
		}
		return "redirect:/";
	}
}
