package ihm;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import metier.Bateau;
import metier.Partie;


public class AffichagePartieDeuxJoueurs extends JPanel implements ActionListener{
	private AffichageFenetreApplication fenetreApp;

	private JLabel jl_tour;
	private JLabel jl_score;
	private JLabel jl_message;
	private JLabel jl_adversaire;

	private Partie partie;

	private AffichageNomBateaux affNomBat_sousMarin;
	private AffichageNomBateaux affNomBat_croiseur;
	private AffichageNomBateaux affNomBat_contreTorpilleur;
	private AffichageNomBateaux affNomBat_porteAvion;
	private AffichageNomBateaux affNomBat_torpilleur;

	private JButton jb_valider;
	private JButton jb_abandon;

	private JPanel jp_tour;
	private JPanel jp_bas;
	private JPanel jp_listeBat;

	private GridBagConstraints gridContraintes;


	private AffichagePlateauBateaux[] plateauxBateaux;
	private AffichagePlateauTir[] plateauxTir; 


	private int compteur=1;
	private boolean finPlacement = false;
	
	/**
	 * Constructeur par défaut du Panel de la partie. Ce panel gère une partie de deux joueurs.
	 * Il contient d'autre panel ainsi que des listener permettant d'intérargir avec l'utilisateur.
	 * @param fenetreApp Fenetre de l'application
	 * @param partie Controlleur
	 */
	public AffichagePartieDeuxJoueurs(AffichageFenetreApplication fenetreApp, Partie partie) {
		
		this.fenetreApp=fenetreApp;
		
		this.partie=partie;
		// définition du layout
		this.setLayout(new GridBagLayout());
		this.gridContraintes = new GridBagConstraints();

		//création des composants graphiques
		jp_tour = new JPanel();
		jp_tour.setLayout(new GridBagLayout());

		jp_bas =new JPanel();
		jp_bas.setLayout(new GridBagLayout());

		jp_listeBat =new JPanel();
		jp_listeBat.setLayout(new GridBagLayout());

		jl_tour = new JLabel("");
		
		
		jl_adversaire = new JLabel("");
	
		
		
		ImageIcon imageSousMarin = new ImageIcon(this.getClass().getResource("/sous-marin.jpg"));
		ImageIcon imageCroiseur = new ImageIcon(this.getClass().getResource("/croiseur.png"));
		ImageIcon imageContreTorpilleur = new ImageIcon(this.getClass().getResource("/contre-torpilleur.png"));
		ImageIcon imagePorteAvions = new ImageIcon(this.getClass().getResource("/porte-avions.jpg"));
		ImageIcon imageTorpilleur = new ImageIcon(this.getClass().getResource("/torpilleur.png"));

		
		// création bateau joueur 1
		affNomBat_sousMarin = new AffichageNomBateaux("Sous-marin", partie,new Bateau[]{partie.getJoueurs()[0].getBateaux()[0],partie.getJoueurs()[1].getBateaux()[0]});
		affNomBat_sousMarin.setIcon(imageSousMarin);
		
		affNomBat_croiseur = new AffichageNomBateaux("Croiseur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[1],partie.getJoueurs()[1].getBateaux()[1]});
		affNomBat_croiseur.setIcon(imageCroiseur);
		
		affNomBat_contreTorpilleur = new AffichageNomBateaux("Contre-torpilleur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[2],partie.getJoueurs()[1].getBateaux()[2]});
		affNomBat_contreTorpilleur.setIcon(imageContreTorpilleur);
		
		affNomBat_porteAvion = new AffichageNomBateaux("Porte-avion", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[3],partie.getJoueurs()[1].getBateaux()[3]});
		affNomBat_porteAvion.setIcon(imagePorteAvions);
		
		affNomBat_torpilleur = new AffichageNomBateaux("Torpilleur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[4],partie.getJoueurs()[1].getBateaux()[4]});
		affNomBat_torpilleur.setIcon(imageTorpilleur);


		Font font= new Font("Arial",Font.PLAIN,20);
		jl_tour = new JLabel("<html>Au tour de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()+" de jouer ! - Tour "+compteur
				+ "<br><br></html>");
		jl_tour.setFont(font);
		
		
		jl_score = new JLabel("");
		jl_score.setFont(font);
		
		jl_message = new JLabel("");
		jl_message.setFont(font);
		
		gridContraintes.gridx = 0;
		gridContraintes.gridy = 0;
		jp_tour.add(jl_tour,gridContraintes);
		
		gridContraintes.gridx = 0;
		gridContraintes.gridy = 1;
		jl_score = new JLabel("Score : "+partie.getJoueurs()[this.partie.getJoueurActuel()].getScore());
		jp_tour.add(jl_score,gridContraintes);
		
		

		plateauxBateaux = new AffichagePlateauBateaux[2];
		plateauxTir = new AffichagePlateauTir[2];

		for(int i=0;i< plateauxBateaux.length; i++) {
			plateauxBateaux[i] = new AffichagePlateauBateaux(partie, fenetreApp);
		}
		for(int i=0;i< plateauxTir.length; i++) {
			plateauxTir[i] = new AffichagePlateauTir(partie, fenetreApp,jl_score, this.compteur);
		}

		jb_valider=new JButton("Valider");
		jb_abandon=new JButton("Abandonner");


		// ajout des labels des bateaux
		gridContraintes.gridx= 0;
		gridContraintes.gridy=1;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		this.add(jp_listeBat, gridContraintes);

		gridContraintes.gridx= 0;
		gridContraintes.gridy=0;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		jp_listeBat.add(affNomBat_sousMarin, gridContraintes);

		gridContraintes.gridx= 0;
		gridContraintes.gridy=1;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		jp_listeBat.add(affNomBat_croiseur, gridContraintes);

		gridContraintes.gridx= 0;
		gridContraintes.gridy=2;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		jp_listeBat.add(affNomBat_contreTorpilleur, gridContraintes);

		gridContraintes.gridx= 0;
		gridContraintes.gridy=3;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		jp_listeBat.add(affNomBat_porteAvion, gridContraintes);

		gridContraintes.gridx= 0;
		gridContraintes.gridy=4;
		gridContraintes.insets = new Insets(0, 0, 0, 30);
		jp_listeBat.add(affNomBat_torpilleur, gridContraintes);

		// ajout des composants graphiques
		gridContraintes.gridx= 1;
		gridContraintes.gridy=0;
		this.add(jp_tour, gridContraintes);
		
		gridContraintes.gridx = 2;
		gridContraintes.gridy = 0;
		this.add(jl_adversaire,gridContraintes);

		gridContraintes.gridx= 1;
		gridContraintes.gridy=2;
		this.add(jb_valider, gridContraintes);

		gridContraintes.gridx= 0;
		gridContraintes.gridy=2;
		this.add(jl_message, gridContraintes);
		
		gridContraintes.gridx= 2;
		gridContraintes.gridy=2;
		this.add(jb_abandon, gridContraintes);
		

		
		// placement des bateaux du 1er Joueurs
		plateauxBateaux[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
		gridContraintes.gridx= 1;
		gridContraintes.gridy=1;
		gridContraintes.insets = new Insets(0, 0, 100, 0);
		this.add(plateauxBateaux[this.partie.getJoueurActuel()],gridContraintes);

		jb_valider.addActionListener(this);
		jb_abandon.addActionListener(this);
		this.repaint();
		this.validate();

		InputMap imap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		ActionMap amap = this.getActionMap();
		Action tournerBat = new AbstractAction() {
			/**
			 * Méthode permettant de gérer le pré-affichage du bateau lorsque le joueur décide de le faire tourner(
			 * pour actualiser son affichage)
			 */
			public void actionPerformed(ActionEvent e) {

				for(int ig=0;ig<partie.getJoueurs()[partie.getJoueurActuel()].getBateaux().length;ig++) {

					if(partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].isEstSelectionner()) {
						for(int caseX=0;caseX<plateauxBateaux[partie.getJoueurActuel()].getJb_case().length;caseX++) {

							for(int caseY=0;caseY<plateauxBateaux[partie.getJoueurActuel()].getJb_case().length;caseY++) {
								if(plateauxBateaux[partie.getJoueurActuel()].getJb_case()[caseX][caseY].isSourisDessus()) {
									//on trouve la case qui est sous la souris


									if(partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)!=null) {
										for(int compteur=0;compteur<partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY).length;compteur++) {



											if(partie.getJoueurs()[partie.getJoueurActuel()].getPlateauBateau().getGrille()[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionX()]
													[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionY()].getEstOccupe()) {

												plateauxBateaux[partie.getJoueurActuel()].getJb_case()[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionX()]
														[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionY()]
																.setBackground(new Color(0,0,0));

											}else {
												plateauxBateaux[partie.getJoueurActuel()].getJb_case()[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionX()]
														[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionY()]
																.setBackground(new Color(175,175,191));
											}
										}
									}
								}
							}
						}



						partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].tournerBateau();

						for(int caseX=0;caseX<plateauxBateaux[partie.getJoueurActuel()].getJb_case().length;caseX++) {

							for(int caseY=0;caseY<plateauxBateaux[partie.getJoueurActuel()].getJb_case().length;caseY++) {
								if(plateauxBateaux[partie.getJoueurActuel()].getJb_case()[caseX][caseY].isSourisDessus()) {
									//on trouve la case qui est sous la souris

									if(partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)!=null) {
										for(int compteur=0;compteur<partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY).length;compteur++) {

												plateauxBateaux[partie.getJoueurActuel()].getJb_case()[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionX()]
														[partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].getMesCasesPositionnement(caseX, caseY)[compteur].getPositionY()]
																.setBackground(new Color(40,100,12));

										}
									}
								}
							}
						}
					}
				}
			}
		};
		
		KeyStroke k = KeyStroke.getKeyStroke(KeyEvent.VK_R, 0);
		imap.put(k, "tourner");
		amap.put("tourner", tournerBat);
		this.requestFocus();

      
	}

	/**
	 * Méthode permettant de récupérer les actions qui se passe sur le panel nottament des boutosn cliqués
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==jb_abandon) {
			int answer = JOptionPane.showConfirmDialog(
					this,
					"Voulez-vous abandonner la partie ?",
					"Abandon",
					JOptionPane.YES_NO_OPTION);
			if(answer == JOptionPane.YES_OPTION) {
				this.partie.joueurSuivant();
	        	int joueurAdverse = this.partie.getJoueurActuel();

	        	String gagnant= this.partie.getJoueurs()[joueurAdverse].getNom();
	        	fenetreApp.changePanel(this, new AffichageEcranVictoire(fenetreApp,gagnant, this.partie, this.compteur));

			}
		}

		// passage joueur suivant et grille suivante si le bouton valider est pressé

		if(e.getSource()==jb_valider) {
			jl_message.setText("");	
			// on regarde si c'est la phase de placement des bateaux ou non
			if(this.partie.isPhaseDePlacement()){
				//on vérifie que les bateaux du joueurs soient tous placé avant de l'autoriser à passer au tour suivant
				boolean bateauxTousPlace =true;
				
				for(int compteur=0; compteur< this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux().length;compteur++) {
					if(!this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[compteur].isEstPlace()) {
						bateauxTousPlace=false;
					}
				}
				if(bateauxTousPlace) {
					jl_message.setText("");
					compteur++;
					// si le joueur deux place tous ses bateaux est valide, alors la phase de placement des bateaux est fini
					if(finPlacement) {
						
						//on termine la phase de placement
						this.partie.setPhaseDePlacement(false);

						//on enleve la grille de placement 
						this.remove(plateauxBateaux[this.partie.getJoueurActuel()]);
						this.remove(plateauxTir[this.partie.getJoueurActuel()]);
						this.remove(jp_listeBat);
						this.partie.joueurSuivant();

						//mise a jour du tour
						jl_tour.setText("<html>Au tour de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()+" de jouer ! - Tour "+compteur
								+ "<br><br></html>");	
						jl_score.setText("Score : "+partie.getJoueurs()[this.partie.getJoueurActuel()].getScore());
						
						this.partie.joueurSuivant();
						jl_adversaire.setText("Rappel des tirs de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom());
						this.partie.joueurSuivant();

						//on affiche la grille de tir
						plateauxTir[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
						gridContraintes.gridx= 1;
						gridContraintes.gridy=1;
						gridContraintes.insets = new Insets(0, 0, 100, 0);
						this.add(plateauxTir[this.partie.getJoueurActuel()],gridContraintes);
						
						
						int joueurAdverse = this.partie.joueurAdverse(this.partie.getJoueurActuel());
	  
						plateauxTir[joueurAdverse].setPreferredSize(new Dimension(550,550));
						gridContraintes.gridx= 2;
						gridContraintes.gridy=1;
						gridContraintes.insets = new Insets(0, 20, 100, 0);
						this.add(plateauxTir[joueurAdverse],gridContraintes);

						this.repaint();
						this.revalidate();

					}else {    //placement des bateaux par le joueur 2
						
						jl_message.setText("");
						
						this.remove(plateauxBateaux[this.partie.getJoueurActuel()]);
						this.partie.joueurSuivant();
						
						// remise a 0 des indications/couleurs
						affNomBat_sousMarin.setForeground((new Color(0,0,0)));
						affNomBat_croiseur.setForeground((new Color(0,0,0)));
						affNomBat_contreTorpilleur.setForeground((new Color(0,0,0)));
						affNomBat_porteAvion.setForeground((new Color(0,0,0)));
						affNomBat_torpilleur.setForeground((new Color(0,0,0)));
						
						//mise a jour du tour
						jl_tour.setText("<html>Au tour de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()+" de jouer ! - Tour "+compteur
								+ "<br><br></html>");
						jl_score.setText("Score : "+partie.getJoueurs()[this.partie.getJoueurActuel()].getScore());
						

						// on affiche la grille des bateaux du joueurs suivant
						plateauxBateaux[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
						gridContraintes.gridx= 1;
						gridContraintes.gridy=1;
						gridContraintes.insets = new Insets(0, 0, 100, 0);
						this.add(plateauxBateaux[this.partie.getJoueurActuel()],gridContraintes);

						this.repaint();
						this.revalidate();
						bateauxTousPlace=false;
						finPlacement=true;
						
					
					}


				}else {
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
							"Vous n'avez pas placé tous vos bateaux !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
					jl_message.setText("Vous n'avez pas placé tous vos bateaux !");
				}
				


			}else {
				jl_message.setText("");
				compteur++;
				if(this.partie.getJoueurs()[this.partie.getJoueurActuel()].isTirAutoriser()) {
					
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(this,
							"Vous devez tirer !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
					jl_message.setText("Vous devez tirer !");
					
				}else {
					
					//on enleve la grille de placement 
					this.remove(plateauxTir[this.partie.getJoueurActuel()]);
					jl_message.setText("");
					// on recharge l'arme du joueur
					this.partie.getJoueurs()[this.partie.getJoueurActuel()].setTirAutoriser(true);

					//on passe au joueur suivant
					this.partie.joueurSuivant();

					//mise a jour du tour
					jl_tour.setText("<html>Au tour de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()+" de jouer ! - Tour "+compteur
							+ "<br><br></html>");
					jl_score.setText("Score : "+partie.getJoueurs()[this.partie.getJoueurActuel()].getScore());
					
					this.partie.joueurSuivant();
					jl_adversaire.setText("Rappel des tirs de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom());
					this.partie.joueurSuivant();
					
					//on affiche la grille de tir
					plateauxTir[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
					gridContraintes.gridx= 1;
					gridContraintes.gridy=1;
					gridContraintes.insets = new Insets(0, 0, 100, 0);
					this.add(plateauxTir[this.partie.getJoueurActuel()],gridContraintes);

					//JOUEUER ADVERSE
					int joueurAdverse = this.partie.joueurAdverse(this.partie.getJoueurActuel());
		        	
					plateauxTir[joueurAdverse].setPreferredSize(new Dimension(550,550));
					gridContraintes.gridx= 2;
					gridContraintes.gridy=1;
					gridContraintes.insets = new Insets(0, 20, 100, 0);
					this.add(plateauxTir[joueurAdverse],gridContraintes);
					

					this.repaint();
					this.revalidate();
				}
			}
		}
	}
}