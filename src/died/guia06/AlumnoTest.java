package died.guia06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlumnoTest{
	

	public Alumno a1;
	public Curso died;
	public Curso gestion;
	public Curso economia;
	public Curso comunicaciones;

	@Before
	public void setUp() {
		
		a1 = new Alumno("Pedro",2243);
		died = new Curso(123, "DIED",2020, 100, 6, 20);
		gestion = new Curso(124, "Gestion de Datos",2020, 60, 8, 22);
		comunicaciones = new Curso(126, "Comunicaciones",2020, 30, 10, 10);
		economia = new Curso(128, "Economia",2020, 40, 4, 42);

		}
		
	@Test
	public void testCreditosObtenidos() {

		gestion.inscribir(a1);
		died.inscribir(a1);
		a1.aprobar(died);
		a1.aprobar(gestion);
		
		int creditosObt = a1.creditosObtenidos();
		assertEquals(14,creditosObt);
	}
	
	
	@Test
	public void testAprobar() {
		died.inscribir(a1);
		a1.aprobar(died);
		boolean aproboDied = a1.getAprobados().contains(died);
		assertTrue(aproboDied);	
	}
	
	@Test
	public void testAprobarEliminarCursado() {
		gestion.inscribir(a1);
		a1.aprobar(gestion);
		boolean cursaGestion = a1.getCursando().contains(gestion);
		assertFalse(cursaGestion);	
	}

	@Test
	public void testInscripcionAceptada() {
		died.inscribir(a1);
		boolean estaCursandoDied = a1.getCursando().contains(died);
		assertTrue(estaCursandoDied);
	}
	
	@Test
	public void testInscripcionNoAceptada() {
		
		died.inscribir(a1);
		a1.aprobar(died);
		
		boolean estaCursandoDied = a1.getCursando().contains(died);
		assertFalse(estaCursandoDied);
	}
	
	@Test
	public void testPuedeRegistrarCreditos() {
		died.inscribir(a1);
		gestion.inscribir(a1);
		
		a1.aprobar(died);
		a1.aprobar(gestion);
		//creditos hasta aca son 14
		
		boolean puedeRegistrarse = a1.puedeRegistrarseCreditos(13);
		assertTrue(puedeRegistrarse);
	}
	
	@Test
	public void testNoPuedeRegistrarCreditos() {
		
		died.inscribir(a1);
		gestion.inscribir(a1);
		
		a1.aprobar(died);
		a1.aprobar(gestion);
		
		//creditos hasta aca son 14
		
		boolean puedeRegistrarse = a1.puedeRegistrarseCreditos(20);
		assertTrue(puedeRegistrarse);
	}
	
	@Test
	public void testPuedeRegistrarCantidadMaterias() {
		died.inscribir(a1);
		gestion.inscribir(a1);
		
		boolean puedeInscribirse = a1.puedeRegistrarseCantMaterias();
		assertTrue(puedeInscribirse);
	}
	
	@Test
	public void testNoPuedeRegistrarCantidadMaterias() {
		died.inscribir(a1);
		gestion.inscribir(a1);
		economia.inscribir(a1);
		comunicaciones.inscribir(a1);
		
		
		boolean puedeInscribirse = a1.puedeRegistrarseCantMaterias();
		assertFalse(puedeInscribirse);
	}
	
	@Test 
	public void testEquals() {
		Alumno a2 = new Alumno("Pedro",2243);
		boolean iguales = a1.equals(a2);
		assertTrue(iguales);

	}
	@Test 
	public void testNoEquals() {
		Alumno a2 = new Alumno("Pedro",2283);
		boolean iguales = a1.equals(a2);
		assertFalse(iguales);
	}
	
	

}
