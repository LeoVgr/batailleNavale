package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Partie;

public class AffichagePlateauBateaux extends JPanel implements ActionListener,MouseListener{
	private AffichageBoutonGrillePlateauBateaux[][] jb_case;
	private Partie partie;
	private AffichageFenetreApplication fenetre;
	private JLabel[] nomPosLettre;
	
	

	
	public AffichagePlateauBateaux(Partie partieConstr, AffichageFenetreApplication fenetre) {
		this.partie=partieConstr;
		this.fenetre=fenetre;
		
		
		// création des composants graphiques 
		jb_case = new AffichageBoutonGrillePlateauBateaux[10][10];
		for(int compteurLettre=0; compteurLettre<10; compteurLettre ++) {
			for(int compteurChiffre=0; compteurChiffre<10; compteurChiffre ++) {
				jb_case[compteurLettre][compteurChiffre] = new AffichageBoutonGrillePlateauBateaux(partie,compteurLettre,compteurChiffre,this);
			}	
		}
		
		
		String[] lettre = new String[] {"A","B","C","D","E","F","G","H","I","J"};
		nomPosLettre = new JLabel[10];
		for(int i =0; i<nomPosLettre.length;i++) {
			nomPosLettre[i]=new JLabel(lettre[i]);
			this.add(nomPosLettre[i]);
		}
		
		// définition des layout
		this.setLayout(new GridLayout(11,11));
		
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
		for(int ig=0;ig<this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux().length;ig++) {
			
			if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].isEstSelectionner()) {
				
				this.partie.getJoueurs()[this.partie.getJoueurActuel()].getPlateauBateau().getGrille()[i][j].estSelectionnerPlacementBateau(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig]);
				
				
				//on vérifie que le bateau ne soit pas déja placé
				if(!this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].isEstPlace()) {
					
					
					// test si le bateau loge ou non
					if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCase()==null) {
						System.out.println("Erreur de placement");
						
					}else {
						// on test si le bateau ne chevauche pas un autre 
						if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].chevaucheUnAutreBateau()){
							System.out.println("chevauchement");
						}else {
							// on place le bateau
							for(int ip =0;ip<this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCase().length;ip++) {
								
								
								

								jb_case[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCase()[ip].getPositionX()]
										[this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].getMesCase()[ip].getPositionY()].setBackground(new Color(0,0,0));
								
							}
							this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].setEstPlace(true);
							this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].setEstSelectionner(false);
							this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].mettreMesCasesEnOccupée();
						}
						
						
					}
						
				}else {
					System.out.println("bateau déja placé");
					this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].setEstSelectionner(false);
				}
					
					
				
			}
		}
		
		
		
		
		
		
		
		
		
	}


	
	public AffichageBoutonGrillePlateauBateaux[][] getJb_case() {
		return jb_case;
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	
