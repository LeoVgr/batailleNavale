package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.Partie;

public class AffichageMenuDeuxJoueurs extends JPanel implements MouseListener{
	private AffichageFenetreApplication fenetreApp;

	private JLabel jl_nouvellePartie;
	private JLabel jl_retour;
	
	private JTextField jtf_nomJ1;
	private JTextField jtf_nomJ2;
	
	private JLabel jl_texte;
	private JLabel jl_nomJ1;
	private JLabel jl_nomJ2;
	
	
	/**
	 * Constructeur de la classe AffichageMenuDeuxJoueurs, permet de créer un menu deux joueurs (ou il faut entrer les noms des joueurs
	 * et valider pour lancer la partie. Cette étape permet de récupérer les noms des joueurs.
	 * @param fenetreAppConstr
	 */
	public AffichageMenuDeuxJoueurs(AffichageFenetreApplication fenetreAppConstr) {
		
	
	this.fenetreApp=fenetreAppConstr;
	
	
	// Définition du layout et des contraintes
	this.setLayout(new GridBagLayout());
	GridBagConstraints gridContraintes = new GridBagConstraints();
	
	
	// création des composant graphique
	jl_texte = new JLabel("");
	jl_nomJ1 = new JLabel("Nom du Joueur 1 : ");
	jl_nomJ2 = new JLabel("Nom du Joueur 2 : ");
	
	jl_nouvellePartie=new JLabel("Nouvelle Partie");
	jl_retour=new JLabel("Retour");
	
	jtf_nomJ1 = new JTextField("Joueur 1");
	jtf_nomJ2 = new JTextField("Joueur 2");
	
	jtf_nomJ1.setPreferredSize(new Dimension(200,30));
	jtf_nomJ2.setPreferredSize(new Dimension(200,30));
	
	// ajout des composants graphiques
	
	gridContraintes.gridx =0;
	gridContraintes.gridy =0;
	gridContraintes.insets = new Insets(0, 0, 30, 40);
	this.add(jl_nomJ1, gridContraintes);
	
	gridContraintes.gridx =1;
	gridContraintes.gridy =0;
	gridContraintes.insets = new Insets(0, 0, 30, 0);
	this.add(jtf_nomJ1, gridContraintes);
	
	gridContraintes.gridx =0;
	gridContraintes.gridy =1;
	gridContraintes.insets = new Insets(0, 0, 30, 40);
	this.add(jl_nomJ2, gridContraintes);
	
	gridContraintes.gridx =1;
	gridContraintes.gridy =1;
	gridContraintes.insets = new Insets(0, 0, 30, 0);
	this.add(jtf_nomJ2, gridContraintes);
	
	gridContraintes.gridx =0;
	gridContraintes.gridy =2;
	gridContraintes.insets = new Insets(30, 0, 30, 0);
	this.add(jl_nouvellePartie, gridContraintes);
		
	gridContraintes.gridx =1;
	gridContraintes.gridy =2;
	gridContraintes.insets = new Insets(30, 0, 30, 0);
	this.add(jl_retour, gridContraintes);
	
	jl_nouvellePartie.addMouseListener(this);
	jl_retour.addMouseListener(this);
	
	this.add(jl_texte, gridContraintes);
	
	
	// création est mise en place de la police des textes du menu
	Font font = new Font("Arial",Font.BOLD,20);
		  
	jl_texte.setFont(font);
	jl_nomJ1.setFont(font);
	jl_nomJ2.setFont(font);
	jl_retour.setFont(font);
	jl_nouvellePartie.setFont(font);
	
	
	
}

	
	/**
	 * Permet de lancer les traitements associés lorsque l'utilisateur clique sur une option du menu.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==jl_nouvellePartie) {
			fenetreApp.changePanel(this, new AffichagePartieDeuxJoueurs(fenetreApp,new Partie(jtf_nomJ1.getText(),jtf_nomJ2.getText())));
		}
		if(e.getSource()==jl_retour) {
			fenetreApp.changePanel(this,new AffichageMenuDemarrage(fenetreApp));
		}
		
	}
	/**
	 * Permet de faire des effet grisés lorsque l'utilisateur passe une option.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==jl_nouvellePartie ) {
			jl_nouvellePartie.setForeground(new Color(175,166,164));
		}
		if (e.getSource()==jl_retour) {
		jl_retour.setForeground(new Color(175,166,164));
		}
	}
	/**
	 * Permet de rétablir les couleurs de l'option lorsque l'utilisateur n'est plus sur l'option.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		jl_retour.setForeground(new Color(0,0,0));
		jl_nouvellePartie.setForeground(new Color(0,0,0));
		
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