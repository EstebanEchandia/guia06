
package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CursoTest {
	
	//El before me tiraba null pointer exception :/
	private final Alumno a1 = new Alumno("Pedro",2243,10);
	private final Alumno a2 = new Alumno("Alfonso",2456,5);
	private final Alumno a3 = new Alumno("Rodrigo",2031,30);
	private final Alumno a4 = new Alumno("Lucio",2032,30);
	
	private final Curso sintaxis = new Curso(400, "sintaxis", 2020, 2, 6, 6);
	private final Curso died = new Curso(400, "died", 2020, 40, 6, 10);
	private final Curso comunicaciones = new Curso(400, "comunicaciones", 2020, 30, 6, 8);
	private final Curso superior = new Curso(400, "superior", 2020, 20, 6, 10);

	


	@Test
	public void testInscribirFunciona() {
		assertTrue(sintaxis.inscribir(a1));
	}
	
	@Test
	public void testInscribirFallaCantCreditos() {
		assertFalse(sintaxis.inscribir(a2));
	}
	
	@Test
	public void testInscribirFallaCupo() {
		
		sintaxis.inscribir(a1);
		sintaxis.inscribir(a3);
		assertFalse(sintaxis.inscribir(a4));
		
	}
	

	@Test
	public void testInscribirFallaCantMaterias() {
		
		sintaxis.inscribir(a1);
		died.inscribir(a1);
		comunicaciones.inscribir(a1);
		assertFalse(superior.inscribir(a1));
		
	}
	

	@Test
	public void testInscribirImprimirAlfabetico() {
		
		List<Alumno> comparacion = new ArrayList<Alumno>();
		
		comparacion.add(a4);
		comparacion.add(a1);
		comparacion.add(a3);
	
		comunicaciones.inscribir(a1);
		comunicaciones.inscribir(a3);
		comunicaciones.inscribir(a4);
		
		comunicaciones.imprimirInscriptos(Orden.ALFABETICAMENTE);
		
		assertEquals(comparacion, comunicaciones.getInscriptos());
		
	}
	
	
	@Test
	public void testInscribirImprimirLibreta() {
		
		List<Alumno> comparacion = new ArrayList<Alumno>();
		
		comparacion.add(a3);
		comparacion.add(a4);
		comparacion.add(a1);
	
		comunicaciones.inscribir(a1);
		comunicaciones.inscribir(a3);
		comunicaciones.inscribir(a4);
		
		comunicaciones.imprimirInscriptos(Orden.LIBRETA);
		
		assertEquals(comparacion, comunicaciones.getInscriptos());
		
	}
	

}
