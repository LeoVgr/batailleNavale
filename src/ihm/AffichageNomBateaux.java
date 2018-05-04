package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import metier.Bateau;
import metier.Partie;

public class AffichageNomBateaux extends JLabel implements MouseListener{
	private boolean estSelectionner;
	private Partie partie;
	private Bateau[] monBateau;
	
	/**
	 * Constructeur de la classe AffichageNomBateaux, permet d'insatncier un jlabel des noms des bateaux.
	 * @param partie Controlleur
	 * @param monBateau bateau qui est li� � ce JLabel
	 */
	public AffichageNomBateaux(Partie partie, Bateau[] monBateau) {
		super();
		this.partie = partie;
		this.monBateau=monBateau;
		this.estSelectionner=false;
		Font font = new Font("Arial",Font.BOLD,20);
		this.setFont(font);
		this.addMouseListener(this);
		
	}
	/**
	 * Constructeur de la classe AffichageNomBateaux, permet d'insatncier un jlabel des noms des bateaux.
	 * Constructeur a privil�gier.
	 * @param nom 
	 * @param partie Controlleur
	 * @param monBateau Le Bateau associ� 
	 */
	public AffichageNomBateaux(String nom, Partie partie, Bateau[] monBateau) {
		super(nom);
		this.partie = partie;
		this.monBateau=monBateau;
		this.estSelectionner=false;
		Font font = new Font("Arial",Font.BOLD,20);
		this.setFont(font);
		this.addMouseListener(this);
	}
	
	/**
	 * M�thode permettant de voir si le nom du bateau est s�lectionner (que l'utilisateur a cliqu� dessus)
	 * @return
	 */
	public boolean isEstSelectionner() {
		return estSelectionner;
	}
	/**
	 * Renvoie permettant d'assigner une valeur � la variable estSelectionner
	 * @param estSelectionner
	 */
	public void setEstSelectionner(boolean estSelectionner) {
		this.estSelectionner = estSelectionner;
		
	}

	
	/**
	 * M�thode permettant de s�lectionner un nom de bateau lorsque l'utilisateur clique sur l'objet courant
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		this.estSelectionner=true;
		if(!monBateau[this.partie.getJoueurActuel()].isEstPlace()) {
		monBateau[this.partie.getJoueurActuel()].setEstSelectionner(true);
		this.setForeground((new Color(34,145,21)));
		}
	}
	/**
	 * Cette m�thode permet le traitement de la couleur lorsque le joueur passe la souris sur le JLabel
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if(!monBateau[this.partie.getJoueurActuel()].isEstPlace()) 
		this.setForeground((new Color(175,166,164)));
		
		
	}
	/**
	 * M�thode permettant de mettre la couleur du JLabel en fonction de l'�tat du bateau (rouge si il est d�j� plac�, et noir si il ne l'est pas)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if(monBateau[this.partie.getJoueurActuel()].isEstSelectionner()) {
		this.setForeground((new Color(34,145,21)));
		}
		else if(monBateau[this.partie.getJoueurActuel()].isEstPlace()) {
			this.setForeground((new Color(255,0,0)));
		}
			
		
		else
			this.setForeground(new Color(0,0,0));
		
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
