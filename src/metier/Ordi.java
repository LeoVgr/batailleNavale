package metier;

public class Ordi extends Joueur{

	
	public Ordi() {
		super("Ordinateur", 2,0);
	}
	
	
	
	
	
	public int genAleaPosition(){
		
	
		int res[][] = null;
		
		int lower = 0;
		int higher = 10;
		int x = (int)(Math.random() * (higher-lower)) + lower;
		
		int y = (int)(Math.random() * (higher-lower)) + lower;
		
		
		
		return (res[x][y]);
		
		
	}
}
