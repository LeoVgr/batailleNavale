package metier;

public class Joueur {
	private String nom;
	private int num;
	private int score;
	private boolean estGagnant;
	private Bateau[] bateaux;
	private Plateau plateauRecapTir;
	private Plateau plateauBateau;
	private boolean tirAutoriser;
	
	
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
	public Joueur(String nom, int num, int score) {
		this.nom=nom; 
		this.num=num;
		this.score=score;
		this.plateauRecapTir=new Plateau();
		this.plateauBateau=new Plateau();
		this.bateaux= new Bateau[5];
		this.estGagnant=false;
		this.tirAutoriser=true;
		
		//cr�ation des �l�ments de jeu
		
		this.plateauBateau=new Plateau(this);
		
		this.bateaux[0]= new SousMarin(plateauBateau);
		this.bateaux[1]= new Croiseur(plateauBateau);
		this.bateaux[2]= new ContreTorpilleur(plateauBateau);
		this.bateaux[3]= new PorteAvion(plateauBateau);
		this.bateaux[4]= new Torpilleur(plateauBateau);
		
	}
	
	


	public boolean isTirAutoriser() {
		return tirAutoriser;
	}

	public void setTirAutoriser(boolean tirAutoriser) {
		this.tirAutoriser = tirAutoriser;
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
	/**
	 * M�thode permettant de tirer. Cette m�thode v�rifie si la case correspondante au coordonn�es donn�es en 
	 * entr�e est occup�e ou non.
	 * @param adversaire joueur adverse (celui sur lequel on souhaite tirer)
	 * @param posX coordonn�e X de la case vis�e
	 * @param posY coordonn�e Y de la case vis�e
	 */
	public String tirer(Joueur adversaire,int posX, int posY) {
		String res="";
		
		//si le joueur n'a pas d�ja tir�
		if(this.tirAutoriser) {
			if(adversaire.getPlateauBateau().getGrille()[posX][posY].isEstTouche()) {
				System.out.println("T'as d�ja bougnoule");
			}else {
				if(adversaire.getPlateauBateau().getGrille()[posX][posY].getEstOccupe()) {
					res= "touch�";
					
					
					for(int i=0; i<adversaire.getBateaux().length;i++) {
						for(int j=0; j<adversaire.getBateaux()[i].getMesCase().length;j++) {
							
							
							
							// on cherche � quel bateau appartient la case touch�e et on effectue le traitement
							if(adversaire.getBateaux()[i].getMesCase()[j].equals(adversaire.getPlateauBateau().getGrille()[posX][posY])) {
								
								adversaire.getBateaux()[i].estTouche();
								adversaire.getPlateauBateau().getGrille()[posX][posY].estTire();
								
								
								if(adversaire.getBateaux()[i].getEtat().equals("coule")) {
									
									res= "coul�";
									if(adversaire.sontTousCoule()) {
										res="gagn�";
									}
								}
								
							}
						}
					}
					
				}else {
					res= "eau";
				}
			}
		
			adversaire.getPlateauBateau().getGrille()[posX][posY].setEstTouche(true);
			this.tirAutoriser=false;
		}else {
			res="recharger";
		}
		
		System.out.println(res);
		return res;
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
	public boolean sontTousCoule() {
		boolean res =true;
		
		for(int i=0; i<this.getBateaux().length;i++) {
			if(!this.getBateaux()[i].getEtat().equals("coule")) {
				res=false;
			}
		}
		return res;
		
	}
	
	
	
}
