package pacman;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import javazoom.jlgui.basicplayer.BasicPlayer;
/**
 * CLASSE TAULELL
 * @author Xaviertn
 *@version 1
 */
public class Taulell {

	//ATRIBUTS DE LA CLASSE
   static char table[][] = new char[17][19];
	private boolean bolea2=false;
	private boolean bolea3=false;
	private int cas=0;
	private int x = 8;
	private int y = 9;

	private int yBixo = 1;
	private int xBixo = 1;
	
	
	/**
	 * 	CONSTRUCTOR PER DEFECTE
	 */
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
	
	//GTTERS I SETTERS///////////////////////////////////////////////////
	public static char[][] getTable() {
		return table;
	}


	public static void setTable(char[][] table) {
		Taulell.table = table;
	}

	public boolean isBolea2() {
		return bolea2;
	}


	public void setBolea2(boolean bolea2) {
		this.bolea2 = bolea2;
	}

	public boolean isBolea3() {
		return bolea3;
	}

	public void setBolea3(boolean bolea3) {
		this.bolea3 = bolea3;
	}
	
	public int getCas() {
		return cas;
	}

	public void setCas(int cas) {
		this.cas = cas;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getyBixo() {
		return yBixo;
	}

	public void setyBixo(int yBixo) {
		this.yBixo = yBixo;
	}

	public int getxBixo() {
		return xBixo;
	}


	public void setxBixo(int xBixo) {
		this.xBixo = xBixo;
	}

	
	

	/**
	 * MÈTODE PER A MOSTRAR EL TAULELL
	 */
	public void mostrar_taulell() {

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 19; j++) {
				System.out.print("" + table[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	/**
	 * MÈTODE PER A CONTAR PUNTUACIÓ JUGADOR
	 * @return boleà
	 */
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

	/**
	 * MÈTODE PER A LLEGIR DE TECLAT UN INT
	 * @return l'escanner
	 */
	private static int llegir() {
		Scanner llegir = new Scanner(System.in);
		return llegir.nextInt();
	}

	/**
	 * MÈTODE PER A LLEGIR DE TECLAT UN STRING
	 * @return l'escanner
	 */
	private static String llegir_string() {
		Scanner llegir = new Scanner(System.in);
		return llegir.next();
	}

}
