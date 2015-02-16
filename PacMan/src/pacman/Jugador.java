package pacman;

import java.util.Scanner;
/**
 * CLASSE JUGADOR
 * @author Xaviertn
 *@version 1
 */
public class Jugador {
	
	//ATRUBUTS DE LA CLASSE
	protected final char comecocos='C';
	int x = 8;
	int y = 9;

	//GETTERS I SETTERS
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

	public char getComecocos() {
		return comecocos;
	}
	
	/**
	 * MÈTODE PER A POSICIONAR LA FITXA DEL JUGADOR EL PRIMER COP
	 * @param taulell
	 */
	public void posicionar_fitxa(Taulell taulell) {
		Jugador jugador = new Jugador();
		taulell.table[x][y] = jugador.getComecocos();

	}
	
	
	
	/**
	 * MÈTODE PER A MOURE EL JUGADOR
	 * @param taulell
	 * @return boleà
	 */
	public boolean moviment_jugador(Taulell taulell)  {
		String direccio = "";
		boolean Mort=false;
		System.out
				.println("posa direccio (W)AMUNT  (S)AVALL (A)ESQUERRA (D) DRETA \n"
						+ "Cada rodoneta que mengis sumaràs 2 punts, guanyes un cop agafades totes");

		direccio = llegir_string().toUpperCase();

		switch (direccio) {
		// MOVIMENT ENDAVANT
		case "W":
			if (taulell.table[x - 1][y] != Casella.mur) {
				if (taulell.table[x - 1][y] == Fantasma.Bixo) {
					Mort=true;
				}
				if (taulell.table[x][y] == Fantasma.Bixo) {
					Mort=true;
				}
				taulell.table[x][y]=' ';
				this.x = x - 1;
				this.y = y;
				taulell.table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;
		// MOVIMENT AVALL
		case "S":
			if (taulell.table[x + 1][y] != Casella.mur) {
				if (taulell.table[x + 1][y] == Fantasma.Bixo) {
					Mort=true;
				}
				if (taulell.table[x][y] == Fantasma.Bixo) {
					Mort=true;
				}
				taulell.table[x][y] = ' ';
				this.x = x + 1;
				this.y = y;

				taulell.table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;
		// MOVIMENT ESQUERRA
		case "A":
			if (taulell.table[x][y - 1] != Casella.mur) {
				if (taulell.table[x][y-1] == Fantasma.Bixo) {
					Mort=true;
				}
				if (taulell.table[x][y] == Fantasma.Bixo) {
					Mort=true;
				}
				taulell.table[x][y] = ' ';
				this.x = x;
				this.y = y - 1;
				taulell.table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;
		// MOVIMENT DRETA
		case "D":
			if (taulell.table[x][y + 1] != Casella.mur) {
				if (taulell.table[x][y+1] == Fantasma.Bixo) {
					Mort=true;
				}
				if (taulell.table[x][y] == Fantasma.Bixo) {
					Mort=true;
				}
				taulell.table[x][y] = ' ';
				this.x = x;
				this.y = y + 1;
				taulell.table[x][y] = 'C';
			} else {
				System.out.println("Casella muro!!");
			}
			break;

		default:
			break;

		}

		return Mort;
	}
	
	/**
	 * MÈTODE PER A LLEGIR PER TECLAT UN STRING
	 * @return l'escanner
	 */
	private static String llegir_string() {
		Scanner llegir = new Scanner(System.in);
		return llegir.next();
	}
	
}
