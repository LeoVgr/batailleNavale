package ihm;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.Partie;

public class AffichageMenuDeuxJoueurs extends JPanel implements ActionListener{
	private AffichageFenetreApplication fenetreApp;

	
	
	private JButton jb_nouvellePartie;
	private JButton jb_quitter;
	
	private JPanel jp_boutonMenu;
	private JPanel jp_menu;
	
	private JTextField jtf_nomJ1;
	private JTextField jtf_nomJ2;
	
	private JLabel jl_texte;
	private JLabel jl_nomJ1;
	private JLabel jl_nomJ2;
	
	
	
	
	public AffichageMenuDeuxJoueurs(AffichageFenetreApplication fenetreAppConstr) {
	
	this.fenetreApp=fenetreAppConstr;
	
	this.setLayout(new BorderLayout());

	jp_boutonMenu = new JPanel();
	jp_menu = new JPanel();
	
	jp_boutonMenu.setLayout(new GridLayout(4,2));
	jp_menu.setLayout(new GridBagLayout());
	
	
	jl_texte = new JLabel("");
	jl_nomJ1 = new JLabel("Nom du Joueur 1 : ");
	jl_nomJ2 = new JLabel("Nom du Joueur 2 : ");
	
	jb_nouvellePartie=new JButton("Nouvelle Partie");
	jb_quitter=new JButton("Quitter");
	
	jtf_nomJ1 = new JTextField("Joueur 1");
	jtf_nomJ2 = new JTextField("Joueur 2");
	
	// ajout des composants graphiques
	
	
	this.add(jp_menu, BorderLayout.CENTER);
	jp_menu.add(jp_boutonMenu);
	
	jp_boutonMenu.add(jl_nomJ1);
	jp_boutonMenu.add(jtf_nomJ1);
	jp_boutonMenu.add(jl_nomJ2);
	jp_boutonMenu.add(jtf_nomJ2);
	
	jp_boutonMenu.add(jb_nouvellePartie);
	jp_boutonMenu.add(jb_quitter);
	
	jb_nouvellePartie.addActionListener(this);
	jb_quitter.addActionListener(this);
	
	this.add(jl_texte, BorderLayout.NORTH);
	
	fenetreApp.getContentPane().add(this);
	fenetreApp.revalidate();
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jb_nouvellePartie) {
			this.removeAll();
			System.out.println("vjksbvj");
			this.add(new NouvellePartieDeuxJoueurs(fenetreApp, new Partie()));
			
			this.repaint();
			this.validate();
		}
		
		if(e.getSource()== jb_quitter) {
			System.exit(0);			
		}
		
	}
}