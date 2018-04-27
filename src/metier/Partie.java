package metier;

public class Partie {
	private Joueur[] joueurs;
	
	
	
	/**
	 * Constructeur par défaut de la classe Partie. Ce constructeur n'initialise pas les variables de l'objet.
	 *
	 */
	public Partie(String nomJ1, String nomJ2) {
		this.joueurs = new Joueur[2];
		
		joueurs[0]=new Joueur(nomJ1,1,0);
		joueurs[1]=new Joueur(nomJ2,2,0);
		
	}



	public Joueur[] getJoueurs() {
		return joueurs;
	}



	public void setJoueurs(Joueur[] joueurs) {
		this.joueurs = joueurs;
	}
	
	
	
	
	
}
