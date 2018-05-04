package ihm;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


import metier.Partie;

public class AffichageBoutonGrillePlateauBateaux extends JButton implements MouseListener{
	private Partie partie;
	private int posX;
	private int posY;
	private AffichagePlateauBateaux panel;
	private boolean sourisDessus;
	
	/**
	 * Constructeur par d�faut d'un bouton qui sera sur la grille de bateau. A utiliser en priorit�
	 * @param partieConstr controlleur de l'application
	 * @param posX position x du bouton 
	 * @param posY position y du bouton (du bas vers le haut, l'origine �tant en haut � gauche de la grille)
	 * @param panel le panel dans le quel est utilis� le bouton
	 */
	public AffichageBoutonGrillePlateauBateaux(Partie partieConstr,int posX,int posY, AffichagePlateauBateaux panel) {
		this.partie=partieConstr;
		this.posX=posX;
		this.posY=posY;
		this.panel=panel;
		this.sourisDessus=false;
	
		this.addMouseListener(this);
		this.setBackground(new Color(175,175,191));
		
	
	/**
	 * M�thode permettant de savoir si la souris se situe au dessus de l'objet 	
	 */
	}
	public boolean isSourisDessus() {
		return sourisDessus;
	}

	/**
	 * non utilis�
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Cette m�thode va permettre de g�rer les actions qui doivent se d�clench�es lorsque le bouton se situe sous la souris (utile pour le pr�-affichage du
	 * bateau dans notre cas).
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		this.sourisDessus=true;
		
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

	

	/**
	 * M�thode permettant de g�rer ce que l'on va faire lorsque la souris n'est plus au-dessus du bouton (en l'occurence lorsque l'on quitte la case,
	 * on souhaite que le pr�-affichage du bateau s'enl�ve (donc que la case revienne de sa couleur original))
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		this.sourisDessus=false;
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
	/**
	 * non utilis�
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * non utilis�
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
