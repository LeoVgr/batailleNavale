package metier;

public class Plateau {
	private Case[][] grille;
	Joueur joueur;
	
	
	public Plateau() {
		
	}
	
	/**
	 * Constructeur � privil�gier. Il permet de cr�er une grille en initialisant un tableau � double entr�e
	 * � 10 lignes, et 10 colonnes. Cette grille est rattach�e au joueur pass� en entr�e.
	 * @param coupJoue 
	 * @param coupRecu
	 * @param joueur
	 */
	public Plateau(Joueur joueur) {
		this.grille = new Case[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				this.grille[i][j]=new Case("Test",i,j);
			}
		}
		this.joueur=joueur;
	}

	public Case[][] getGrille() {
		return grille;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	
	

	
	
}
