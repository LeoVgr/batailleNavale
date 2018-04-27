package ihm;

import java.awt.Panel;

import javax.swing.JFrame;



public class AffichageFenetreApplication extends JFrame  {
	
	public AffichageFenetreApplication(){
		
		this.setDefaultLookAndFeelDecorated(false); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setTitle("Bataille Navale");
	
		//this.setUndecorated(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.getContentPane().add(new AffichageMenuDemarrage(this));
		this.repaint();
		this.setVisible(true);
	}
	
	public void changePanel(Panel panel) {
		this.removeAll();
		this.add(panel);
		this.getContentPane().add(panel);
		
		this.repaint();
		this.revalidate();
		
	
		
	}
}
