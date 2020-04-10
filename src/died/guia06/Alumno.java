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
	
	
	
	//testeada
	public int creditosObtenidos() {
		int creditos = 0;
		for(Curso a: aprobados) {
			creditos += a.getCreditos();
		}
		return creditos;
	}

	//testeado
	public void aprobar(Curso c) {
		this.aprobados.add(c);
		this.cursando.remove(c);
	}

	
	//testeado
	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	
	//testeada
	public boolean puedeRegistrarseCreditos(int creditosRequeridos) {
		if(this.creditosObtenidos() > creditosRequeridos) return true;
		return false;		
	}
	
	//testeada
	public boolean puedeRegistrarseCantMaterias() {
		if(this.cursando.size() < 3) return true;
		return false;
	}
	
	public boolean equals(Alumno a2) {
		if(this.nroLibreta == a2.nroLibreta) return true;
				return false;
	}
	
	
	//testeo?
	public int materiasCursando() {
		return this.cursando.size();
	}

	
	
	
	@Override
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}
	
	
	
}