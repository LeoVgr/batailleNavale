package ihm;

import javax.swing.JFrame;

public class AffichageFenetreJeu extends JFrame{

	public AffichageFenetreJeu(){
		
		this.setDefaultLookAndFeelDecorated(false); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setTitle("Bataille Navale");
	
		//this.setUndecorated(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.getContentPane().add(new NouvellePartieDeuxJoueurs());
		this.repaint();
		this.setVisible(true);
		
	}
}
