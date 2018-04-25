package metier;

public class Partie {
	private Plateau[] plateau;
	
	/**
	 * Constructeur par défaut de la classe Partie. Ce constructeur n'initialise pas les variables de l'objet.
	 *
	 */
	public Partie() {
		
	}
	
	/**
	 * Constructeur admettant un paramètre d'entrée et qui sera a privilégié. Ici, le paramètre d'entrée sera 
	 * 4 plateaux ce qui correspond au 2 plateaux où les joueurs placent leur bateaux et aussi les 2 plateaux où
	 * ils voient leur tirs. Ce constructeur sera celui à privilégier.
	 * 
	 * @param plateau
	 */
	public Partie(Plateau[] plateau) {
		this.plateau= new Plateau[4];
	}
	
	
}
