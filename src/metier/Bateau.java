package metier;

public class Bateau {
	private String nom;
	private String etat;
	private int positionX;
	private int positionY;
	private int taille;
	private String alignement;
	private int nbrTouche;
	private Plateau plateau;
	
	/**
	 * Contructeur par défaut de la classe Bateau. Ce constructeur construit un objet avec des variables
	 * non initialisées.
	 */
	public Bateau(Plateau plateau) {
		this.nom="";
		this.positionX=0;
		this.positionY=0;
		this.taille=1;
		this.alignement="horizontale";
		this.plateau= plateau;
		this.etat = "neutre";
		this.nbrTouche=0;
	}
	
	/**
	 * Ce constructeur sera celui à privilégier. Ce dernier admet 5 paramètres d'entrée. Il assigne automatiquement
	 * neutre à la variable état car un bateau sera à la création forcément neutre. Et le nombre de tirs reçu
	 * sera nul donc nous affectons 0 à la variable nbrTouche. 
	 * Dans le cadre de la variable etat, les valeurs préférables sont neutre, touche, coule.
	 * @param nom
	 * @param positionX
	 * @param positionY
	 * @param taille
	 * @param alignement
	 */
	public Bateau(String nom, int positionX, int positionY, int taille, String alignement, Plateau plateau) {
		this.nom=nom;
		this.positionX=positionX;
		this.positionY=positionY;
		this.taille=taille;
		this.alignement=alignement;
		this.plateau=plateau;
		this.etat = "neutre";
		this.nbrTouche=0;
			
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getAlignement() {
		return alignement;
	}

	public void setAlignement(String alignement) {
		this.alignement = alignement;
	}

	public int getNbrTouche() {
		return nbrTouche;
	}

	public void setNbrTouche(int nbrTouche) {
		this.nbrTouche += nbrTouche;
	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	/**
	 * Méthode qui permet de connaître les cases sur lequel le bateau est. En retour nous avons un tableau de 
	 * Case. ATTENTION : la taille du tableau retourné sera variable (la taille du tableau est égale à la taille
	 * du bateau).
	 * @return
	 */
	public Case[] getMesCase() {
		Case[] tabCase= new Case[this.taille];
		
		if(this.alignement.equals("vertical")) {
			
			int i =this.positionY;
			
			for(int j=0; j<this.taille; j++) {
					
				
					tabCase[j]=this.plateau.getGrille()[this.positionX][i];
					
					i++;
				
			}
			
		}
		if(this.alignement.equals("horizontal")){
			int i =this.positionX;
			
			for(int j=0; j<this.taille; j++) {
							
					tabCase[j]=this.plateau.getGrille()[i][this.positionY];
					
					i++;
				
			}
		}
		return tabCase;
	}
	
	/**
	 * Méthode permettant d'effectuer les traitements suite au fait que le bateau a été touché.
	 * Si la différence entre la taille du bateau et le nombre de touche est supérieur à 1 alors ont ajoute
	 * une touche, sinon cela signifie que le bateau va être coulé est donc on lui change son etat.
	 */
	public void estTouche() {
		int differenceTailleNbrTouche=this.taille-this.nbrTouche;
		
		if(differenceTailleNbrTouche == 1) {
			this.nbrTouche++;
			this.etat="coule";
			
		}else {
			this.nbrTouche++;
		}
		
	}
	
}
