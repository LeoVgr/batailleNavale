package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Joueur;

public class AffichageEcranVictoire extends JPanel  implements MouseListener{
	private AffichageFenetreApplication fenetreApp;
	
	private JLabel jl_gagnant;
	private JLabel jl_fin;
	
	private GridBagConstraints gridContraintes;
	
	public AffichageEcranVictoire(AffichageFenetreApplication fenetreAppConstr, String gagnant) {

		this.fenetreApp=fenetreAppConstr;
		
		this.setLayout(new GridBagLayout());
		this.gridContraintes = new GridBagConstraints();
		
		Font font = new Font("Arial",Font.BOLD,40);
		
		jl_gagnant = new JLabel(gagnant +" a gagné !");
		jl_gagnant.setFont(font);
		
		jl_fin = new JLabel("Fin");
		jl_fin.setFont(new Font("Arial",Font.BOLD,20));
		jl_fin.addMouseListener(this);
		
		
		gridContraintes.gridx= 0;
		gridContraintes.gridy=0;
		//gridContraintes.insets = new Insets(0, 0, 0, 30 );
		this.add(jl_gagnant, gridContraintes);
	
		
		gridContraintes.gridx= 0;
		gridContraintes.gridy=1;
		gridContraintes.insets = new Insets(100, 0, 0, 0);
		this.add(jl_fin, gridContraintes);
		
		this.repaint();
		this.revalidate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==jl_fin) {
			fenetreApp.changePanel(this,new  AffichageMenuDemarrage(fenetreApp));
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==jl_fin) {
			jl_fin.setForeground(new Color(175,166,164));
		}
		
	}
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
