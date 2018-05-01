package metier;

public class Partie {
	private Joueur[] joueurs;
	private int joueurActuel;
	private boolean phaseDePlacement;
	
	
	/**
	 * Constructeur par défaut de la classe Partie. Ce constructeur n'initialise pas les variables de l'objet.
	 *
	 */
	public Partie(String nomJ1, String nomJ2) {
		this.joueurs = new Joueur[2];
		this.joueurActuel=0;
		joueurs[0]=new Joueur(nomJ1,1,0);
		joueurs[1]=new Joueur(nomJ2,2,0);
		this.phaseDePlacement=true;
		
	}



	public boolean isPhaseDePlacement() {
		return phaseDePlacement;
	}



	public void setPhaseDePlacement(boolean phaseDePlacement) {
		this.phaseDePlacement = phaseDePlacement;
	}



	public Joueur[] getJoueurs() {
		return joueurs;
	}



	public void setJoueurs(Joueur[] joueurs) {
		this.joueurs = joueurs;
	}
	
	public void joueurSuivant() {
		if(this.joueurActuel==0) {
			this.joueurActuel=1;
		}else {
			this.joueurActuel=0;
		}
	}



	public int getJoueurActuel() {
		return joueurActuel;
	}



	public void setJoueurActuel(int joueurActuel) {
		this.joueurActuel = joueurActuel;
	}
	
	public int joueurAdverse(int joueurActuel) {
		if(this.joueurActuel==0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	
	
	
	
}
