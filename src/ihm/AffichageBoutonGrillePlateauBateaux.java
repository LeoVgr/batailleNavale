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
	private AffichagePlateauBateaux panel;
	
	
	public AffichageBoutonGrillePlateauBateaux(Partie partieConstr,int posX,int posY, AffichagePlateauBateaux panel) {
		this.partie=partieConstr;
		this.posX=posX;
		this.posY=posY;
		this.panel=panel;
	
		this.addMouseListener(this);
		this.setBackground(new Color(175,175,191));
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
		
		for(int ig=0;ig<this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux().length;ig++) {
			if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].isEstSelectionner()) {
				if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)!=null) {
					for(int compteur=0;compteur<this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY).length;compteur++) {
						
						panel.getJb_case()[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionX()]
								[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionY()]
										.setBackground(new Color(40,100,12));
						
						
						
				
					}
					
				}
			}
		}
			
			
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		for(int ig=0;ig<this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux().length;ig++) {
			if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].isEstSelectionner()) {
				if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)!=null) {
					for(int compteur=0;compteur<this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY).length;compteur++) {
						
						
						if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getPlateauBateau().getGrille()[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionX()]
								[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionY()].getEstOccupe()) {
							panel.getJb_case()[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionX()]
									[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionY()]
											.setBackground(new Color(0,0,0));
							
						}else {
							panel.getJb_case()[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionX()]
									[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(posX, posY)[compteur].getPositionY()]
											.setBackground(new Color(175,175,191));
						}
						
						
						
						
						
				
					}
					
				}
			}
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
