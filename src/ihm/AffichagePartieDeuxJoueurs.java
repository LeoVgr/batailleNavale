
package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ihm.AffichageMenuDeuxJoueurs;
import metier.Partie;


public class AffichagePartieDeuxJoueurs extends JPanel implements ActionListener{
	
	private JLabel jl_tour;
	private AffichageNomBateaux affNomBat_sousMarin;
	private AffichageNomBateaux affNomBat_croiseur;
	private AffichageNomBateaux affNomBat_contreTorpilleur;
	private AffichageNomBateaux affNomBat_porteAvion;
	private AffichageNomBateaux affNomBat_torpilleur;
	
	
	private JButton jb_valider;
	private JButton jb_abandon;
	
	private JPanel jp_tour;
	private JPanel jp_bas;
	
	private AffichagePlateauBateaux[] plateaux;
	
	
	private int compteur=0;
	
	
	public AffichagePartieDeuxJoueurs(AffichageFenetreApplication fenetreApp, Partie partie) {
	
		// définition du layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gridContraintes = new GridBagConstraints();
		
		//création des composants graphiques
		jp_tour = new JPanel();
		jp_tour.setLayout(new GridBagLayout());
		
		jp_bas =new JPanel();
		jp_bas.setLayout(new GridBagLayout());
		
		
		jl_tour = new JLabel("");
		
		// création bateau joueur 1
		affNomBat_sousMarin = new AffichageNomBateaux("Sous-Marin", partie,partie.getJoueurs()[0].getBateaux()[0]);
		affNomBat_croiseur = new AffichageNomBateaux("Croiseur", partie,partie.getJoueurs()[0].getBateaux()[1]);
		affNomBat_contreTorpilleur = new AffichageNomBateaux("Contre-torpilleur", partie,partie.getJoueurs()[0].getBateaux()[2]);
		affNomBat_porteAvion = new AffichageNomBateaux("Porte-avion", partie,partie.getJoueurs()[0].getBateaux()[3]);
		affNomBat_torpilleur = new AffichageNomBateaux("Torpilleur", partie,partie.getJoueurs()[0].getBateaux()[4]);
		
		jl_tour.setText("Au tour de "+/*jtf_nomJ1.getText()+*/" de jouer ! - Tour "+compteur);		
		jp_tour.add(jl_tour);
		
		plateaux = new AffichagePlateauBateaux[4];
		
		for(int i=0;i< plateaux.length; i++) {
			plateaux[i] = new AffichagePlateauBateaux(partie, fenetreApp);
		}
		
		
		// placement du plateau 1 Joueur
		plateaux[0].setPreferredSize(new Dimension(600,600));
		gridContraintes.gridx= 0;
		gridContraintes.gridy=1;
		gridContraintes.insets = new Insets(0, 0, 100, 0);
		this.add(plateaux[0],gridContraintes);
		
		jb_valider=new JButton("Valider");
		jb_abandon=new JButton("Abandonner");
		
		
		// ajout des composants graphiques
		gridContraintes.gridx= 0;
		gridContraintes.gridy=0;
		this.add(jp_tour, gridContraintes);
		
		gridContraintes.gridx= 0;
		gridContraintes.gridy=2;
		this.add(jb_valider, gridContraintes);
		
		gridContraintes.gridx= 1;
		gridContraintes.gridy=2;
		this.add(jb_abandon, gridContraintes);
		
		// ajout des labels des bateaux
		gridContraintes.gridx= 5;
		gridContraintes.gridy=0;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		this.add(affNomBat_sousMarin, gridContraintes);
		
		gridContraintes.gridx= 6;
		gridContraintes.gridy=0;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		this.add(affNomBat_croiseur, gridContraintes);
		
		gridContraintes.gridx= 7;
		gridContraintes.gridy=0;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		this.add(affNomBat_contreTorpilleur, gridContraintes);
		
		gridContraintes.gridx= 8;
		gridContraintes.gridy=0;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		this.add(affNomBat_porteAvion, gridContraintes);
		
		gridContraintes.gridx= 9;
		gridContraintes.gridy=0;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		this.add(affNomBat_torpilleur, gridContraintes);
		
		
		this.repaint();
		this.validate();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	


	
	
}




