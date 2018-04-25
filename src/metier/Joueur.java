package metier;

public class Joueur {
	private String nom;
	private int num;
	private int score;
	private boolean estGagnant;
	private Bateau[] bateaux;
	private Plateau plateauRecapTir;
	private Plateau plateauBateau;
	
	
	/**
	 * Constructeur par d�faut de la classe Joueur. Ce constructeur construit un objet sans initialiesr les 
	 * variables de l'objet Joueur.
	 */
	public Joueur() {
		
	}
	
	/**
	 *  Constructeur de la classe Joueur permettant de construire un objet Joueur avec tous les param�tres
	 *  en entr�e, sauf un bool�en estGagnant qui serait mis � faux automatiquement. Constructeur a privil�gier.
	 * @param nom Chaine contenant le nom du joueur
	 * @param num Entier qui correspond au num�ro du joueur (1 ou 2 de pr�f�rence)
	 * @param score Entier qui contiendrait le score du joueur.
	 */
	public Joueur(String nom, int num, int score, Plateau plateauRecapTir, Plateau plateauBateau) {
		this.nom=nom; //nom par defaut?
		this.num=num;
		this.score=score;
		this.plateauRecapTir=plateauRecapTir;
		this.plateauBateau=plateauBateau;
		this.bateaux= new Bateau[5];
		this.estGagnant=false;
	}
	
	


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isEstGagnant() {
		return estGagnant;
	}

	public void setEstGagnant(boolean estGagnant) {
		this.estGagnant = estGagnant;
	}

	public Plateau getPlateauRecapTir() {
		return plateauRecapTir;
	}

	public void setPlateauRecapTir(Plateau plateauRecapTir) {
		this.plateauRecapTir = plateauRecapTir;
	}

	public Plateau getPlateauBateau() {
		return plateauBateau;
	}

	public void setPlateauBateau(Plateau plateauBateau) {
		this.plateauBateau = plateauBateau;
	}
	
	

	public Bateau[] getBateaux() {
		return bateaux;
	}

	public void setBateaux(Bateau[] bateaux) {
		this.bateaux = bateaux;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Joueur [nom=");
		builder.append(nom);
		builder.append(", num=");
		builder.append(num);
		builder.append(", score=");
		builder.append(score);
		builder.append(", estGagnant=");
		builder.append(estGagnant);
		builder.append(", plateauRecapTir=");
		builder.append(plateauRecapTir);
		builder.append(", plateauBateau=");
		builder.append(plateauBateau);
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * M�thode permettant de tirer. Cette m�thode v�rifie si la case correspondante au coordonn�es donn�es en 
	 * entr�e est occup�e ou non.
	 * @param adversaire joueur adverse (celui sur lequel on souhaite tirer)
	 * @param posX coordonn�e X de la case vis�e
	 * @param posY coordonn�e Y de la case vis�e
	 */
	public void tirer(Joueur adversaire,int posX, int posY) {
		adversaire.getPlateauBateau().getGrille()[posX][posY].getEstOccupe();
		
		if(adversaire.getPlateauBateau().getGrille()[posX][posY].getEstOccupe()) {
			System.out.println("touch�");
			
			for(int i=0; i<this.bateaux.length;i++) {
				for(int j=0; j<bateaux[i].getMesCase().length;j++) {
					
					// on cherche � quelle bateau appartient la case touch�e et on effectue le traitement
					if(bateaux[i].getMesCase()[j].equals(adversaire.getPlateauBateau().getGrille()[posX][posY])) {
						bateaux[i].estTouche();
						adversaire.getPlateauBateau().getGrille()[posX][posY].estTire();
						
						if(bateaux[i].getEtat().equals("coule")) {
							System.out.println("coul�");
						}
						
					}
				}
			}
			
		}else {
			System.out.println("dans l'eau.");
		}
		adversaire.getPlateauBateau().getGrille()[posX][posY].setEstTouche(true);
	}
	
	public void addBateau(Bateau bat) {
		int i=0;
		boolean ajoute=false;
		
			while(i<this.bateaux.length && !ajoute) {
				if(this.bateaux[i]==null) {
				
					this.bateaux[i]=bat;
					ajoute=true;
					
					for(int j=0; j<bateaux[i].getTaille();j++) {
					
						this.bateaux[i].getMesCase()[j].setEstOccupe(true);
					}
					
				}
				i++;
			
		}
		
	}
	
	
	
}
