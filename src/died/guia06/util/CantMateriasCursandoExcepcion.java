package died.guia06.util;

public class CantMateriasCursandoExcepcion extends Exception {
	public CantMateriasCursandoExcepcion() {
		super("La cantidad de materias cursando este a�o lectivo ya alcanzo su maximo, no se puede inscirbir.");
	}
}
