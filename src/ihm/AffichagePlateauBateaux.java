package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import metier.Partie;

public class AffichagePlateauBateaux extends JPanel implements ActionListener{
	private AffichageBoutonGrillePlateauBateaux[][] jb_case;
	private Partie partie;
	
	public AffichagePlateauBateaux(Partie partieConstr) {
		this.partie=partieConstr;
		
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
		this.partie.getJoueurs()[0].getBateaux()[0].setNom("barque");
		this.partie.getJoueurs()[0].getBateaux()[0].setAlignement("vertical");
		this.partie.getJoueurs()[0].getBateaux()[0].setTaille(5);
		
		System.out.println(i+" "+j);
		this.partie.getJoueurs()[0].getPlateauBateau().getGrille()[i][j].estSelectionnerPlacementBateau(this.partie.getJoueurs()[0].getBateaux()[0]);
		
		
		for(int ip =0;ip<this.partie.getJoueurs()[0].getBateaux()[0].getMesCase().length;ip++) {
			
			
			
			
			jb_case[this.partie.getJoueurs()[0].getBateaux()[0].getMesCase()[ip].getPositionX()]
					[this.partie.getJoueurs()[0].getBateaux()[0].getMesCase()[ip].getPositionY()].setBackground(new Color(0,0,0));
		}
		
		
	}
	
	
}
	
