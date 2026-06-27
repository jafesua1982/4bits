package tuti.desi.tp.presentacion.provincias;

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
import tuti.desi.tp.entidades.Provincia;
import tuti.desi.tp.excepciones.Excepcion;
import tuti.desi.tp.servicios.ProvinciaService;

@Controller
@RequestMapping("/provinciaEditar")
public class ProvinciaRegistrarEditarController {

	@Autowired
	private ProvinciaService servicioProvincia;

	@RequestMapping(path = {"", "/{id}"}, method = RequestMethod.GET)
	public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
		if (id.isPresent()) {
			Provincia entity = servicioProvincia.getById(id.get());
			modelo.addAttribute("formBean", entity);
		} else {
			modelo.addAttribute("formBean", new Provincia());
		}
		return "provinciaEditar";
	}

	@ModelAttribute("allProvincias")
	public List<Provincia> getAllProvincias() {
		return this.servicioProvincia.getAll();
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		servicioProvincia.deleteByid(id);
		return "redirect:/provinciasBuscar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid Provincia formBean,
			BindingResult result, ModelMap modelo, @RequestParam String action) {

		if (action.equals("actionAceptar")) {
			if (result.hasErrors()) {
				modelo.addAttribute("formBean", formBean);
				return "provinciaEditar";
			} else {
				try {
					servicioProvincia.save(formBean);
					return "redirect:/provinciasBuscar";
				} catch (Excepcion e) {
					if (e.getAtributo() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
						result.addError(error);
					} else {
						FieldError error = new FieldError("formBean", e.getAtributo(), e.getMessage());
						result.addError(error);
					}
					modelo.addAttribute("formBean", formBean);
					return "provinciaEditar";
				}
			}
		} else if (action.equals("actionCancelar")) {
			modelo.clear();
			return "redirect:/provinciasBuscar";
		}
		return "redirect:/";
	}
}