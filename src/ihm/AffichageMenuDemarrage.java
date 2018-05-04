package ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JLabel;
import javax.swing.JPanel;


public class AffichageMenuDemarrage extends JPanel implements MouseListener{
	private AffichageFenetreApplication fenetreApp;
	
	private JLabel jl_deuxJoueurs;
	private JLabel jl_regles;
	private JLabel jl_quitter;
	
	/**
	 * Constrcuteur de la classe AffichageMenuDemarrage. Permet l'affichage d'un menu de démarrage avec trois choix possible.
	 * Gère également les évèenements lié au menu.
	 * @param fenetreAppConstr Fenetre de l'application
	 */
	public AffichageMenuDemarrage(AffichageFenetreApplication fenetreAppConstr) {
		
		// on récupère la fenetre de jeu
		this.fenetreApp = fenetreAppConstr;
		
		//création des composants graphique
		
		jl_deuxJoueurs = new JLabel("2 Joueurs");
		jl_regles = new JLabel("Règles");
		jl_quitter = new JLabel("Quitter");
		
		
		// création est mise en place de la police des textes du menu
		Font font = new Font("Arial",Font.BOLD,50);
		
		
		jl_deuxJoueurs.setFont(font);
		jl_regles.setFont(font);
		jl_quitter.setFont(font);
		
		// définition du layout
		this.setLayout(new GridBagLayout());
		
		// définition des contraintes et ajouts des composants
		GridBagConstraints contraintesGridBag = new GridBagConstraints();
		
		
		
		contraintesGridBag.gridx=0;
		contraintesGridBag.gridy=1;
		contraintesGridBag.insets = new Insets(0, 0, 30, 0);
		this.add(jl_deuxJoueurs, contraintesGridBag);
		
		contraintesGridBag.gridx=0;
		contraintesGridBag.gridy=2;
		contraintesGridBag.insets = new Insets(0, 0, 30, 0);
		this.add(jl_regles, contraintesGridBag);
		
		contraintesGridBag.gridx=0;
		contraintesGridBag.gridy=3;
		this.add(jl_quitter, contraintesGridBag);
		
		// ajout listener
		
		jl_deuxJoueurs.addMouseListener(this);
		jl_quitter.addMouseListener(this);
		jl_regles.addMouseListener(this);
		
		
	}
	
	
	/**
	 * Permet de savoir sur quel choix l'utilisateur a cliqué. 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		

		if(e.getSource() == jl_deuxJoueurs) {
			
			fenetreApp.changePanel(this,new AffichageMenuDeuxJoueurs(fenetreApp));
		}
		if(e.getSource()==jl_regles) {
			fenetreApp.changePanel(this,new AffichageRegles(fenetreApp));
		}
		if(e.getSource() == jl_quitter) {
			System.exit(0);
		}
		
	}
	/**
	 * permet de faire les effets grisé lorsque la souris passe sur l'option
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == jl_deuxJoueurs || e.getSource() == jl_quitter || e.getSource()==jl_regles ) {
			((Component) e.getSource()).setForeground(new Color(175,166,164));
		}
		
	}
	/**
	 * permet de rétablir la couleur initiale du texte lorsque l'utilisateur passe sur l'option.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		jl_deuxJoueurs.setForeground(new Color(0,0,0));
		
		jl_quitter.setForeground(new Color(0,0,0));
		jl_regles.setForeground(new Color(0,0,0));
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
