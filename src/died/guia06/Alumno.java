package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	private Integer creditos;

	
	
	public Alumno(String nombre, Integer nroLibreta, Integer creditos) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
		this.creditos = creditos;
	}
	
	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
		
	}
	
	
	
	//testeada
	public int creditosObtenidos() {
		for(Curso a: aprobados) {
			if(a != null) this.creditos += a.getCreditos();
			
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

	
	
	
	public String getNombre() {
		return nombre;
	}



	public Integer getNroLibreta() {
		return nroLibreta;
	}



	@Override
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}
	
	public String toString() {
		return this.nombre;
	}
	
	

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}
	
	
	
}