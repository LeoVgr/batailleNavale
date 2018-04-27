package ihm;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ihm.AffichageMenuDeuxJoueurs;
import metier.Partie;


public class NouvellePartieDeuxJoueurs extends JPanel implements ActionListener{
	
	private JLabel jl_tour;
	
	private JButton jb_valider;
	private JButton jb_abandon;
	
	private JPanel jp_tour;
	private JPanel jp_bas;
	
	
	private int compteur=0;
	
	
	public NouvellePartieDeuxJoueurs(AffichageFenetreApplication fenetreApp, Partie partie) {
		
		this.setLayout(new BorderLayout());
		
		jp_tour = new JPanel();
		jp_tour.setLayout(new GridBagLayout());
		
		jp_bas =new JPanel();
		jp_bas.setLayout(new GridBagLayout());
		
		
		jl_tour = new JLabel("");
		jl_tour.setText("Au tour de "+/*jtf_nomJ1.getText()+*/" de jouer ! - Tour "+compteur);		
		jp_tour.add(jl_tour);
		

		jb_valider=new JButton("Valider");
		jb_abandon=new JButton("Abandonner");
		
		
		this.add(jp_tour, BorderLayout.NORTH);
	
		
		this.repaint();
		this.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
