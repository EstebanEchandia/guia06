package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	
	
	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	@Override 
	public int compare(Alumno a1, Alumno a2) {
		return a1.getNombre().compareTo(a2.getNombre());
	}

	public int creditosObtenidos() {
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}
	
	public boolean equals(Alumno a2) {
		if(this.nroLibreta == a2.nroLibreta) return true;
				return false;
	}
	

}
