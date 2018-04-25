package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import metier.Bateau;
import metier.Joueur;
import metier.Plateau;
import metier.Case;

public class Pannel extends JPanel implements ActionListener{
	private JLabel jl_titre;
	private JLabel jl_nomJ1;
	private JLabel jl_nomJ2;
	private JLabel jl_tour;
	private JLabel jl_text;
	
	private JButton jb_nouvellePartie;
	private JButton jb_quitter;
	
	private JButton jb_valider;
	private JButton jb_abandon;

	private JRadioButton jrb_porteAvions;
	private JRadioButton jrb_croiseur;
	private JRadioButton jrb_contreTorpi;
	private JRadioButton jrb_sousMarin;
	private JRadioButton jrb_torpi;
	
	private ButtonGroup bg;
	
	private AffichagePlateauBateaux[] plateau;
	
	private JPanel jp_boutonMenu;
	private JPanel jp_est;
	private JPanel jp_ouest;
	private JPanel jp_haut;
	private JPanel jp_menu; // sert a afficher le menu au milieu
	private JPanel jp_bas;
	private JPanel jp_listeBat;
	
	private JTextField jtf_nomJ1;
	private JTextField jtf_nomJ2;
	
	private int compteur=0;
	private String sens="";
	private Bateau bateau;
	private Case tabCase1[];
	private Case case1;
	private Case tabCase3[];
	private Case case3;
	
	//controleurs
	private boolean placementTotJ1=false;
	private boolean placementTotJ2=false;
	private boolean alignement=false;
	private boolean partie1Jouee=false;
	private boolean tirJ1=false;
	private boolean tirJ2=false;
	private boolean porteAvionPlace=false;
	private boolean contreTorpiPlace=false;
	private boolean torpiPlace=false;
	private boolean sousMarinPlace=false;
	private boolean croiseurPlace=false;
	private boolean JRBporteAvion=false;
	private boolean JRBcontreTorpi=false;
	private boolean JRBtorpi=false;
	private boolean JRBsousMarin=false;
	private boolean JRBcroiseur=false;
	
	public Pannel() {
		this.setLayout(new BorderLayout());
		
		
		
		
		
		
		
		plateau = new AffichagePlateauBateaux[4];
		for(int compteurChiffre=0; compteurChiffre<4; compteurChiffre ++) {
			plateau[compteurChiffre] = new AffichagePlateauBateaux();
		}
		
		
		
		
		
		jp_boutonMenu = new JPanel();
		jp_est = new JPanel();
		jp_ouest = new JPanel();
		jp_menu = new JPanel();
		jp_haut =new JPanel();
		jp_bas =new JPanel();
		jp_listeBat =new JPanel();
		
		// définition des layout
		
	
		
		jp_boutonMenu.setLayout(new GridLayout(4,2));
		jp_ouest.setLayout(new BorderLayout());
		jp_est.setLayout(new GridBagLayout());
		jp_menu.setLayout(new GridBagLayout());
		jp_haut.setLayout(new GridBagLayout());
		jp_bas.setLayout(new GridBagLayout());
		jp_listeBat.setLayout(new GridLayout(5,1));
		
		// création composants graphiques
		
		jl_titre = new JLabel("BATAILLE NAVALE");
		jl_nomJ1 = new JLabel("Nom du Joueur 1 : ");
		jl_nomJ2 = new JLabel("Nom du Joueur 2 : ");
		jl_tour = new JLabel("Tour de : ...");
		jl_text = new JLabel("");
		
		jb_nouvellePartie=new JButton("Nouvelle Partie");
		jb_quitter=new JButton("Quitter");
		jb_valider=new JButton("Valider");
		jb_abandon=new JButton("Abandonner");
		
		jtf_nomJ1 = new JTextField("Joueur 1");
		jtf_nomJ2 = new JTextField("Joueur 2");
		
		// ajout des composants graphiques
		//this.add(jl_titre);
		this.add(jp_menu, BorderLayout.CENTER);
		jp_menu.add(jp_boutonMenu);
		
		jp_boutonMenu.add(jl_nomJ1);
		jp_boutonMenu.add(jtf_nomJ1);
		jp_boutonMenu.add(jl_nomJ2);
		jp_boutonMenu.add(jtf_nomJ2);
		
		jp_boutonMenu.add(jb_nouvellePartie);
		jp_boutonMenu.add(jb_quitter);
		
		/*for(int i=0; i<100; i++) {
			jb_case[i] = new JButton("rr");
			jp_grille.add(jb_case[i]);
		}*/
		
		jb_nouvellePartie.addActionListener(this);
		jb_quitter.addActionListener(this);
		jb_valider.addActionListener(this);
		jb_abandon.addActionListener(this);
		
		//radiobutton
		jrb_porteAvions = new JRadioButton("x porte-avions");
		jrb_croiseur = new JRadioButton("x croiseur");
		jrb_contreTorpi = new JRadioButton("x contre-torpilleur");
		jrb_sousMarin = new JRadioButton("x sous-marin");
		jrb_torpi = new JRadioButton("x torpilleur");
		
		bg = new ButtonGroup();
		bg.add(jrb_porteAvions);
		bg.add(jrb_croiseur);
		bg.add(jrb_contreTorpi);
		bg.add(jrb_sousMarin);
		bg.add(jrb_torpi);
		
	
		
		tabCase1 = new Case[100];
		tabCase3 = new Case[100];
	}
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Joueur j1 = new Joueur(jtf_nomJ1.getText(),1,0,new Plateau(), new Plateau());
		Joueur j2 = new Joueur(jtf_nomJ2.getText(),1,0,new Plateau(), new Plateau());
		
		Plateau plateauBatJ1 = new Plateau(j1);
		Plateau plateauRecapTirJ1 = new Plateau(j1);
		
		Plateau plateauBatJ2 = new Plateau(j2);
		Plateau plateauRecapTirJ2 = new Plateau(j2);
		
		j2.setPlateauBateau(plateauBatJ2);
		j2.setPlateauRecapTir(plateauRecapTirJ2);
		
		j1.setPlateauBateau(plateauBatJ1);
		j1.setPlateauRecapTir(plateauRecapTirJ1);
		
		Bateau porteAvionsJ1= new Bateau("Porte-avions", 0, 0, 5, "", plateauBatJ1);
		Bateau croiseurJ1= new Bateau("Croiseur", 0, 0, 4, "", plateauBatJ1);
		Bateau contreTorpiJ1= new Bateau("Contre-torpilleur", 0, 0, 3, "", plateauBatJ1);
		Bateau sousMarinJ1= new Bateau("Sous-marin", 0, 0, 3, "", plateauBatJ1);
		Bateau torpiJ1= new Bateau("Torpilleur", 0, 0, 2, "", plateauBatJ1);
		
		Bateau porteAvionsJ2 = new Bateau("Porte-avions", 0, 0, 5, "", plateauBatJ2);
		Bateau croiseurJ2 = new Bateau("Croiseur", 0, 0, 4, "", plateauBatJ2);
		Bateau contreTorpiJ2 = new Bateau("Contre-torpilleur", 0, 0, 3, "", plateauBatJ2);
		Bateau sousMarinJ2 = new Bateau("Sous-marin", 0, 0, 3, "", plateauBatJ2);
		Bateau torpiJ2 = new Bateau("Torpilleur", 0, 0, 2, "", plateauBatJ2);
		
		
		if (e.getSource()==jrb_porteAvions) {
			
			bateau=porteAvionsJ1;
			JRBporteAvion=true;
			JRBcontreTorpi=false;
			JRBtorpi=false;
			JRBsousMarin=false;
			JRBcroiseur=false;
			
			if (placementTotJ1==true) {
				bateau=porteAvionsJ2;
				JRBporteAvion=true;
				JRBcontreTorpi=false;
				JRBtorpi=false;
				JRBsousMarin=false;
				JRBcroiseur=false;
				}
			
		}
		if (e.getSource()==jrb_croiseur) {
			bateau=croiseurJ1;
			JRBporteAvion=false;
			JRBcontreTorpi=false;
			JRBtorpi=false;
			JRBsousMarin=false;
			JRBcroiseur=true;
			
			if (placementTotJ1==true) {
				bateau=croiseurJ2;
				JRBporteAvion=false;
				JRBcontreTorpi=false;
				JRBtorpi=false;
				JRBsousMarin=false;
				JRBcroiseur=true;
				}
				
		}
		if (e.getSource()==jrb_contreTorpi) {
			bateau=contreTorpiJ1;
			JRBporteAvion=false;
			JRBcontreTorpi=true;
			JRBtorpi=false;
			JRBsousMarin=false;
			JRBcroiseur=false;
			
			if (placementTotJ1==true) {
				bateau=contreTorpiJ2;
				JRBporteAvion=false;
				JRBcontreTorpi=true;
				JRBtorpi=false;
				JRBsousMarin=false;
				JRBcroiseur=false;
		}
		}
		if (e.getSource()==jrb_sousMarin) {
			bateau=sousMarinJ1;
			JRBporteAvion=false;
			JRBcontreTorpi=false;
			JRBtorpi=false;
			JRBsousMarin=true;
			JRBcroiseur=false;
			
			if (placementTotJ1==true) {
				bateau=sousMarinJ2;
				JRBporteAvion=false;
				JRBcontreTorpi=false;
				JRBtorpi=false;
				JRBsousMarin=true;
				JRBcroiseur=false;
			}
		}
		if (e.getSource()==jrb_torpi) {
			bateau=torpiJ1;
			JRBporteAvion=false;
			JRBcontreTorpi=false;
			JRBtorpi=true;
			JRBsousMarin=false;
			JRBcroiseur=false;
			
			if (placementTotJ1==true) {
				bateau=torpiJ2;
				JRBporteAvion=false;
				JRBcontreTorpi=false;
				JRBtorpi=true;
				JRBsousMarin=false;
				JRBcroiseur=false;
				}
		}
		
		
		if(e.getSource()== jb_quitter) {
			System.exit(0);			
		}
		if(e.getSource()== jb_abandon) {
			int answer = JOptionPane.showConfirmDialog(
	                this,
	                "Voulez-vous abandonner la partie ?",
	                "Abandon",
	                JOptionPane.YES_NO_OPTION);
	        if(answer == JOptionPane.YES_OPTION)
	        {
	        	this.removeAll();
	        	
	        	placementTotJ1=false;
	        	placementTotJ2=false;	
	        	partie1Jouee=true;
	        	compteur=0;
	        		
	        	this.setLayout(new BorderLayout());
	        	this.add(jp_menu, BorderLayout.CENTER);
	        	jp_menu.add(jp_boutonMenu);
	        		
	        	jp_boutonMenu.add(jl_nomJ1);
	        	jp_boutonMenu.add(jtf_nomJ1);
	        	jp_boutonMenu.add(jl_nomJ2);
	        	jp_boutonMenu.add(jtf_nomJ2);
	        		
	        	jp_boutonMenu.add(jb_nouvellePartie);
	        	jp_boutonMenu.add(jb_quitter);
	        		
	        	JPanel jp_vict = new JPanel();
	        	jp_vict.setLayout(new GridBagLayout());
	        	this.add(jp_vict, BorderLayout.NORTH);
	        	if (compteur%2==0) {
	        		jl_titre.setText("Victoire de "+jtf_nomJ2.getText());
	        		jp_vict.add(jl_titre);
	        	}
	        	else {
	        		jl_titre.setText("Victoire de "+jtf_nomJ1.getText());
	        		jp_vict.add(jl_titre);
	        	}
	        		
	        		this.repaint();		
	    			this.validate();
	        	
			}
			
		}
		if(e.getSource()==jb_nouvellePartie) {
				
			
			System.out.println(j1);
			
			
			
			this.removeAll();
			
			//Placement des bateaux du joueur 1
			
			
			this.setLayout(new BorderLayout());
			this.add(jp_haut, BorderLayout.NORTH);
			jl_tour.setText("Au tour de "+j1.getNom()+" de jouer ! - Tour "+compteur);
			jp_haut.add(jl_tour);
			jl_text.setText("Placez vos bateaux, vous disposez de: ");
			this.add(jp_ouest, BorderLayout.WEST);
			jp_ouest.add(jl_text, BorderLayout.NORTH);
			jp_ouest.add(jp_listeBat, BorderLayout.CENTER);
			
			
			jrb_porteAvions.addActionListener(this);
			jrb_croiseur.addActionListener(this);
			jrb_contreTorpi.addActionListener(this);
			jrb_sousMarin.addActionListener(this);
			jrb_torpi.addActionListener(this);
			
			jrb_porteAvions.addActionListener(new EcouteurRadioButton());
			jrb_croiseur.addActionListener(new EcouteurRadioButton());
			jrb_contreTorpi.addActionListener(new EcouteurRadioButton());
			jrb_sousMarin.addActionListener(new EcouteurRadioButton());
			jrb_torpi.addActionListener(new EcouteurRadioButton());
			
			
			jp_listeBat.add(jrb_porteAvions);
			jp_listeBat.add(jrb_croiseur);
			jp_listeBat.add(jrb_contreTorpi);
			jp_listeBat.add(jrb_sousMarin);
			jp_listeBat.add(jrb_torpi);
			
			
			this.add(jp_est, BorderLayout.EAST);
			jp_est.add(plateau[0]);
			jp_est.remove(plateau[3]);
			//////////////////////////////////////////////////////
			if (partie1Jouee==false) {
				
			
			
			int j=0;
			for (int i=0; i<100; i++) {
				case1= new Case(null, i, j);	
				tabCase1[i] = case1;
				if (i%10==9)
					j+=1;
			}
			
			
			j=0;
			for (int i=0; i<100; i++) {
				case3= new Case(null, i, j);	
				tabCase3[i] = case3;
				if (i%10==9)
					j+=1;
			}
			
			
			
			}
			////////////////////////////////////////////////
			
			
			this.add(jp_bas, BorderLayout.SOUTH);
			jp_bas.add(jb_valider); //listener manquant            aled -- enfin jsuis pas sûre de cque j'ai foutu         /////!!!!\\\\\\\
			jp_bas.add(jb_abandon);
			
			this.repaint();		
			this.validate();
			compteur++;
		}
		
		for (int i=0; i<100; i++) {
		
		if(e.getSource()==plateau[i] || e.getSource()==plateau[i]) { 
			
			if (i==99 || i+bateau.getTaille()>100 || (90<i&& sens.equals("Verticale"))) {
				Object[] options = {"Ok"};
				JOptionPane.showOptionDialog(this,
					"Vous ne pouvez pas placer de bateau ici !",
						"Attention",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE,
						null,
						options,
						options[0]);
			}
			
			else if(placementTotJ1==false) { //pour le j1
				
				if (porteAvionPlace==true && JRBporteAvion==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme porte-avions !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (croiseurPlace==true && JRBcroiseur==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme croiseur !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (contreTorpiPlace==true && JRBcontreTorpi==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme contre-torpilleur !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (sousMarinPlace==true && JRBsousMarin==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme sous-marin !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (torpiPlace==true && JRBtorpi==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme torpilleur !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (alignement==true) {
				
				if (sens.equals("Verticale")) {
					
					int j=i;
					for(int h=i; h<bateau.getTaille()+i; h++) {
						//NOT HERE     / NEED RECUPERER LA CASE
						//bateau.setPositionX(h);
						//bateau.setPositionY(j);
						
						
						plateau[j].setBackground(Color.GRAY);
						j+=10;
					}
					//for(int k=0; k<taille+i; k++){
						
						//porteAvionsJ1.getMesCase()[k].getEstOccupe();
						//System.out.println(porteAvionsJ1.getMesCase()[k].getEstOccupe());

					//}
				}
				if (sens.equals("Horizontale")) 
					for (int h=i; h<bateau.getTaille()+i; h++) {
						plateau[h].setBackground(Color.DARK_GRAY);
						tabCase1[h].setEstOccupe(true);
					}
				}
				if (bateau.getNom().equals("Porte-avions")){
					porteAvionPlace=true;
				}
				if (bateau.getNom().equals("Croiseur")){
					croiseurPlace=true;
				}
				if (bateau.getNom().equals("Contre-torpilleur")){
					contreTorpiPlace=true;
				}
				if (bateau.getNom().equals("Sous-marin")){
					sousMarinPlace=true;
				}
				if (bateau.getNom().equals("Torpilleur")){
					torpiPlace=true;
				}
			
			}
			
			if (placementTotJ1 && placementTotJ2==false) { //pour le j2
				
				if (porteAvionPlace==true && JRBporteAvion==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme porte-avions !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (croiseurPlace==true && JRBcroiseur==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme croiseur !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (contreTorpiPlace==true && JRBcontreTorpi==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme contre-torpilleur !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (sousMarinPlace==true && JRBsousMarin==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme sous-marin !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (torpiPlace==true && JRBtorpi==true){
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
						"Vous ne pouvez pas placer un deuxieme torpilleur !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				else if (alignement==true) {
				
				if (sens.equals("Verticale")) {
					
					int j=i;
					for(int h=i; h<bateau.getTaille()+i; h++) {
					
						plateau[3][j].setBackground(Color.GREEN);
						j+=10;
					}
				}
				if (sens.equals("Horizontale")) 
					for (int h=i; h<bateau.getTaille()+i; h++) {
						jb_case3[h].setBackground(Color.GREEN);
						tabCase3[h].setEstOccupe(true);
					}
				}
			if (bateau.getNom().equals("Porte-avions")){
				porteAvionPlace=true;
			}
			if (bateau.getNom().equals("Croiseur")){
				croiseurPlace=true;
			}
			if (bateau.getNom().equals("Contre-torpilleur")){
				contreTorpiPlace=true;
			}
			if (bateau.getNom().equals("Sous-marin")){
				sousMarinPlace=true;
			}
			if (bateau.getNom().equals("Torpilleur")){
				torpiPlace=true;
			}
			
			}
		}
		}
		
		for (int i=0; i<100; i++) {
		if (e.getSource()==jb_case2[i] && tirJ1==false) {
			System.out.println("caaaaaaaaaaaaase");
			if (tabCase1[0].getEstOccupe()==true){
				System.out.println(bateau.getNom());
				if (bateau.getNbrTouche()<bateau.getTaille()-1)    {
					Object[] options = {"Ok"};
				JOptionPane.showOptionDialog(this,
						"Touché !",
							"Résultat du tir",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE,
							null,
							options,
							options[0]);
							
							bateau.setNbrTouche(1);
							jb_case2[i].setBackground(Color.RED);
				}
					
				else {           
					Object[] options = {"Ok"};
				 JOptionPane.showOptionDialog(this,
						"Bateau coulé !",
							"Résultat du tir",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE,
							null,
							options,
							options[0]);
				 jb_case2[i].setBackground(Color.RED);
				}
			}
			
			else { 
			Object[] options = {"Ok"};
				JOptionPane.showOptionDialog(this,
						"Dans l'eau !",
							"Résultat du tir",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE,
							null,
							options,
							options[0]);
				jb_case2[i].setBackground(Color.WHITE);
			}
			tirJ1=true;
			}
		
		else if(e.getSource()==jb_case4[i] && tirJ2==false) {
			System.out.println("caaaaaaaaaaaaase");
		if (tabCase1[0].getEstOccupe()==true){
			System.out.println(bateau.getNom());
			if (bateau.getNbrTouche()<bateau.getTaille()-1)    {
				Object[] options = {"Ok"};
			JOptionPane.showOptionDialog(this,
					"Touché !",
						"Résultat du tir",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						null,
						options,
						options[0]);
						
						bateau.setNbrTouche(1);
						jb_case4[i].setBackground(Color.RED);
			}
				
			else {           
				Object[] options = {"Ok"};
			 JOptionPane.showOptionDialog(this,
					"Bateau coulé !",
						"Résultat du tir",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						null,
						options,
						options[0]);
			 jb_case4[i].setBackground(Color.RED);
			}
		}
		
		else { 
		Object[] options = {"Ok"};
			JOptionPane.showOptionDialog(this,
					"Dans l'eau !",
						"Résultat du tir",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						null,
						options,
						options[0]);
			jb_case4[i].setBackground(Color.WHITE);
		}
		tirJ2=true;
		}
		
		}
		
		if (e.getSource()==jb_valider) {
			
			if(compteur%2==0 && j1.isEstGagnant()==false && j2.isEstGagnant()==false) {
				placementTotJ2=true;
				tirJ1=false;
				this.removeAll();
							
				this.setLayout(new BorderLayout());
				this.add(jp_haut, BorderLayout.NORTH);
				jl_tour.setText("Au tour de "+jtf_nomJ1.getText()+" de jouer ! - Tour "+compteur);
				jp_haut.add(jl_tour);
				jl_text.setText("<html>Choisissez la case où tirer</html>");
				this.add(jl_text, BorderLayout.WEST);
				this.add(jp_est, BorderLayout.EAST);
				jp_est.add(jp_grille);
				jp_est.remove(jp_grille3);
				this.add(jp_grille2, BorderLayout.CENTER);
				
				this.add(jp_bas, BorderLayout.SOUTH);
				jp_bas.add(jb_valider); //listener manquant            aled            /////!!!!\\\\\\
				jp_bas.add(jb_abandon);
				
				this.repaint();	
				this.validate();
				compteur++;
			}
			else if(placementTotJ2==true && j1.isEstGagnant()==false && j2.isEstGagnant()==false){
				tirJ2=false;
				this.removeAll();
				
				this.setLayout(new BorderLayout());
				this.add(jp_haut, BorderLayout.NORTH);
				jl_tour.setText("Au tour de "+jtf_nomJ2.getText()+" de jouer ! - Tour "+compteur);
				jp_haut.add(jl_tour);
				jl_text.setText("<html>Choisissez la case où tirer</html>");
				this.add(jl_text, BorderLayout.WEST);
				this.add(jp_est, BorderLayout.EAST);
				jp_est.remove(jp_grille);
				jp_est.add(jp_grille3);
				this.add(jp_grille4, BorderLayout.CENTER);
				
				this.add(jp_bas, BorderLayout.SOUTH);
				jp_bas.add(jb_valider); //listener manquant            aled            /////!!!!\\\\\\\
				jp_bas.add(jb_abandon);
				
				
				this.repaint();	
				this.validate();
				compteur++;
			}
			else {

				
				placementTotJ1=true;
				alignement=false;
				porteAvionPlace=false;
				contreTorpiPlace=false;
				torpiPlace=false;
				sousMarinPlace=false;
				croiseurPlace=false;
				this.removeAll();
				
				//Placement des bateaux du joueur 2
				this.setLayout(new BorderLayout());
				this.add(jp_haut, BorderLayout.NORTH);
				jl_tour.setText("Au tour de "+j2.getNom()+" de jouer ! - Tour "+compteur);
				jp_haut.add(jl_tour);
				jl_text.setText("Placez vos bateaux, vous disposez de: ");
				this.add(jp_ouest, BorderLayout.WEST);
				jp_ouest.add(jl_text, BorderLayout.NORTH);
				jp_ouest.add(jp_listeBat, BorderLayout.CENTER);
				
				this.remove(jp_grille2);
				
				this.add(jp_est, BorderLayout.EAST);
				jp_est.remove(jp_grille);
				jp_est.add(jp_grille3);
				
				
				
				
				this.add(jp_bas, BorderLayout.SOUTH);
				jp_bas.add(jb_valider); //listener manquant            aled -- enfin jsuis pas sûre de cque j'ai foutu         /////!!!!\\\\\\\
				jp_bas.add(jb_abandon);
				
				
				
				this.repaint();		
				this.validate();
				compteur++;
				
			}
		}
	}*/
	
	class EcouteurRadioButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			
			String[] choix = {"Horizontale", "Verticale"};
			 Object reponse = JOptionPane.showInputDialog
			(null, 
				"Choisissez l'orientation du bateau: ", 
				"Orientation du bateau", 
				JOptionPane.QUESTION_MESSAGE,
			null,
			choix,
			choix[0]);
			 if (reponse.equals("Horizontale")) {
				 System.out.println("hori");
				 sens="Horizontale";
			 }
			 else if(reponse.equals("Verticale")) {
				 System.out.println("verti");
				 sens="Verticale";
			 }
			alignement=true;
			
			
		} 
		
	}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
	
	
}
