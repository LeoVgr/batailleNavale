package ihm;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Joueur;

public class AffichageEcranVictoire extends JPanel{
	private AffichageFenetreApplication fenetreApp;
	
	private JLabel jl_gagnant;
	
	public AffichageEcranVictoire(AffichageFenetreApplication fenetreAppConstr, String gagnant) {

		this.setLayout(new GridBagLayout());

		this.fenetreApp=fenetreAppConstr;
		jl_gagnant = new JLabel(gagnant +" a gagné");
		
		this.add(jl_gagnant);
	
		this.repaint();
		this.revalidate();
	}
}
