package pacman;

import java.awt.AWTException;


public class CampDeBatalla {

	public static void main(String[] args) throws AWTException  {
		// TODO Auto-generated method stub
		
		System.out.println("prova branca jepi");
		System.out.println("Segona prova desde branca jepi");
		
		boolean guanyar= false;
		Taulell table = new Taulell();
		table.iniciar_Fantasma();
		table.posicionar_fitxa();
		table.mostrar_taulell();
		
		do{
		
		table.moviment_jugador();
		table.moviment_fantasma();
		Taulell.contar_punts();
		table.mostrar_taulell();
		}while(Taulell.contar_punts() ==false);
		
		System.out.println("Has menjat tots els punts!!!!");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
