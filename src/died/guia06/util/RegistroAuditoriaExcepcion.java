package died.guia06.util;

public class RegistroAuditoriaExcepcion extends Exception {
	public RegistroAuditoriaExcepcion() {
		super("El registro fallo, no se pudo registrar");
	}
}
