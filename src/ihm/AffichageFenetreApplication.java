package ihm;

import javax.swing.JFrame;



public class AffichageFenetreApplication extends JFrame {
	
	public AffichageFenetreApplication(){
		
		this.setDefaultLookAndFeelDecorated(false); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setTitle("Bataille Navale");
	
		//this.setUndecorated(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.getContentPane().add(new AffichagePlateauBateaux());
		this.repaint();
		this.setVisible(true);
	}
}
