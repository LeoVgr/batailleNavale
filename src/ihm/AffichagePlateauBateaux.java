package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import metier.Partie;

public class AffichagePlateauBateaux extends JPanel implements ActionListener,MouseListener{
	private AffichageBoutonGrillePlateauBateaux[][] jb_case;
	private Partie partie;
	private AffichageFenetreApplication fenetre;


	
	public AffichagePlateauBateaux(Partie partieConstr, AffichageFenetreApplication fenetre) {
		this.partie=partieConstr;
		this.fenetre=fenetre;
		
		
		// cr�ation des composants graphiques 
		jb_case = new AffichageBoutonGrillePlateauBateaux[10][10];
		for(int compteurLettre=0; compteurLettre<10; compteurLettre ++) {
			for(int compteurChiffre=0; compteurChiffre<10; compteurChiffre ++) {
				jb_case[compteurLettre][compteurChiffre] = new AffichageBoutonGrillePlateauBateaux(partie);
			}	
		}
		
		// d�finition des layout
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
		
		// recherche de la case qui a �t� cliqu�e
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
			System.out.println(this.partie.getJoueurActuel());
			System.out.println(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].isEstSelectionner()+"");
			if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].isEstSelectionner()) {
				
				this.partie.getJoueurs()[this.partie.getJoueurActuel()].getPlateauBateau().getGrille()[i][j].estSelectionnerPlacementBateau(this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig]);
				
				
				//on v�rifie que le bateau ne soit pas d�ja plac�
				if(!this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].isEstPlace()) {
					
					
					
					
					
					
					// on affecte vertical ou horizontal au bateau (son alignement)
					String[] positionBateau = {"horizontal", "vertical"};
				    JOptionPane jop = new JOptionPane();
				    int rang = jop.showOptionDialog(null, 
				      "Veuillez indiquer la position du bateau !",
				      "Position bateau",
				      JOptionPane.YES_NO_CANCEL_OPTION,
				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      positionBateau,
				      positionBateau[1]);
				    
				    this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].setAlignement(positionBateau[rang]);
					
					
					
					
					
					
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
							this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].mettreMesCasesEnOccup�e();
						}
						
						
					}
						
				}else {
					System.out.println("bateau d�ja plac�");
					this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[ig].setEstSelectionner(false);
				}
					
					
				
			}
		}
		
		
		
		
		
		
		
		
		
	}


	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	
