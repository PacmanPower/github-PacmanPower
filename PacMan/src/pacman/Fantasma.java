package pacman;

/**
 * CLASSE FANTASMA
 * @author Xaviertn
 *@version 1
 */
public class Fantasma {

	//ATRIBUTS DE L'OBJECTE
	protected static final char Bixo = 'X';
	private int yBixo;
	private int xBixo;
	private boolean PrirmeraCasella = true;
	int cas=0;

	//GETTERS I SETTERS
	public boolean isPrirmeraCasella() {
		return PrirmeraCasella;
	}

	public void setPrirmeraCasella(boolean prirmeraCasella) {
		PrirmeraCasella = prirmeraCasella;
	}

	public int getCas() {
		return cas;
	}

	public void setCas(int cas) {
		this.cas = cas;
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

	public static char getBixo() {
		return Bixo;
	}
	
	
	//CONSTRUCTOR PER PARÀMETRES
	public Fantasma(int yBixo, int xBixo, boolean prirmeraCasella, int cas) {
		super();
		this.yBixo = yBixo;
		this.xBixo = xBixo;
		PrirmeraCasella = prirmeraCasella;
		this.cas = cas;
	}

	/**
	 * CONSTRUTOR PER PARÀMETRES
	 * @param yBixo
	 * @param xBixo
	 */
	public Fantasma(int yBixo, int xBixo) {
		
		this.yBixo = yBixo;
		this.xBixo = xBixo;
	}

	/**
	 * MÈTODE PER A POSICIONAR EL FANTASMA AL TAULELL
	 * @param taulell
	 */
	public void iniciar_Fantasma(Taulell taulell) {

		taulell.table[xBixo][yBixo] = Fantasma.Bixo;

	}

	/**
	 * MÈTODE PER A MOURE AUTOMÀTICAMENT EL FANTASMA PEL TAULELL
	 * @param taulell
	 * @return boleà
	 */
	public boolean moviment_fantasma(Taulell taulell) {
		boolean pedre=false;
		char casellaAnterior=' ';
		
		while(cas==0 ){
			int Aleatori = (int) (Math.random()*4+1);
			if(Aleatori==1 && taulell.table[xBixo][yBixo + 1] != Casella.mur){
				
				System.out.println("1");
				cas=1;
			}
			if(Aleatori==2 && taulell.table[xBixo + 1][yBixo] != Casella.mur){
				System.out.println("2");
				cas=2;
			}
			if(Aleatori==3 && taulell.table[xBixo][yBixo - 1] != Casella.mur){
				System.out.println("3");
				cas=3;
			}
			if(Aleatori==4 && taulell.table[xBixo - 1][yBixo] != Casella.mur){
				System.out.println("4");
				cas=4;
			}
			
		}
		switch (cas) {
		case 1://DRETA//////////////////////
			if( taulell.table[xBixo][yBixo + 1] != Casella.mur){
				if( taulell.table[xBixo][yBixo+1] =='C'){
					pedre=true;
					
				}
				 casellaAnterior = taulell.table[xBixo][yBixo+1];
				taulell.table[xBixo][yBixo + 1] = Fantasma.Bixo;
				if(PrirmeraCasella == true){
					taulell.table[xBixo][yBixo] = Casella.punt;
				}else{
					taulell.table[xBixo][yBixo]=casellaAnterior;
					if(casellaAnterior=='C'){
						taulell.table[xBixo][yBixo]=Casella.buida;
					}
				}
				yBixo = yBixo + 1;	
			}
			if( taulell.table[xBixo][yBixo + 1] == Casella.mur){
				cas=0;
			}
			PrirmeraCasella =false;
			break;
		case 2://AVALL//////////////////////
			if( taulell.table[xBixo + 1][yBixo] != Casella.mur){
				if( taulell.table[xBixo + 1][yBixo] =='C'){
					pedre=true;
					
				}
				
				casellaAnterior = taulell.table[xBixo+1][yBixo];
				 taulell.table[xBixo+1][yBixo] = Fantasma.Bixo;
				 if(PrirmeraCasella == true){
						taulell.table[xBixo][yBixo] = Casella.punt;
					}else{
						taulell.table[xBixo][yBixo]=casellaAnterior;
						if(casellaAnterior=='C'){
							taulell.table[xBixo][yBixo]=Casella.buida;
						}
					}
				 xBixo = xBixo + 1;
			}
			if( taulell.table[xBixo  + 1][yBixo] == Casella.mur){
				cas=0;
			}
			PrirmeraCasella =false;
			break;
		case 3://ESQUERRA//////////////////////
			if( taulell.table[xBixo][yBixo - 1] != Casella.mur){
				if( taulell.table[xBixo][yBixo-1] =='C'){
					pedre=true;
					
				}
				casellaAnterior = taulell.table[xBixo][yBixo-1];
				taulell.table[xBixo][yBixo - 1] = Fantasma.Bixo;
				 if(PrirmeraCasella == true){
						taulell.table[xBixo][yBixo-1] = Casella.punt;
					}else{
						taulell.table[xBixo][yBixo]=casellaAnterior;
						if(casellaAnterior=='C'){
							taulell.table[xBixo][yBixo]=Casella.buida;
						}
					}
				yBixo= yBixo-1;
			}
			if( taulell.table[xBixo][yBixo-1] == Casella.mur){
				cas=0;
			}
			break;
		case 4://AMUNT//////////////////////
			if( taulell.table[xBixo - 1][yBixo] != Casella.mur){
				if( taulell.table[xBixo-1][yBixo] =='C'){
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
					pedre=true;
				}
				
				casellaAnterior = taulell.table[xBixo-1][yBixo];
				taulell.table[xBixo - 1][yBixo] = Fantasma.Bixo;
				 if(PrirmeraCasella == true){
						taulell.table[xBixo][yBixo] = Casella.punt;
					}else{
						taulell.table[xBixo][yBixo]=casellaAnterior;
						if(casellaAnterior=='C'){
							taulell.table[xBixo][yBixo]=Casella.buida;
						}
					}
				 xBixo = xBixo-1;
			}
			if( taulell.table[xBixo -1][yBixo] == Casella.mur){
				cas=0;
			}
			
			break;

		default:
			break;
		}
		
		
		return pedre;
		
		
	}
	


}
