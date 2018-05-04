package metier;

public class Case {
	private String type;
	private int positionX;
	private int positionY;
	private boolean estTouche;
	private boolean estOccupe;
	
	/**
	 * Constructeur par d�faut qui permet de cr�er un objet case mais qui n'initialise aucun de ses attributs
	 */
	public Case() {
		
	}
	
	
	/**
	 * Constructeur � privil�gier. Ce constructeur permet de cr�er un objet case en initialisant le bool�en
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
	 * M�thode qui g�re le tir sur une case. Elle passe le bool�en estTouch� � vrai et si la case est occup�e,
	 * elle devient innocup�e (si un joueur tir 2 fois sur cette case, il ne doit toucher que la premi�re).
	 */
	public void estTire() {
		if(this.estOccupe) {
			this.estOccupe=false;
			
		}		
		
		this.estTouche=true;
	}
	
	/**
	 * M�thode permettant de dire que ce bateau est s�lectionner afin d'�tre plac�
	 * @param bateau
	 */
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
