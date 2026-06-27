package tuti.desi.tp.presentacion.ciudades;

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
import tuti.desi.tp.entidades.Provincia;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.servicios.CiudadService;
import tuti.desi.tp.servicios.ProvinciaService;

@Controller
@RequestMapping("/ciudadEditar")
public class CiudadRegistrarEditarController {

	@Autowired
	private CiudadService servicioCiudad;
	
	@Autowired
	private ProvinciaService servicioProvincias;

	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.GET)
	public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
		if (id.isPresent()) {
			Ciudad entity = servicioCiudad.getById(id.get());
			modelo.addAttribute("formBean", new CiudadForm(entity));
		} else {
			modelo.addAttribute("formBean", new CiudadForm());
		}
		return "ciudadEditar";
	}

	@ModelAttribute("allProvincias")
	public List<Provincia> getAllProvincias() {
		return servicioProvincias.getAll();
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		servicioCiudad.deleteByid(id);
		return "redirect:/ciudadesBuscar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid CiudadForm formBean,
			BindingResult result, ModelMap modelo, @RequestParam String action) {

		if (action.equals("actionAceptar")) {
			if (result.hasErrors()) {
				modelo.addAttribute("formBean", formBean);
				return "ciudadEditar";
			} else {
				try {
					Ciudad c = formBean.toPojo();
					c.setProvincia(servicioProvincias.getById(formBean.getIdProvincia()));
					servicioCiudad.save(c);
					return "redirect:/ciudadesBuscar";
				} catch (Excepcion e) {
					if (e.getAtributo() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
						result.addError(error);
					} else {
						FieldError error = new FieldError("formBean", e.getAtributo(), e.getMessage());
						result.addError(error);
					}
					modelo.addAttribute("formBean", formBean);
					return "ciudadEditar";
				}
			}
		} else if (action.equals("actionCancelar")) {
			modelo.clear();
			return "redirect:/ciudadesBuscar";
		}
		return "redirect:/";
	}
}