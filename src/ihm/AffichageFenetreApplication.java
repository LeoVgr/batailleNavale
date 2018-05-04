package ihm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class AffichageFenetreApplication extends JFrame  {
	
	/**
	 * Constructeur de la fenêtre de notre applcation. Permet de contenir tous les panels qui suivront 
	 * pour le déroulement du jeu.
	 * 
	 */
	public AffichageFenetreApplication(){
		
		this.setDefaultLookAndFeelDecorated(false); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setTitle("Bataille Navale");
	
		//this.setUndecorated(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.getContentPane().add(new AffichageMenuDemarrage(this));

		URL resource = this.getClass().getResource("/imageAppli.jpg");
        BufferedImage image = null;
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setIconImage(image);
		
		
		
		this.repaint();
		this.setVisible(true);
		
	}
	/**
	 * Méthode permettant de changer un panel par un autre dans la fenetre
	 * @param ancien ancien panel qui sera enlever 
	 * @param panel nouveau panel qui remplacera l'ancien
	 */
	public void changePanel(JPanel ancien,JPanel panel) {
		
		
		this.setContentPane(panel);
		
		this.remove(ancien);
		this.repaint();
		this.validate();
	
	}
	public void playSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/son.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
}
