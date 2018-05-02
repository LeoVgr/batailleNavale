package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import metier.Partie;

public class AffichagePlateauTir extends JPanel implements ActionListener{
	private Partie partie;
	private AffichageFenetreApplication fenetreApp;
	private AffichageBoutonGrillePlateauTirs[][] jb_case;
	
	public AffichagePlateauTir(Partie partie, AffichageFenetreApplication fenetreApp) {
		this.partie=partie;
		this.fenetreApp=fenetreApp;
		
		
		// création des composants graphiques 
		jb_case = new AffichageBoutonGrillePlateauTirs[10][10];
		for(int compteurLettre=0; compteurLettre<10; compteurLettre ++) {
			for(int compteurChiffre=0; compteurChiffre<10; compteurChiffre ++) {
				jb_case[compteurLettre][compteurChiffre] = new AffichageBoutonGrillePlateauTirs(partie,compteurLettre,compteurChiffre);
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
		
		// le joueur actuel tir sur le plateau bateau du joueur adverse
		
		switch(this.partie.getJoueurs()[this.partie.getJoueurActuel()].tirer(this.partie.getJoueurs()[this.partie.joueurAdverse(this.partie.getJoueurActuel())], i, j))
		{
		case "touché":
			this.jb_case[i][j].setBackground(new Color(100,0,0));
			break;
		
		case "eau":
			this.jb_case[i][j].setBackground(new Color(0,0,100));
			break;
		
		case "coulé":
			this.jb_case[i][j].setBackground(new Color(100,0,0));
			Object[] options = {"Ok"};
			JOptionPane.showOptionDialog(this,
				"Bateau coulé !",
					"Attention",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					options,
					options[0]);
			break;
			
		case "gagné":
			fenetreApp.changePanel(this, new AffichageEcranVictoire(fenetreApp,this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()));
			
		default :
			Object[] options2 = {"Ok"};
			JOptionPane.showOptionDialog(this,
				"Vous avez déjà tiré sur cette case ou vous avez déjà tiré !",
					"Attention",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE,
					null,
					options2,
					options2[0]);
			break;
		}
		
		
		
		
	
		
		
	
	
	
	
	
	}
	
}	

