package died.guia06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlumnoTest {

	@Test
	public void testCreditosObtenidos() {
		
		Alumno a1 = new Alumno("Pedro",2243);
		Curso died = new Curso(123, "DIED",2020, 100, 6, 20);
		died.inscribir(a1);
		a1.aprobar(died);
		
		int creditosObt = a1.creditosObtenidos();
		assertEquals(6,creditosObt);
		
		
	}
	
	@Test
	public void testPuedeRegistrarseCreditos() {
		
		
		
	}
	
	
	
}
