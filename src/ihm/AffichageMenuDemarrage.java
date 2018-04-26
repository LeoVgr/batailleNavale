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

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichageMenuDemarrage extends JPanel{
	private JLabel jl_unJoueur;
	private JLabel jl_deuxJoueurs;
	private JLabel jl_quitter;
	
	public AffichageMenuDemarrage() {
		
		//cr�ation des composants graphique
		jl_unJoueur = new JLabel("1 Joueur");
		jl_deuxJoueurs = new JLabel("2 Joueur");
		jl_quitter = new JLabel("Quitter");
		
		
		// cr�ation est mise en place de la police des textes du menu
		Font font = new Font("Arial",Font.BOLD,50);
		
		jl_unJoueur.setFont(font);
		jl_deuxJoueurs.setFont(font);
		jl_quitter.setFont(font);
		
		// d�finition du layout
		this.setLayout(new GridBagLayout());
		
		// d�finition des contraintes et ajouts des composants
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
		
		// d�finition des listeners
		UnJoueurListener listenerUnJoueur = new UnJoueurListener();
		
		jl_unJoueur.addMouseListener(listenerUnJoueur);
	}
	
	class UnJoueurListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			new AffichageMenuDeuxJoueurs();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			jl_unJoueur.setForeground(new Color(175,166,164));
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			jl_unJoueur.setForeground(new Color(0,0,0));
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
}
