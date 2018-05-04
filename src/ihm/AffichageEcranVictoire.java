package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Partie;


public class AffichageEcranVictoire extends JPanel  implements MouseListener{
	private AffichageFenetreApplication fenetreApp;
	
	private Partie partie;
	
	private JLabel jl_gagnant;
	private JLabel jl_fin;
	private JLabel jl_image;
	private JLabel jl_score;
	
	private int compteur;
	
	private GridBagConstraints gridContraintes;
	
	/**
	 * Constructeur de l'ecran de victoire/fin du jeu. 
	 * Affiche le joueur gagnant, son score, le nombre de tours joues
	 * @param fenetreAppConstr Fenetre de l'application
	 * @param String gagnant le nom du joueur qui a gagné
	 * @param partie Controleur
	 * @param int compteur le nombre de tours joués
	 */
	public AffichageEcranVictoire(AffichageFenetreApplication fenetreAppConstr, String gagnant, Partie partie, int compteur) {
 
	
		this.partie=partie;
		
		this.compteur=compteur;
		
		this.fenetreApp=fenetreAppConstr;
		this.fenetreApp.playSoundVictoire();
		
		this.setLayout(new GridBagLayout());
		this.gridContraintes = new GridBagConstraints();
		
		ImageIcon image = new ImageIcon(this.getClass().getResource("/victoire.jpg"));
		
		Font font = new Font("Arial",Font.BOLD,40);
		
		jl_gagnant = new JLabel( gagnant +" a gagné !");
		jl_gagnant.setFont(font);
		
		jl_score = new JLabel( "<html>Score : "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getScore()+"<br>Tour : "+compteur);
		jl_score.setFont(font);
		
		jl_image = new JLabel("");
		jl_image.setIcon(image);
		
		jl_fin = new JLabel("Fin");
		jl_fin.setFont(new Font("Arial",Font.BOLD,20));
		jl_fin.addMouseListener(this);
		
		gridContraintes.gridx= 0;
		gridContraintes.gridy=0;
		gridContraintes.insets = new Insets(0, 0, 30, 0 );
		this.add(jl_image, gridContraintes);
		
		gridContraintes.gridx= 0;
		gridContraintes.gridy=1;
		gridContraintes.insets = new Insets(0, 0, 0, 30 );
		this.add(jl_gagnant, gridContraintes);
	
		gridContraintes.gridx= 0;
		gridContraintes.gridy=2;
		gridContraintes.insets = new Insets(0, 0, 0, 30 );
		this.add(jl_score, gridContraintes);
		
		gridContraintes.gridx= 0;
		gridContraintes.gridy=3;
		gridContraintes.insets = new Insets(100, 0, 0, 0);
		this.add(jl_fin, gridContraintes);
		
		this.repaint();
		this.revalidate();
	}

	/**
	 * Methode qui permet que lorsque le joueur clic sur le JLabel fin, qu'il revienne au menu de demarage.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==jl_fin) {
			fenetreApp.changePanel(this,new  AffichageMenuDemarrage(fenetreApp));
		}
		
	}
	/**
	 * Permet de griser le texte lorsque l'utilisateur passe la souris sur le JLabel jl_fin
	 */
	@Override 
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==jl_fin) {
			jl_fin.setForeground(new Color(175,166,164));
		}
		
	}
	/**
	 * Permet de retablir la couleur du texte lorsque la souris n'est plus sur le label
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		jl_fin.setForeground(new Color(0,0,0));
		
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
