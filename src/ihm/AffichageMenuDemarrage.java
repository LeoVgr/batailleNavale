package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Partie;

public class AffichageMenuDemarrage extends JPanel implements MouseListener{
	private AffichageFenetreApplication fenetreApp;
	private JLabel jl_unJoueur;
	private JLabel jl_deuxJoueurs;
	private JLabel jl_quitter;
	
	public AffichageMenuDemarrage(AffichageFenetreApplication fenetreAppConstr) {
		
		// on récupère la fenetre de jeu
		this.fenetreApp = fenetreAppConstr;
		
		//création des composants graphique
		jl_unJoueur = new JLabel("1 Joueur");
		jl_deuxJoueurs = new JLabel("2 Joueurs");
		jl_quitter = new JLabel("Quitter");
		
		
		// création est mise en place de la police des textes du menu
		Font font = new Font("Arial",Font.BOLD,50);
		
		jl_unJoueur.setFont(font);
		jl_deuxJoueurs.setFont(font);
		jl_quitter.setFont(font);
		
		// définition du layout
		this.setLayout(new GridBagLayout());
		
		// définition des contraintes et ajouts des composants
		GridBagConstraints contraintesGridBag = new GridBagConstraints();
		
		contraintesGridBag.gridx=0;
		contraintesGridBag.gridy=0;
		contraintesGridBag.insets = new Insets(0, 0, 30, 0);
		this.add(jl_unJoueur,contraintesGridBag);
		
		contraintesGridBag.gridx=0;
		contraintesGridBag.gridy=1;
		contraintesGridBag.insets = new Insets(0, 0, 30, 0);
		this.add(jl_deuxJoueurs, contraintesGridBag);
		
		contraintesGridBag.gridx=0;
		contraintesGridBag.gridy=2;
		this.add(jl_quitter, contraintesGridBag);
		
		// ajout listener
		jl_deuxJoueurs.addMouseListener(this);
		jl_quitter.addMouseListener(this);
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == jl_deuxJoueurs) {
			new AffichageMenuDeuxJoueurs(fenetreApp);
			fenetreApp.remove(this);
		}
		if(e.getSource() == jl_quitter) {
			System.exit(0);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == jl_deuxJoueurs) {
			jl_deuxJoueurs.setForeground(new Color(175,166,164));
		}
		if(e.getSource() == jl_quitter) {
			jl_quitter.setForeground(new Color(175,166,164));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		jl_deuxJoueurs.setForeground(new Color(0,0,0));
		jl_unJoueur.setForeground(new Color(0,0,0));
		jl_quitter.setForeground(new Color(0,0,0));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
