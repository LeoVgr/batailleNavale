package com.iut.batNav.application;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ihm.AffichageFenetreApplication;
import ihm.AffichagePlateauBateaux;



public class ApplicationBatNav extends JFrame{
	public static void main(String[] args) {
		
		// Création de la fenêtre de l'application
		AffichageFenetreApplication fenetre = new AffichageFenetreApplication();
				
	}

	
}
 class Menu extends JMenuBar implements MouseListener{

	 JMenu quitterMenu = new JMenu("Quitter");
	 
	    JMenuItem item = new JMenuItem("");

	    // Création du menu Regles
	    JMenu regleMenu = new JMenu("Règles");
	    
	    // Création du menu Options
	    JMenu optionsMenu = new JMenu("Options");
	    
	    // Création du menu Partie
	    JMenu partieMenu = new JMenu("Partie");
	    JMenu sousMenuPartie = new JMenu("Nouvelle partie");

	  
	    
	    
	    
	    
	  public Menu() {

	    // Listener générique qui affiche l'action du menu utilisé
	    ActionListener afficherMenuListener = new ActionListener() {
	      public void actionPerformed(ActionEvent event) {
	        System.out.println("Elément de menu [" + event.getActionCommand()
	            + "] utilisé.");
	      }
	    };

	    // Création du menu Quitter
	    JMenu quitterMenu = new JMenu("Quitter");
	 
	    JMenuItem item = new JMenuItem("");

	    // Création du menu Regles
	    JMenu regleMenu = new JMenu("Règles");
	    
	    // Création du menu Options
	    JMenu optionsMenu = new JMenu("Options");
	    
	    // Création du menu Partie
	    JMenu partieMenu = new JMenu("Partie");
	    JMenu sousMenuPartie = new JMenu("Nouvelle partie");

	    item.addActionListener(afficherMenuListener);
	    item = new JMenuItem("1 joueur");
	    sousMenuPartie.add(item);
	    item = new JMenuItem("2 joueurs");
	    sousMenuPartie.add(item);

	    partieMenu.add(sousMenuPartie);
	    
	    
	    sousMenuPartie.insertSeparator(1);

	    quitterMenu.addMouseListener(this);
	    
	    
	    // ajout des menus à la barre de menus
	    add(partieMenu);
	    add(optionsMenu);
	    add(regleMenu);
	    add(quitterMenu);

	  }
	  
	  
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("cliqué");
		if (e.getSource()==quitterMenu) {
			  System.exit(0);
			  System.out.println("tryin to escape");
		  }
		if (e.getSource().equals("javax.swing.JMenu[,155,0,51x21,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.metal.MetalBorders$MenuItemBorder@edaa99,flags=256,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,disabledSelectedIcon=,margin=javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=2],paintBorder=true,paintFocus=false,pressedIcon=,rolloverEnabled=false,rolloverIcon=,rolloverSelectedIcon=,selectedIcon=,text=Quitter]")){
			  System.exit(0);
			  System.out.println("tryin to escape2");
		  }
		System.out.println(e.getSource());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("entré");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("exit");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("press");
		  
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("realesed");
		 
	}
	
	
 }

