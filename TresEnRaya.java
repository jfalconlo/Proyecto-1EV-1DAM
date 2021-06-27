import java.util.Arrays;
import java.util.Scanner;

public class TresEnRaya {

	static String[] tablero; // Iniciamos el array el cual va a albergar el tablero fuera del main para que
								// asin pueda ser vista por los métodos.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Iniciamos el Scanner para poder introducir valores por teclado en el
												// terminal
		String ganador = null;// Creamos la variable ganador la cual se usara para definir si hay un ganador o
								// no.
		boolean[] verificarPosicion = new boolean[9]; // El array de verificarPosicion como su nombre dice nos servirá
														// para que un jugador no pueda poner su ficha en una casilla ya
														// ocupada
		tablero = new String[9]; // Creamos ahora si el tablero en este caso de 9 posiciones es decir un 3x3
		System.out.println("Bienvenido al Juego del Tres en Raya");
		System.out.println("------------------------------------");
		rellenarTablero(); // LLamamos al método el cual se va a encargar de rellenar el tablero. Esto
							// sucederá cada vez que iniciemos el juego.
		tablero();// Mediante este método se mostrara por pantalla el dibujo del tablero
		System.out.println("Seleccione su modo de juego");
		System.out.println("1.Un Jugador");
		System.out.println("2.Multijugador");
		Scanner sc1 = new Scanner(System.in);
		int modojuego = sc1.nextInt(); // Y ahora creamos la variable de modo de juego la cual nos permitirá jugar
										// contra la IA o contra otro juzgador.

		if (modojuego == 1) {

			System.out.println("Empieza el Jugador X");
			tablero();
			System.out.println("Introduzca un numero del 1 al 9");
			int posicionvsIA = sc.nextInt();
			while (posicionvsIA < 1 || posicionvsIA > 9 || verificarPosicion[posicionvsIA - 1] == true) { // Este bucle
																											// se
																											// encargara
																											// de
																											// recordarnos
																											// que si no
																											// hemos
																											// escrito
																											// una
																											// casilla
																											// correcta
																											// o que
																											// esta
																											// ocupada
																											// que
																											// introduzcamos
																											// otra
																											// casilla.
				System.out.println("Asegúrese que la casilla no este en uso");
				System.out.println("Introduzca un numero del 1 al 9");
				posicionvsIA = sc.nextInt();
			}
			tablero[posicionvsIA - 1] = "X"; // Que la posición la escribe bien y no hay ningún problema sigue el juego
												// escribiendo X en el tablero y en el de verificación escribe true.
			verificarPosicion[posicionvsIA - 1] = true;
			tablero();
			ganador = verificarGanador(); // Verificamos si hay ganador mediante este método y le asignamos el valor que
											// devuelve el método a la variable ganador la cual se encargara de cortar el
											// juego en caso de que allá ganador.

			while (ganador == null) { // Básicamente el juego es asin todo el rato te pide un numero que esta mal te
										// pide que lo introduzcas bien y cuando lo escriben bien escribe la ficha en el
										// array y en el otro array escribe un true todo esto para que no se puedan
										// poner fichas en el mismo sitio.
				System.out.println("Turno de la maquina jugador O");
				posicionvsIA = (int) (Math.random() * 9 + 1);
				while (verificarPosicion[posicionvsIA - 1] == true) {
					posicionvsIA = (int) (Math.random() * 9 + 1);
				}

				tablero[posicionvsIA - 1] = "O";
				verificarPosicion[posicionvsIA - 1] = true;
				tablero();
				ganador = verificarGanador();

				System.out.println("Turno del jugador X");
				System.out.println("Introduzca un numero del 1 al 9");
				posicionvsIA = sc.nextInt();
				while (posicionvsIA < 1 || posicionvsIA > 9 || verificarPosicion[posicionvsIA - 1] == true) {
					System.out.println("Asegúrese que la casilla no este en uso");
					System.out.println("Introduzca un numero del 1 al 9");
					posicionvsIA = sc.nextInt();
				}
				tablero[posicionvsIA - 1] = "X";
				verificarPosicion[posicionvsIA - 1] = true;
				tablero();
				ganador = verificarGanador();
			}

			if (ganador.equalsIgnoreCase("empate")) { // Si la variable ganador recibe el valor empate se para el juego
														// para decir aque habido empate
				System.out.println("¡¡¡Empate!!! Gracias por jugar");
			} else {
				System.out.println("¡Felicidades! " + ganador + " has ganado la partida");// Si la variable ganador
																							// recibe el valor X ó O se
																							// para el juego para decir
																							// el ganador dle juego.
			}
		}

		else { // Segunda parte multijugador: Se basa en el mismo funcionamiento que en la
				// version contra la IA con la única diferencia de que hay un jugador en vez de
				// el ordenador.

			System.out.println("Empieza el Jugador X");
			tablero();
			System.out.println("Introduzca un numero del 1 al 9");
			int posicion = sc.nextInt();
			while (posicion < 1 || posicion > 9 || verificarPosicion[posicion - 1] == true) {
				System.out.println("Asegúrese que la casilla no este en uso");
				System.out.println("Introduzca un numero del 1 al 9");
				posicion = sc.nextInt();
			}
			tablero[posicion - 1] = "X";
			verificarPosicion[posicion - 1] = true;
			tablero();
			ganador = verificarGanador();

			while (ganador == null) {
				System.out.println("Turno del jugador O");
				System.out.println("Introduzca un numero del 1 al 9");
				posicion = sc.nextInt();
				while (posicion < 1 || posicion > 9 || verificarPosicion[posicion - 1] == true) {
					System.out.println("Asegúrese que la casilla no este en uso");
					System.out.println("Introduzca un numero del 1 al 9");
					posicion = sc.nextInt();
				}

				tablero[posicion - 1] = "O";
				verificarPosicion[posicion - 1] = true;
				tablero();
				ganador = verificarGanador();

				System.out.println("Turno del jugador X");
				System.out.println("Introduzca un numero del 1 al 9");
				posicion = sc.nextInt();
				while (posicion < 1 || posicion > 9 || verificarPosicion[posicion - 1] == true) {
					System.out.println("Asegúrese que la casilla no este en uso");
					System.out.println("Introduzca un numero del 1 al 9");
					posicion = sc.nextInt();
				}
				tablero[posicion - 1] = "X";
				verificarPosicion[posicion - 1] = true;
				tablero();
				ganador = verificarGanador();
			}

			if (ganador.equalsIgnoreCase("empate")) {
				System.out.println("¡¡¡Empate!!! Gracias por jugar");
			} else {
				System.out.println("¡Felicidades! " + ganador + " has ganado la partida");
			}

		}
	}

	static void tablero() { // Este método lo usare para mostrar en pantalla de manera mas fácil todo el
							// rato el tablero
		System.out.println("/---|---|---\\");
		System.out.println("| " + tablero[0] + " | " + tablero[1] + " | " + tablero[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + tablero[3] + " | " + tablero[4] + " | " + tablero[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + tablero[6] + " | " + tablero[7] + " | " + tablero[8] + " |");
		System.out.println("/---|---|---\\");
	}

	static void rellenarTablero() { // Este método lo usare para rellenar en array con los valores de cada casilla
									// antes de empezar la partida
		for (int a = 0; a < 9; a++) {
			tablero[a] = String.valueOf(a + 1);
		}
	}

	static String verificarGanador() { // Y este otro array lo usare para verificar si hay ganador o no. Todo esto
										// mediante un bucle el cual va a ir buscando si se podrece linea
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
				case 0:
					line = tablero[0] + tablero[1] + tablero[2];
					break;
				case 1:
					line = tablero[3] + tablero[4] + tablero[5];
					break;
				case 2:
					line = tablero[6] + tablero[7] + tablero[8];
					break;
				case 3:
					line = tablero[0] + tablero[3] + tablero[6];
					break;
				case 4:
					line = tablero[1] + tablero[4] + tablero[7];
					break;
				case 5:
					line = tablero[2] + tablero[5] + tablero[8];
					break;
				case 6:
					line = tablero[0] + tablero[4] + tablero[8];
					break;
				case 7:
					line = tablero[2] + tablero[4] + tablero[6];
					break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(tablero).contains(String.valueOf(a + 1))) {
				break;
			} else if (a == 8)
				return "empate";
		}
		return null;

	}
}