package ihm;

import java.awt.Color;

import javax.swing.JButton;

import metier.Partie;

public class AffichageBoutonGrillePlateauTirs extends JButton{
	private Partie partie;
	private int posX;
	private int posY;
	
	public AffichageBoutonGrillePlateauTirs(Partie partieConstr,int posX,int posY) {
		this.partie=partieConstr;
		this.posX=posX;
		this.posY=posY;
	
		
		this.setBackground(new Color(175,175,191));
	}
}
