
package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ihm.AffichageMenuDeuxJoueurs;
import metier.Partie;


public class AffichagePartieDeuxJoueurs extends JPanel implements ActionListener{
	
	private JLabel jl_tour;
	
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
		jl_tour.setText("Au tour de "+/*jtf_nomJ1.getText()+*/" de jouer ! - Tour "+compteur);		
		jp_tour.add(jl_tour);
		
		plateaux = new AffichagePlateauBateaux[4];
		
		for(int i=0;i< plateaux.length; i++) {
			plateaux[i] = new AffichagePlateauBateaux(partie);
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
	
		
		this.repaint();
		this.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}




