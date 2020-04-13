package died.guia06;

import java.util.Comparator;

public class ComparatorAlumnoNroLibreta implements Comparator<Alumno>{

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return a1.getNroLibreta().compareTo(a2.getNroLibreta());
	}
}

