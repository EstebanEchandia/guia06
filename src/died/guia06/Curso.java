package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso implements ComparatorAlumno{

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	
	
	
	
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, Integer creditos,
			Integer creditosRequeridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}





	public Integer getCreditos() {
		return creditos;
	}



	public boolean quedaCupo() {
		if(this.inscriptos.size() > this.cupo) return true;
		return false;
	}

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		
		if(a.puedeRegistrarseCreditos(this.creditosRequeridos) && this.quedaCupo() && a.puedeRegistrarseCantMaterias()) {
			try {
				log.registrar(this, "inscribir ",a.toString());
				a.inscripcionAceptada(this);
				this.inscriptos.add(a);
			
			} catch (IOException e) {
				
				System.out.println("Fallo el metodo y tiro el error: "+ e);
				e.printStackTrace();
				return false;
			}
	
			return true;
		
		}
		
		return false;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			
			
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			
			Collections.sort(inscriptos, new Comparator<Alumno>() {
				@Override
				public int compare(Alumno a1, Alumno a2) {
					return a1.getNombre().compareTo(a2.getNombre());
				}
				
			});
			int i = 0;
			for(Alumno a: inscriptos) {
				
				System.out.println(i+"�)"+inscriptos.get(i));
				i++;
			}
			
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
	}


}
