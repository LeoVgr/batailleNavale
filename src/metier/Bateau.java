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
	 * Ce constructeur sera celui � privil�gier. Il assigne automatiquement
	 * neutre � la variable �tat car un bateau sera � la cr�ation forc�ment neutre. Et le nombre de tirs re�u
	 * sera nul donc nous affectons 0 � la variable nbrTouche. 
	 * Dans le cadre de la variable etat, les valeurs pr�f�rables sont neutre, touche, coule.
	 * @param nom nom du bateau
	 * @param positionX position X de la premi�re case du bateau
	 * @param positionY position Y de la premi�re case du bateau (origine en haut � gauche de la grille)
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
	 * Ajouter un certain nombre en plus du nombre de touch� au bateau
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
	 * M�thode qui permet de conna�tre les cases sur lequel le bateau est. En retour nous avons un tableau de 
	 * Case. ATTENTION : la taille du tableau retourn�e sera variable (la taille du tableau est �gale � la taille
	 * du bateau).
	 * Si le bateau d�passe de la grille, alors la fonction renverra un tableau de cases null
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
	 * M�thode permettant d'effectuer les traitements suite au fait que le bateau a �t� touch�.
	 * Si la diff�rence entre la taille du bateau et le nombre de touche est sup�rieur � 1 alors ont ajoute
	 * une touche, sinon cela signifie que le bateau va �tre coul� est donc on lui change son etat.
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
	 * M�thode permettant de mettre les cases sur lequel le bateau se situe en occup�es.
	 * Cette m�thode informe donc au cases qu'elles contiennent un bateau.
	 */
	public void mettreMesCasesEnOccup�e() {
		for(int u=0; u < this.getMesCase().length;u++) {
			this.getMesCase()[u].setEstOccupe(true);
		}
		
	}
	/**
	 * M�thode qui v�rifie si le bateau courant chevauche un autre bateau
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
	 * M�thode permettant de tourner un bateau (changer son alignement)
	 */
	public void tournerBateau() {
		if (this.alignement.equals("vertical")){
			this.setAlignement("horizontal");
		}else {
			this.setAlignement("vertical");
		}
				
	}
	/**
	 * M�thode permettant de connaitres les cases du bateaux m�me si il n'est pas pos� sur la grille. 
	 * En effet cette m�thode renvoie un tableau de cases sur lequel le bateau se situerais si sa premi�re case se 
	 * trouvait sur la position indiqu� en entr�e de la m�thode.
	 * Si le bateau d�passe de la grille, alors la fonction renverra un tableau de cases null
	 * @param posX Position X de la premi�re case du bateau
	 * @param posY Position Y de la premi�re case du bateau
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
