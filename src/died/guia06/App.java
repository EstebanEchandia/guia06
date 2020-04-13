package died.guia06;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		Alumno a1 = new Alumno("Pedro",2243);
		Alumno a2 = new Alumno("Alfonso",2456);
		Alumno a3 = new Alumno("Rodrigo",2031);
		Alumno a4 = new Alumno("Lucio",2035);
		
		//	new Curso(id, nombre, cicloLec, cupo, cred, credReq);
	
		Curso discreta = new Curso(2, "MatDiscreta", 2019, 30, 20, 0);
		Curso sintaxis = new Curso(150, "Sintaxis", 2020, 30, 2, 10);
		Curso died = new Curso(30, "Died", 2020, 20, 6, 10);
		Curso comunicaciones = new Curso(20, "Comunicaciones", 2020, 30, 6, 12);
		Curso superior = new Curso(88, "Superior", 2020, 20, 6, 14);
		
		boolean i1 = discreta.inscribir(a1);
		boolean i2 = discreta.inscribir(a2);
		boolean i3 = discreta.inscribir(a3);
		boolean i4 = discreta.inscribir(a4);
		
		System.out.println("Verificando que se inscribieron los alumnos a1:"+i1+" a2:"+i2+" a3:"+i3+" a4:"+i4);
		System.out.println("\nImprimiendo en orden alfabetico");
		discreta.imprimirInscriptos(Orden.ALFABETICAMENTE);
	
		System.out.println("\nImprimiendo por Nro Libreta");
		discreta.imprimirInscriptos(Orden.LIBRETA);
		
		System.out.println("\nPodemos ver las materias que esta cursando a1 en este momento: "+a1.getCursando().size());
		System.out.println("Podemos ver las materias aprobadas de a1 en este momento: "+a1.getAprobados().size());
		System.out.println();
		System.out.println("Si aprobamos discreta en a1");
		a1.aprobar(discreta);
		System.out.println("\nPodemos ver las materias que esta cursando a1 en este momento: "+a1.getCursando().size());
		System.out.println("Podemos ver las materias aprobadas de a1 en este momento: "+a1.getAprobados().size());
		System.out.println("Podemos ver la cantidad de creditos de a1: "+a1.creditosObtenidos());
		
		System.out.println("\nTratando de inscribir sin tener los creditos, a1 en sintaxis: "+sintaxis.inscribir(a1));
		System.out.println();
		System.out.println("Si inscribimos 25 alumnos en superior, que tiene un cupo de 20");
		for(int i = 0; i<25;i++) {
			int nroLibreta= r.nextInt(1000);
			superior.inscribir(new Alumno("Marcos", nroLibreta, 15));
		}
		System.out.println("Tratando de inscribir sin tener cupo, a2 en Superior: "+sintaxis.inscribir(a1));
		
		
		System.out.println("Si aprobamos discreta en a1");
		a1.aprobar(discreta);
	}
}
