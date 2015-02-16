package pacman;

import java.awt.AWTException;

/**
 * CLASSE PRINCIPAL PER L'EXECUCIÓ DEL PROGRAMA
 * @author Xaviertn
 *@version 1
 */


public class CampDeBatalla {

	public static void main(String[] args) throws AWTException  {
		// TODO Auto-generated method stub
		boolean perdre= false;
		boolean perdre2= false;
		boolean perdre3= false;
		Taulell table = new Taulell();
		Jugador jugador = new Jugador();
		Fantasma Phantom = new Fantasma(1,1);
		Fantasma Phantom2 = new Fantasma(1,15);
		Fantasma Phantom3 = new Fantasma(17,1);
		Phantom.iniciar_Fantasma(table);
		Phantom2.iniciar_Fantasma(table);
		jugador.posicionar_fitxa(table);
		table.mostrar_taulell();
		
		do{
		
		perdre=jugador.moviment_jugador(table);
		perdre2=Phantom.moviment_fantasma(table);
		perdre3=Phantom2.moviment_fantasma(table);
		Taulell.contar_punts();
		table.mostrar_taulell();
		}while(Taulell.contar_punts() ==false && perdre==false && perdre2==false && perdre2==false);
		
		if(perdre==true || perdre2==true || perdre2==true){
			System.out.println("HAS PERDUT, SE T'HAN MENJAT!!!!");
		}else{
			System.out.println("HAS GUANYAT, HAS AGAFAT TOTS ELS PUNTS!!!!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
