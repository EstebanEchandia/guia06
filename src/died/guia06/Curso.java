package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;

import died.guia06.util.CantMateriasCursandoExcepcion;
import died.guia06.util.CupoLlenoExcepcion;
import died.guia06.util.NroCreditosReqExcepcion;
import died.guia06.util.Registro;
import died.guia06.util.RegistroAuditoriaExcepcion;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

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
	
	public Curso(Integer id,String nombre,Integer cicloLec,Integer cupo, 
			Integer cred,Integer credReq) {
		this.id=id;
		this.nombre=nombre;
		this.cicloLectivo=cicloLec;
		this.cupo=cupo;
		this.creditos=cred;
		this.creditosRequeridos=credReq;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}

	public Integer getCreditos() {
		return creditos;
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
	
	
	
	
	public Boolean inscribir(Alumno a){
		
		try {
			if(a.puedeRegistrarseCreditos(creditosRequeridos) && (inscriptos.size() < this.cupo) && 
					a.puedeRegistrarseCantMaterias()) {
				
				log.registrar(this, "inscribir ",a.toString());
				inscriptos.add(a);
				a.inscripcionAceptada(this);
				
				return true;
			}
		
		} catch (IOException e) {
			System.out.println("error registrando, vuelva a intentar");
			return false;
		} 
		
		return false;
	}
	
	
	public void inscribirConExcepciones(Alumno a) throws CantMateriasCursandoExcepcion, CupoLlenoExcepcion,NroCreditosReqExcepcion, RegistroAuditoriaExcepcion{
		if(!(a.puedeRegistrarseCreditos(creditosRequeridos))) throw new NroCreditosReqExcepcion();
		if(inscriptos.size() >= this.cupo) throw new CupoLlenoExcepcion();
		if(!(a.puedeRegistrarseCantMaterias())) throw new CantMateriasCursandoExcepcion();
		try {
			log.registrar(this, "inscribir ",a.toString());
			inscriptos.add(a);
			a.inscripcionAceptada(this);
			
			
		}
		catch(IOException Excep) {
			throw new RegistroAuditoriaExcepcion();
		}
		
	}
	
	/**
	 * imprime los inscriptos en el orden pasado como argumento, Alfabeticamente o nroLibreta.
	 */
	public void imprimirInscriptos(Orden orden) {
		try {
			
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			
			switch(orden) {
			case ALFABETICAMENTE:
				Collections.sort(inscriptos);
				break;
				
			case LIBRETA:
				Collections.sort(inscriptos, new ComparatorAlumnoNroLibreta());
				break;
			}
			
			int j=0;
			for(Alumno a: inscriptos) {
				System.out.println(j+") "+a.toString());
				j++;
				
			}
			
		} catch (IOException e) {
			
			System.out.println("ERROR IMPRIMIENDO");
			e.printStackTrace();
		}
	}





	public List<Alumno> getInscriptos() {
		return inscriptos;
	}


}
