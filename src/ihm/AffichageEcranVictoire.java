package ihm;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Joueur;

public class AffichageEcranVictoire extends JPanel{
	private AffichageFenetreApplication fenetreApp;
	
	private JLabel jl_gagnant;
	private JLabel jl_fin;
	
	public AffichageEcranVictoire(AffichageFenetreApplication fenetreAppConstr, String gagnant) {

		this.fenetreApp=fenetreAppConstr;
		
		this.setLayout(new GridBagLayout());
		
		Font font = new Font("Arial",Font.BOLD,40);
		
	
		jl_gagnant = new JLabel(gagnant +" a gagn� !");
		jl_gagnant.setFont(font);
		this.add(jl_gagnant);
	
		jl_fin = new JLabel("Fin");
		this.add(jl_fin);
		
		this.repaint();
		this.revalidate();
	}
}
