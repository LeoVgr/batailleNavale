package ihm;



import javax.swing.JFrame;
import javax.swing.JPanel;



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
	
	public void changePanel(JPanel ancien,JPanel panel) {
		
		
		this.setContentPane(panel);
		
		this.remove(ancien);
		this.repaint();
		this.validate();
	
	}
	
}
