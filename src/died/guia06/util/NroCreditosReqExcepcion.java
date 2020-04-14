/**
 * 
 */
package died.guia06.util;

/**
 * @author Esteban
 *
 */
public class NroCreditosReqExcepcion extends Exception {
	public NroCreditosReqExcepcion() {
		super("La cantidad de creditos del alumno no es suficiente para este curso");
	}

}
