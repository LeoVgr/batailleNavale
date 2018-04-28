package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import metier.Partie;

public class AffichagePlateauBateaux extends JPanel implements ActionListener{
	private AffichageBoutonGrillePlateauBateaux[][] jb_case;
	private Partie partie;
	private AffichageFenetreApplication fenetre;
	
	public AffichagePlateauBateaux(Partie partieConstr, AffichageFenetreApplication fenetre) {
		this.partie=partieConstr;
		this.fenetre=fenetre;
		
		// création des composants graphiques 
		jb_case = new AffichageBoutonGrillePlateauBateaux[10][10];
		for(int compteurLettre=0; compteurLettre<10; compteurLettre ++) {
			for(int compteurChiffre=0; compteurChiffre<10; compteurChiffre ++) {
				jb_case[compteurLettre][compteurChiffre] = new AffichageBoutonGrillePlateauBateaux(partie);
			}	
		}
		
		// définition des layout
		this.setLayout(new GridLayout(10,10));
		
		// ajout des composants 
		for(int compteurLettreb=0; compteurLettreb<10; compteurLettreb ++) {
			for(int compteurChiffreb=0; compteurChiffreb<10; compteurChiffreb ++) {
				this.add(jb_case[compteurLettreb][compteurChiffreb]);
				jb_case[compteurLettreb][compteurChiffreb].addActionListener(this);
				
			}	
		}
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// recherche de la case qui a été cliquée
		boolean trouve = false;
		int i=0;
		int j=0;
		
		while(!trouve && i<10 ) {
			while(!trouve && j<10  ) {

				if(e.getSource()==jb_case[i][j]) {
					trouve=true;
				}else {
					j++;
				}
				
			}
			if(!trouve) {
				i++;
				j=0;
			}
			
		}
			
		
		
		
		
		// affichage des couleurs sur la grille 
		for(int ig=0;ig<this.partie.getJoueurs()[0].getBateaux().length;ig++) {
			
			if(this.partie.getJoueurs()[0].getBateaux()[ig].isEstSelectionner()) {
				
				this.partie.getJoueurs()[0].getPlateauBateau().getGrille()[i][j].estSelectionnerPlacementBateau(this.partie.getJoueurs()[0].getBateaux()[ig]);
				
				
				//on vérifie que le bateau ne soit pas déja placé
				if(!this.partie.getJoueurs()[0].getBateaux()[ig].isEstPlace()) {
					// test si le bateau loge ou non
					if(this.partie.getJoueurs()[0].getBateaux()[ig].getMesCase()==null) {
						System.out.println("Erreur de placement");
						
					}else {
						for(int ip =0;ip<this.partie.getJoueurs()[0].getBateaux()[ig].getMesCase().length;ip++) {
							
							
							

							jb_case[this.partie.getJoueurs()[0].getBateaux()[ig].getMesCase()[ip].getPositionX()]
									[this.partie.getJoueurs()[0].getBateaux()[ig].getMesCase()[ip].getPositionY()].setBackground(new Color(0,0,0));
						}
						this.partie.getJoueurs()[0].getBateaux()[ig].setEstPlace(true);
						this.partie.getJoueurs()[0].getBateaux()[ig].setEstSelectionner(false);
					}
						
				}else {
					System.out.println("bateau déja placé");
				}
					
					
				
			}
		}
		
		
		
		
		
		
		
		
		
	}



	
	
	
}
	
