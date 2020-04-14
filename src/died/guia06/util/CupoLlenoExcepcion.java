package died.guia06.util;

public class CupoLlenoExcepcion extends Exception {
	public CupoLlenoExcepcion() {
		super("El cupo del curso esta lleno, no se puede inscribir a mas alumnos.");
	}
}
