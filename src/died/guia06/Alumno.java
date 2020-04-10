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
	
	
	
	
	public int creditosObtenidos() {
		int creditos = 0;
		for(Curso a: aprobados) {
			creditos += a.getCreditos();
		}
		return creditos;
	}

	
	public void aprobar(Curso c) {
		this.aprobados.add(c);
		this.cursando.remove(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	

	public boolean puedeRegistrarseCreditos(int creditosRequeridos) {
		if(this.creditosObtenidos() > creditosRequeridos) return true;
		return false;		
	}

	public int materiasCursando() {
		return this.cursando.size();
	}
	
	public boolean puedeRegistrarseCantMaterias() {
		if(this.cursando.size() < 3) return true;
		return false;
	}
	
	
	public boolean equals(Alumno a2) {
		if(this.nroLibreta == a2.nroLibreta) return true;
				return false;
	}
	
	
	@Override
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}
	
	
}