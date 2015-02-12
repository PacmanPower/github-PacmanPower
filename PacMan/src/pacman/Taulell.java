package pacman;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import javazoom.jlgui.basicplayer.BasicPlayer;

public class Taulell {

	private static char table[][] = new char[17][19];
	private boolean bolea2=false;
	private boolean bolea3=false;
	private int cas=0;
	private int x = 8;
	private int y = 9;

	private int yBixo = 1;
	private int xBixo = 1;

	public Taulell() {
		table = new char[][] { "###################".toCharArray(),
				"#........#........#".toCharArray(),
				"#.##.###.#.###.##.#".toCharArray(),
				"#.................#".toCharArray(),
				"#.##.#.#####.#.##.#".toCharArray(),
				"#....#...#...#....#".toCharArray(),
				"####.###.#.###.####".toCharArray(),
				"####.#.......#.####".toCharArray(),
				"####...#####...####".toCharArray(),
				"####.#.......#.####".toCharArray(),
				"####.###.#.###.####".toCharArray(),
				"#....#...#...#....#".toCharArray(),
				"#.##.#.#####.#.##.#".toCharArray(),
				"#.................#".toCharArray(),
				"#.##.###.#.###.##.#".toCharArray(),
				"#........#........#".toCharArray(),
				"###################".toCharArray()

		};

	}

	public void mostrar_taulell() {

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 19; j++) {
				System.out.print("" + table[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static boolean contar_punts() {
		int cont_boletes = 0;
		int cont = 0;
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 19; j++) {
				if (table[i][j] == '.') {
					cont_boletes++;

				}

				if (table[i][j] == ' ') {

					cont = cont + 2;
				}
			}

		}
		System.out.println("PUNTS: " + cont);
		if (cont_boletes == 0) {
			return true;

		} else
			return false;

	}

	public void iniciar_Fantasma() {

		this.table[xBixo][yBixo] = Fantasma.Bixo;

	}

	public void moviment_fantasma() {
		
		
	 boolean bolea = false;
	
		for(int i=1; i<=4; i++){
			if (bolea==false){
				switch (i) {
				case 1:
					//DRETA/////////
					if (table[xBixo][yBixo + 1] != Casella.mur && bolea2==false ) {

						table[xBixo][yBixo + 1] = Fantasma.Bixo;
						table[xBixo][yBixo] = Casella.punt;
						yBixo = yBixo + 1;
						bolea=true;
					} else bolea=false; bolea2=false;
					
					break;
					//AVALL/////////
				case 2:
					if (table[xBixo+1][yBixo] != Casella.mur && bolea3==false) {

						table[xBixo+1][yBixo] = Fantasma.Bixo;
						table[xBixo][yBixo] = Casella.punt;
						xBixo = xBixo + 1;
						bolea=true;
					} else bolea=false;
					break;
					//ESQUERRA/////////
				case 3:
					if (table[xBixo][yBixo-1] != Casella.mur ) {

						table[xBixo][yBixo-1] = Fantasma.Bixo;
						table[xBixo][yBixo] = Casella.punt;
						yBixo = yBixo - 1;
						bolea=true;
						bolea2=true;
					} else bolea2=false;
					break;
					
					//AMUNT/////////
				case 4:
					if (table[xBixo-1][yBixo] != Casella.mur ) {

						table[xBixo-1][yBixo] = Fantasma.Bixo;
						table[xBixo][yBixo] = Casella.punt;
						xBixo = xBixo - 1;
						bolea=true;
						bolea2=false;
						bolea3=true;
					}else bolea3=false;
					break;
				default:
					break;
				}
			}
			
			
		}
		/*if (table[xBixo][yBixo + 1] != Casella.mur ) {

			table[xBixo][yBixo + 1] = Fantasma.Bixo;
			table[xBixo][yBixo] = Casella.punt;
			yBixo = yBixo + 1;
			
			
		} 
		
		//AVALL///////////////////////
		if (table[xBixo + 1][yBixo] != Casella.mur) {

			table[xBixo + 1][yBixo] = Fantasma.Bixo;
			table[xBixo][yBixo] = Casella.punt;
			xBixo = xBixo + 1;
			
		} 
		//ESQUERRA///////////////////////
		if (table[xBixo][yBixo - 1] != Casella.mur ) {

			table[xBixo][yBixo - 1] = Fantasma.Bixo;
			table[xBixo][yBixo] = Casella.punt;
			yBixo = yBixo - 1;
			;
		} */
		
		
		
		//AMUNT///////////////////////
		/*if (table[xBixo - 1][yBixo] != Casella.mur && bolea==false) {

			table[xBixo - 1][yBixo] = Fantasma.Bixo;
			table[xBixo][yBixo] = Casella.punt;
			xBixo = xBixo - 1;

		}*/

	}

	public void posicionar_fitxa() {
		Jugador jugador = new Jugador();
		table[x][y] = jugador.getComecocos();

	}

	public void moviment_jugador() throws AWTException {
		String direccio = "";
		Robot robot = new Robot();
		System.out
				.println("posa direccio (W)AMUNT  (S)AVALL (A)ESQUERRA (D) DRETA \n"
						+ "Cada rodoneta que mengis sumaràs 2 punts, guanyes un cop agafades totes");

		direccio = llegir_string().toUpperCase();

		switch (direccio) {
		// MOVIMENT ENDAVANT
		case "W":
			if (table[x - 1][y] != Casella.mur) {
				if (table[x - 1][y] == Casella.punt) {

				}
				table[x][y] = ' ';
				this.x = x - 1;
				this.y = y;
				table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;
		// MOVIMENT AVALL
		case "S":
			if (table[x + 1][y] != Casella.mur) {
				table[x][y] = ' ';
				this.x = x + 1;
				this.y = y;

				table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;
		// MOVIMENT ESQUERRA
		case "A":
			if (table[x][y - 1] != Casella.mur) {
				table[x][y] = ' ';
				this.x = x;
				this.y = y - 1;
				table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;
		// MOVIMENT DRETA
		case "D":
			if (table[x][y + 1] != Casella.mur) {
				table[x][y] = ' ';
				this.x = x;
				this.y = y + 1;
				table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;

		default:
			break;

		}

		System.out.println("la x es " + x);
	}

	private static int llegir() {
		Scanner llegir = new Scanner(System.in);
		return llegir.nextInt();
	}

	private static String llegir_string() {
		Scanner llegir = new Scanner(System.in);
		return llegir.next();
	}

}
