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
	 * Contructeur par d�faut de la classe Bateau. Ce constructeur construit un objet avec des variables
	 * non initialis�es.
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
		this.estSelectionner=false;
		this.estPlace=false;
	}
	
	/**
	 * Ce constructeur sera celui � privil�gier. Ce dernier admet 5 param�tres d'entr�e. Il assigne automatiquement
	 * neutre � la variable �tat car un bateau sera � la cr�ation forc�ment neutre. Et le nombre de tirs re�u
	 * sera nul donc nous affectons 0 � la variable nbrTouche. 
	 * Dans le cadre de la variable etat, les valeurs pr�f�rables sont neutre, touche, coule.
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
		this.estSelectionner=false;
		this.estPlace=false;
			
	}

	public boolean isEstPlace() {
		return estPlace;
	}

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
	 * Case. ATTENTION : la taille du tableau retourn� sera variable (la taille du tableau est �gale � la taille
	 * du bateau).
	 * @return
	 */
	public Case[] getMesCase() {
		Case[] tabCase= new Case[this.taille];
		
		try {
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
	
	public void mettreMesCasesEnOccup�e() {
		for(int u=0; u < this.getMesCase().length;u++) {
			this.getMesCase()[u].setEstOccupe(true);
		}
		
	}
	
	public boolean chevaucheUnAutreBateau() {
		boolean chevaucheUnAutreBateau=false;
		
		for(int u=0; u < this.getMesCase().length;u++) {
			if(this.getMesCase()[u].getEstOccupe()) {
				chevaucheUnAutreBateau=true;
			}
		}
		return chevaucheUnAutreBateau;
	}
	
	
}
