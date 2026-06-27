package tuti.desi.tp.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadNoEncontradaException extends RuntimeException {

	public EntidadNoEncontradaException(String entidad, Object id) {
		super("No existe " + entidad + " con id=" + id);
	}
}