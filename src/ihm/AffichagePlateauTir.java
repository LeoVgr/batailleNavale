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
	private AffichageBoutonGrillePlateauBateaux[][] jb_case;
	
	public AffichagePlateauTir(Partie partie, AffichageFenetreApplication fenetreApp) {
		this.partie=partie;
		this.fenetreApp=fenetreApp;
		
		
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
		
		// le joueur actuel tir sur le plateau bateau du joueur adverse
		
		switch(this.partie.getJoueurs()[this.partie.getJoueurActuel()].tirer(this.partie.getJoueurs()[this.partie.joueurAdverse(this.partie.getJoueurActuel())], i, j))
		{
		case "touch�":
			this.jb_case[i][j].setBackground(new Color(100,0,0));
			break;
		
		case "eau":
			this.jb_case[i][j].setBackground(new Color(0,0,100));
			break;
		
		case "coul�":
			this.jb_case[i][j].setBackground(new Color(100,0,0));
			break;
			
		case "gagn�":
			fenetreApp.changePanel(this, new AffichageEcranVictoire(fenetreApp,this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()));
			
		default :
			Object[] options = {"Ok"};
			JOptionPane.showOptionDialog(this,
				"Vous avez d�j� tir� !",
					"Attention",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE,
					null,
					options,
					options[0]);

			break;
		}
		
		
		
		
	
		
		
	
	
	
	
	
	}
	
}	

