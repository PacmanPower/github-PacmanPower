package pacman;

/**
 * CLASSE CASELLA (PER A LES CASELLES SENSE MOVIMENT)
 * @author Xaviertn
 * @
 *@version 1
 */
public class Casella {
	

	//ATRIBUTS DE LA CLASSE
	public static char mur='#';
	public static char punt='.';
	public static char buida=' ';
	
	
	
	
	//GETTERS I SETTERS
	public static char getMur() {
		return mur;
	}
	public static void setMur(char mur) {
		Casella.mur = mur;
	}
	public static char getPunt() {
		return punt;
	}
	public static void setPunt(char punt) {
		Casella.punt = punt;
	}
	public static char getBuida() {
		return buida;
	}
	public static void setBuida(char buida) {
		Casella.buida = buida;
	}
	
	
	

}
