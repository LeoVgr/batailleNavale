package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import metier.Bateau;
import metier.Partie;

public class AffichageNomBateaux extends JLabel implements MouseListener{
	private boolean estSelectionner;
	private Partie partie;
	private Bateau[] monBateau;
	
	public AffichageNomBateaux(Partie partie, Bateau[] monBateau) {
		super();
		this.partie = partie;
		this.monBateau=monBateau;
		this.estSelectionner=false;
		Font font = new Font("Arial",Font.BOLD,20);
		this.setFont(font);
		this.addMouseListener(this);
		
	}
	
	public AffichageNomBateaux(String nom, Partie partie, Bateau[] monBateau) {
		super(nom);
		this.partie = partie;
		this.monBateau=monBateau;
		this.estSelectionner=false;
		Font font = new Font("Arial",Font.BOLD,20);
		this.setFont(font);
		this.addMouseListener(this);
	}
	
	public boolean isEstSelectionner() {
		return estSelectionner;
	}

	public void setEstSelectionner(boolean estSelectionner) {
		this.estSelectionner = estSelectionner;
		
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		this.estSelectionner=true;
		if(!monBateau[this.partie.getJoueurActuel()].isEstPlace()) {
		monBateau[this.partie.getJoueurActuel()].setEstSelectionner(true);
		this.setForeground((new Color(34,145,21)));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(!monBateau[this.partie.getJoueurActuel()].isEstPlace()) 
		this.setForeground((new Color(175,166,164)));
		
		
	}

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
