package died.guia06;

public class App {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno("Pedro",2243,50);
		Alumno a2 = new Alumno("Alfonso",2456,15);
		Alumno a3 = new Alumno("Rodrigo",2031,30);
		Alumno a4 = new Alumno("Lucio",2035,30);
		
		Curso sintaxis = new Curso(400, "sintaxis", 2020, 5, 2, 2);
		Curso died = new Curso(400, "died", 2020, 40, 6, 10);
		Curso comunicaciones = new Curso(400, "comunicaciones", 2020, 30, 6, 8);
		Curso superior = new Curso(400, "superior", 2020, 20, 6, 10);
		
		sintaxis.inscribir(a1);
		sintaxis.inscribir(a2);
		sintaxis.inscribir(a3);
		sintaxis.inscribir(a4);

		sintaxis.imprimirInscriptos(Orden.ALFABETICAMENTE);

		
		
	}
}
