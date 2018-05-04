package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import metier.Joueur;
import metier.Partie;

public class AffichagePlateauTir extends JPanel implements ActionListener{
	private Partie partie;
	private AffichageFenetreApplication fenetreApp;
	private AffichageBoutonGrillePlateauTirs[][] jb_case;
	private JButton[] nomPosLettre;
	private JButton[] nomPosChiffre;
	
	/**
	 * Constructeur qui permet de construire un panel qui sera la grille des tirs des joueurs.
	 * 
	 * @param partie Controlleur
	 * @param fenetreApp Fenetre de l'application
	 * @param jl_score Score des joueurs 
	 */
	public AffichagePlateauTir(Partie partie, AffichageFenetreApplication fenetreApp, JLabel jl_score) {
		this.partie=partie;
		this.fenetreApp=fenetreApp;
		

		// création des composants graphiques 
		jb_case = new AffichageBoutonGrillePlateauTirs[10][10];
		for(int compteurLettre=0; compteurLettre<10; compteurLettre ++) {
			for(int compteurChiffre=0; compteurChiffre<10; compteurChiffre ++) {
				jb_case[compteurLettre][compteurChiffre] = new AffichageBoutonGrillePlateauTirs(partie,compteurLettre,compteurChiffre);
			}	
		}


		String[] lettre = new String[] {"A","B","C","D","E","F","G","H","I","J"};
		String[] chiffre = new String[] {" ","1","2","3","4","5","6","7","8","9","10"};
		nomPosLettre = new JButton[10];
		nomPosChiffre = new JButton[11];







		for(int i =0; i<nomPosChiffre.length;i++) {
			nomPosChiffre[i]=new JButton(chiffre[i]);
			nomPosChiffre[i].setBackground(new Color(100,100,100));

		}

		// on ajoute une case blanche
		this.add(nomPosChiffre[0]);

		for(int i =0; i<nomPosLettre.length;i++) {
			nomPosLettre[i]=new JButton(lettre[i]);
			nomPosLettre[i].setBackground(new Color(100,100,100));
			this.add(nomPosLettre[i]);
		}

		// définition des layout
		this.setLayout(new GridLayout(11,11));

		// ajout des composants 

		for(int compteurLettreb=0; compteurLettreb<10; compteurLettreb ++) {
			this.add(nomPosChiffre[compteurLettreb+1]);
			for(int compteurChiffreb=0; compteurChiffreb<10; compteurChiffreb ++) {

				this.add(jb_case[compteurLettreb][compteurChiffreb]);
				jb_case[compteurLettreb][compteurChiffreb].addActionListener(this);


			}

		}

	}
	/**
	 * Permet de gérer les actions lié à cette grille nottament les actions de tirs.
	 */
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
		ImageIcon image = new ImageIcon(this.getClass().getResource(""));
		
		
		
		System.out.println(e.getSource());
		
		
		
		switch(this.partie.getJoueurs()[this.partie.getJoueurActuel()].tirer(this.partie.getJoueurs()[this.partie.joueurAdverse(this.partie.getJoueurActuel())], i, j))
		{
		
		case "touché":
			image = new ImageIcon(this.getClass().getResource("/boom.jpg"));
			this.jb_case[i][j].setIcon(image);
			this.partie.getJoueurs()[this.partie.getJoueurActuel()].setScorePlus(100);
			
			break;

		case "eau":
			image = new ImageIcon(this.getClass().getResource("/eau.jpg"));
			this.jb_case[i][j].setIcon(image);
			this.partie.getJoueurs()[this.partie.getJoueurActuel()].setScoreMoins(10);
			break;

		case "coulé":
			image = new ImageIcon(this.getClass().getResource("/boom.jpg"));
			this.jb_case[i][j].setIcon(image);
			Object[] options = {"Ok"};
			this.partie.getJoueurs()[this.partie.getJoueurActuel()].setScorePlus(200);
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
			fenetreApp.changePanel(this, new AffichageEcranVictoire(fenetreApp,this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom(), this.partie));

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

