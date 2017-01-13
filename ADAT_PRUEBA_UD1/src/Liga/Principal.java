package Liga;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
		System.out.println("Comienza");
		bbdd base = new bbdd();
		Scanner teclado = new Scanner(System.in);
		

		int op = 0; // Opcion
		boolean salir = false;
		
		while (!salir) { // Estructura que repite el algoritmo del menu principal hasta que se la condicion sea falsa
			// Se muestra el menu principal
			System.out.println(".......................... \n" 
							+  ".  1 Clasificacion  \n"
							+  ".  2 Todos los jugadores \n" 
							+  ".  3 Jugadores por equipo \n" 
							+  ".  4 Informe salario \n" 
							+  ".  5 Salir \n" 
							+  "..........................");
			try{
				op = teclado.nextInt(); // Se le da a la variable op el valor del teclado
				System.out.println("OPCION SELECCIONADA:" + op);
				switch (op) {
					case 1:// Insertar Moneda
						base.Clasificacion();
						break;
					case 2:// Retornar Monedas
						base.Jugadores();
						break;
					case 3:
						base.JugadoresPorEquipo();
						break;
					case 4:
						base.salario();
						break;
					case 5:
						salir = true;
						break;
					default:// No valido
						System.out.println("Opcion invalida: marque un numero de 1 a 7");
						break;
				}
			}catch (Exception e) {
				System.out.println("Excepcion por opcion invalida: marque un numero de 1 a 7");
	            // flushing scanner
				//e.printStackTrace();
				teclado.next();
			}
		}
		
		
		
		System.out.println("Termina");
	}

}
