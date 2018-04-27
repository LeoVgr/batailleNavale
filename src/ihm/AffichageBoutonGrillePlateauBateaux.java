package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import metier.Partie;

public class AffichageBoutonGrillePlateauBateaux extends JButton implements ActionListener{
	private Partie partie;
	
	
	public AffichageBoutonGrillePlateauBateaux(Partie partieConstr) {
		this.partie=partieConstr;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setBackground(new Color(0,0,0));
		
	
		
		
	}
}
