package metier;

public class Plateau {
	private Case[][] grille;
	Joueur joueur;
	
	/**
	 * Constructeur par défaut de la classe Plateau. Ce constructeur construit un objet sans initialiesr les 
	 * variables de l'objet Plateau.
	 */
	public Plateau() {
		
	}
	
	/**
	 * Constructeur à privilégier. Il permet de créer une grille en initialisant un tableau à double entrée
	 * à 10 lignes, et 10 colonnes. Cette grille est rattachée au joueur passé en entrée.
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
		return this.grille;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	
}
