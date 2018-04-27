package metier;

public class Case {
	private String type;
	private int positionX;
	private int positionY;
	private boolean estTouche;
	private boolean estOccupe;
	
	/**
	 * Constructeur par défaut qui permet de créer un objet case mais qui n'initialise aucun de ses attributs
	 */
	public Case() {
		
	}
	
	
	/**
	 * Constructeur à privilégier. Ce constructeur permet de créer un objet case en initialisant le booléen
	 * @param type
	 * @param positionX
	 * @param positionY
	 */
	public Case(String type, int positionX, int positionY) {
		this.type=type;
		this.positionX=positionX;
		this.positionY=positionY;
		this.estTouche=false;
		this.estOccupe=false;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public boolean isEstTouche() {
		return estTouche;
	}

	public void setEstTouche(boolean estTouche) {
		this.estTouche = estTouche;
	}

	public boolean getEstOccupe() {
		return estOccupe;
	}

	public void setEstOccupe(boolean estOccupe) {
		this.estOccupe = estOccupe;
	}
	
	/**
	 * Méthode qui gère le tir sur une case. Elle passe le booléen estTouché à vrai et si la case est occupée,
	 * elle devient innocupée (si un joueur tir 2 fois sur cette case, il ne doit toucher que la première).
	 */
	public void estTire() {
		if(this.estOccupe) {
			this.estOccupe=false;
			
		}		
		
		this.estTouche=true;
	}
	
	public void estSelectionnerPlacementBateau(Bateau bateau) {
		bateau.setPositionX(this.positionX);
		bateau.setPositionY(this.positionY);
		
		
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Case [type=");
		builder.append(type);
		builder.append(", positionX=");
		builder.append(positionX);
		builder.append(", positionY=");
		builder.append(positionY);
		builder.append(", estTouche=");
		builder.append(estTouche);
		builder.append(", estOccupe=");
		builder.append(estOccupe);
		builder.append("]");
		return builder.toString();
	}
	

}
