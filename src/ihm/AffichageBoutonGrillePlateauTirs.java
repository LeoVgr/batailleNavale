package ihm;

import java.awt.Color;

import javax.swing.JButton;

import metier.Partie;

public class AffichageBoutonGrillePlateauTirs extends JButton{
	private Partie partie;
	private int posX;
	private int posY;
	
	/**
	 * Constructeur a prioris�. Ce constructeur instancie un objet de la classe AffichageBoutonGrillePlateauTirs 
	 * @param partieConstr Controlleur
	 * @param posX position x du bouton dans la grille
	 * @param posY position y du bouton dans la grille (origine en haut � gauche de la grille)
	 */
	public AffichageBoutonGrillePlateauTirs(Partie partieConstr,int posX,int posY) {
		this.partie=partieConstr;
		this.posX=posX;
		this.posY=posY;
		
		this.setBackground(new Color(175,175,191));
		
		
	}
	
}
