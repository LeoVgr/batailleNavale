package ihm;

import javax.swing.JFrame;



public class AffichageFenetreApplication extends JFrame {
	
	public AffichageFenetreApplication(){
		
		this.setDefaultLookAndFeelDecorated(false); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setTitle("Bataille Navale");
	
		//this.setUndecorated(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
<<<<<<< refs/remotes/origin/master
		this.getContentPane().add(new AffichageMenuDemarrage());
=======
		this.getContentPane().add(new AffichageMenuDeuxJoueurs());
>>>>>>> NouvellePartieDeuxJoueurs
		this.repaint();
		this.setVisible(true);
	}
}
