package tuti.desi.tp.presentacion.personas;

public class PersonasBuscarForm {

	private String dniCuit;
	private String nombre;

	public String getDniCuit() {
		if (dniCuit != null && dniCuit.length() > 0)
			return dniCuit;
		else
			return null;
	}

	public void setDniCuit(String dniCuit) {
		this.dniCuit = dniCuit;
	}

	public String getNombre() {
		if (nombre != null && nombre.length() > 0)
			return nombre;
		else
			return null;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}