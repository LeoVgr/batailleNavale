package ihm;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichageEcranVictoire extends JPanel{
	private AffichageFenetreApplication fenetreApp;
	
	private JLabel jl_test;
	
	public AffichageEcranVictoire(AffichageFenetreApplication fenetreAppConstr) {

		this.setLayout(new GridBagLayout());

		this.fenetreApp=fenetreAppConstr;
		jl_test = new JLabel(" a gagné");
		
		this.add(jl_test);
	
		this.repaint();
		this.revalidate();
	}
}
