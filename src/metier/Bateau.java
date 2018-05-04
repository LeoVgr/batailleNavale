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
	private boolean estSelectionner;
	private boolean estPlace;
	
	
	/**
	 * Ce constructeur sera celui à privilégier. Il assigne automatiquement
	 * neutre à la variable état car un bateau sera à la création forcément neutre. Et le nombre de tirs reçu
	 * sera nul donc nous affectons 0 à la variable nbrTouche. 
	 * Dans le cadre de la variable etat, les valeurs préférables sont neutre, touche, coule.
	 * @param nom nom du bateau
	 * @param positionX position X de la première case du bateau
	 * @param positionY position Y de la première case du bateau (origine en haut à gauche de la grille)
	 * @param taille taille du bateau
	 * @param alignement alignement du bateau (vertical ou horizontal)
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
		this.estSelectionner=false;
		this.estPlace=false;
			
	}

	public boolean isEstPlace() {
		return estPlace;
	}
	/**
	 * Mettre le bateau en place sur la grille
	 * @param estPlace
	 */
	public void setEstPlace(boolean estPlace) {
		this.estPlace = estPlace;
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

	public boolean isEstSelectionner() {
		return estSelectionner;
	}

	public void setEstSelectionner(boolean estSelectionner) {
		this.estSelectionner = estSelectionner;
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
	/**
	 * Ajouter un certain nombre en plus du nombre de touché au bateau
	 * @param nbrTouche
	 */
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
	 * Case. ATTENTION : la taille du tableau retournée sera variable (la taille du tableau est égale à la taille
	 * du bateau).
	 * Si le bateau dépasse de la grille, alors la fonction renverra un tableau de cases null
	 * @return
	 */
	public Case[] getMesCase() {
		Case[] tabCase= new Case[this.taille];
		
		try {
			if(this.alignement.equals("horizontal")) {
				
				int i =this.positionY;
				
				for(int j=0; j<this.taille; j++) {
						
					
						tabCase[j]=this.plateau.getGrille()[this.positionX][i];
						
						i++;
					
				}
				
			}
			if(this.alignement.equals("vertical")){
				int i =this.positionX;
				
				for(int j=0; j<this.taille; j++) {
								
						tabCase[j]=this.plateau.getGrille()[i][this.positionY];
						
						i++;
					
				}
			}
			
		}catch(java.lang.ArrayIndexOutOfBoundsException e){
			tabCase= null;
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
	
	/**
	 * Méthode permettant de mettre les cases sur lequel le bateau se situe en occupées.
	 * Cette méthode informe donc au cases qu'elles contiennent un bateau.
	 */
	public void mettreMesCasesEnOccupée() {
		for(int u=0; u < this.getMesCase().length;u++) {
			this.getMesCase()[u].setEstOccupe(true);
		}
		
	}
	/**
	 * Méthode qui vérifie si le bateau courant chevauche un autre bateau
	 * @return
	 */
	public boolean chevaucheUnAutreBateau() {
		boolean chevaucheUnAutreBateau=false;
		
		for(int u=0; u < this.getMesCase().length;u++) {
			if(this.getMesCase()[u].getEstOccupe()) {
				chevaucheUnAutreBateau=true;
			}
		}
		return chevaucheUnAutreBateau;
	}
	/**
	 * Méthode permettant de tourner un bateau (changer son alignement)
	 */
	public void tournerBateau() {
		if (this.alignement.equals("vertical")){
			this.setAlignement("horizontal");
		}else {
			this.setAlignement("vertical");
		}
				
	}
	/**
	 * Méthode permettant de connaitres les cases du bateaux même si il n'est pas posé sur la grille. 
	 * En effet cette méthode renvoie un tableau de cases sur lequel le bateau se situerais si sa première case se 
	 * trouvait sur la position indiqué en entrée de la méthode.
	 * Si le bateau dépasse de la grille, alors la fonction renverra un tableau de cases null
	 * @param posX Position X de la première case du bateau
	 * @param posY Position Y de la première case du bateau
	 * @return
	 */
	public Case[] getMesCasesPositionnement(int posX, int posY) {
	Case[] tabCase= new Case[this.taille];
		
		try {
			if(this.alignement.equals("horizontal")) {
				
				int i =posY;
				
				for(int j=0; j<this.taille; j++) {
						
					
						tabCase[j]=this.plateau.getGrille()[posX][i];
						
						i++;
					
				}
				
			}
			if(this.alignement.equals("vertical")){
				int i =posX;
				
				for(int j=0; j<this.taille; j++) {
								
						tabCase[j]=this.plateau.getGrille()[i][posY];
						
						i++;
					
				}
			}
			
		}catch(java.lang.ArrayIndexOutOfBoundsException e){
			tabCase= null;
		}
		
		return tabCase;
	
	}
	
	
}
