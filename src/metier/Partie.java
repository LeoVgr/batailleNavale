package metier;

public class Partie {
	private Plateau[] plateau;
	
	/**
	 * Constructeur par d�faut de la classe Partie. Ce constructeur n'initialise pas les variables de l'objet.
	 *
	 */
	public Partie() {
		
	}
	
	/**
	 * Constructeur admettant un param�tre d'entr�e et qui sera a privil�gi�. Ici, le param�tre d'entr�e sera 
	 * 4 plateaux ce qui correspond au 2 plateaux o� les joueurs placent leur bateaux et aussi les 2 plateaux o�
	 * ils voient leur tirs. Ce constructeur sera celui � privil�gier.
	 * 
	 * @param plateau
	 */
	public Partie(Plateau[] plateau) {
		this.plateau= new Plateau[4];
	}
	
	
}
