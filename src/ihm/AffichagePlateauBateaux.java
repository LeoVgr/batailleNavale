package ihm;

import java.awt.GridLayout;


import javax.swing.JPanel;

public class AffichagePlateauBateaux extends JPanel{
	private AffichageBoutonGrillePlateauBateaux[][] jb_case;
	
	public AffichagePlateauBateaux() {
		
		// création des composants graphiques 
		jb_case = new AffichageBoutonGrillePlateauBateaux[10][10];
		for(int compteurLettre=0; compteurLettre<10; compteurLettre ++) {
			for(int compteurChiffre=0; compteurChiffre<10; compteurChiffre ++) {
				jb_case[compteurLettre][compteurChiffre] = new AffichageBoutonGrillePlateauBateaux();
			}	
		}
		
		// définition des layout
		this.setLayout(new GridLayout(10,10));
		
		// ajout des composants 
		for(int compteurLettre=0; compteurLettre<10; compteurLettre ++) {
			for(int compteurChiffre=0; compteurChiffre<10; compteurChiffre ++) {
				this.add(jb_case[compteurLettre][compteurChiffre]);
			}	
		}
		
		
	}
	
	
}
