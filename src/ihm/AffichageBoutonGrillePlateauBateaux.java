package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import metier.Partie;

public class AffichageBoutonGrillePlateauBateaux extends JButton implements MouseListener{
	private Partie partie;
	private int posX;
	private int posY;
	
	
	public AffichageBoutonGrillePlateauBateaux(Partie partieConstr,int posX,int posY) {
		this.partie=partieConstr;
		this.posX=posX;
		this.posY=posY;
		this.addMouseListener(this);
		this.setBackground(new Color(175,175,191));
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		this.setBackground(new Color(40,100,12));
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getPlateauBateau().getGrille()[posX][posY].getEstOccupe()) {
			this.setBackground(new Color(0,0,0));
		}else {
			this.setBackground(new Color(175,175,191));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
