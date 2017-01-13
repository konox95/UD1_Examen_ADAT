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
							+  ".  1 Leer de teclado y escribir en fichero  \n"
							+  ".  2 Leer de fichero y escribir en pantalla \n" 
							+  ".  3 Leer de fichero y escribir en bbdda \n" 
							+  ".  7 Salir \n" 
							+  "..........................");
			try{
				op = teclado.nextInt(); // Se le da a la variable op el valor del teclado
				System.out.println("OPCION SELECCIONADA:" + op);
				switch (op) {
					case 1:// Insertar Moneda
						base.Jugadores();
						break;
					case 2:// Retornar Monedas
						
						break;
					case 3:
						
						break;
					case 4:
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
