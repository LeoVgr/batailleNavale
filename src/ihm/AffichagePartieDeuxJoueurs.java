
package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import ihm.AffichageMenuDeuxJoueurs;
import metier.Bateau;
import metier.Joueur;
import metier.Partie;


public class AffichagePartieDeuxJoueurs extends JPanel implements ActionListener{
	private AffichageFenetreApplication fenetreApp;
	
	private JLabel jl_tour;
	
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
	
	public AffichagePartieDeuxJoueurs(AffichageFenetreApplication fenetreApp, Partie partie) {
		this.partie=partie;
		// d�finition du layout
		this.setLayout(new GridBagLayout());
		this.gridContraintes = new GridBagConstraints();
		
		//cr�ation des composants graphiques
		jp_tour = new JPanel();
		jp_tour.setLayout(new GridBagLayout());
		
		jp_bas =new JPanel();
		jp_bas.setLayout(new GridBagLayout());
		
		jp_listeBat =new JPanel();
		jp_listeBat.setLayout(new GridBagLayout());
		
		jl_tour = new JLabel("");
		
		// cr�ation bateau joueur 1
		affNomBat_sousMarin = new AffichageNomBateaux("Sous-Marin", partie,new Bateau[]{partie.getJoueurs()[0].getBateaux()[0],partie.getJoueurs()[1].getBateaux()[0]});
		affNomBat_croiseur = new AffichageNomBateaux("Croiseur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[1],partie.getJoueurs()[1].getBateaux()[1]});
		affNomBat_contreTorpilleur = new AffichageNomBateaux("Contre-torpilleur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[2],partie.getJoueurs()[1].getBateaux()[2]});
		affNomBat_porteAvion = new AffichageNomBateaux("Porte-avion", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[3],partie.getJoueurs()[1].getBateaux()[3]});
		affNomBat_torpilleur = new AffichageNomBateaux("Torpilleur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[4],partie.getJoueurs()[1].getBateaux()[4]});
		
		
		
		Font font= new Font("Arial",Font.PLAIN,20);
		jl_tour = new JLabel("<html>Au tour de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()+" de jouer ! - Tour "+compteur
				+ "<br><br></html>");
		jl_tour.setFont(font);
		jp_tour.add(jl_tour);
		
		plateauxBateaux = new AffichagePlateauBateaux[2];
		plateauxTir = new AffichagePlateauTir[2];
		
		for(int i=0;i< plateauxBateaux.length; i++) {
			plateauxBateaux[i] = new AffichagePlateauBateaux(partie, fenetreApp);
		}
		for(int i=0;i< plateauxTir.length; i++) {
			plateauxTir[i] = new AffichagePlateauTir(partie, fenetreApp);
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
				
		gridContraintes.gridx= 1;
		gridContraintes.gridy=2;
		this.add(jb_valider, gridContraintes);
				
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
        public void actionPerformed(ActionEvent e) {
            	
            	for(int ig=0;ig<partie.getJoueurs()[partie.getJoueurActuel()].getBateaux().length;ig++) {

        			if(partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].isEstSelectionner()) {
        				partie.getJoueurs()[partie.getJoueurActuel()].getBateaux()[ig].tournerBateau();
        			}
            	}
        			
            	
            
            }
        };

        KeyStroke k = KeyStroke.getKeyStroke(KeyEvent.VK_R, 0);
        imap.put(k, "tourner");
        amap.put("tourner", tournerBat);
        this.requestFocus();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==jb_abandon) {
			int answer = JOptionPane.showConfirmDialog(
	                this,
	                "Voulez-vous abandonner la partie ?",
	                "Abandon",
	                JOptionPane.YES_NO_OPTION);
	        /*if(answer == JOptionPane.YES_OPTION) {
	        	int joueurAdverse = this.partie.joueurAdverse(this.partie.getJoueurActuel());
	        	
	        	String gagnant= this.partie.getJoueurs()[joueurAdverse].getNom();
	        	System.out.println(gagnant);
	        	fenetreApp.changePanel(this, new AffichageEcranVictoire(fenetreApp,gagnant));*/

	        //}
		}
		
		// passage joueur suivant et grille suivante si le bouton valider est press�
		
		if(e.getSource()==jb_valider) {
			
			// on regarde si c'est la phase de placement des bateaux ou non
			if(this.partie.isPhaseDePlacement()){
				//on v�rifie que les bateaux du joueurs soient tous plac� avant de l'autoriser � passer au tour suivant
				boolean bateauxTousPlace =true;
				
				for(int compteur=0; compteur< this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux().length;compteur++) {
					if(!this.partie.getJoueurs()[this.partie.getJoueurActuel()].getBateaux()[compteur].isEstPlace()) {
						bateauxTousPlace=false;
					}
				}
				if(bateauxTousPlace) {
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
						
						
						//on affiche la grille de tir
						plateauxTir[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
						gridContraintes.gridx= 1;
						gridContraintes.gridy=1;
						gridContraintes.insets = new Insets(0, 0, 100, 0);
						this.add(plateauxTir[this.partie.getJoueurActuel()],gridContraintes);
						
						this.repaint();
						this.revalidate();
						
					}else {    //placement des bateaux par le joueur 2
						this.remove(plateauxBateaux[this.partie.getJoueurActuel()]);
						this.partie.joueurSuivant();
						
						//mise a jour du tour
						jl_tour.setText("<html>Au tour de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()+" de jouer ! - Tour "+compteur
								+ "<br><br></html>");
						
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
						"Vous n'avez pas plac� tous vos bateaux !",
							"Attention",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[0]);
				}
				
			
				
			}else {
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
				}else {
					//on enleve la grille de placement 
					this.remove(plateauxTir[this.partie.getJoueurActuel()]);
				
					// on recharge l'arme du joueur
					this.partie.getJoueurs()[this.partie.getJoueurActuel()].setTirAutoriser(true);
					
					//mise a jour du tour
					jl_tour.setText("<html>Au tour de "+this.partie.getJoueurs()[this.partie.getJoueurActuel()].getNom()+" de jouer ! - Tour "+compteur
							+ "<br><br></html>");	
					
					//on passe au joueur suivant
					this.partie.joueurSuivant();
					
					//on affiche la grille de tir
					plateauxTir[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
					gridContraintes.gridx= 1;
					gridContraintes.gridy=1;
					gridContraintes.insets = new Insets(0, 0, 100, 0);
					this.add(plateauxTir[this.partie.getJoueurActuel()],gridContraintes);
					
					/*
					gridContraintes.gridx= 2;
					gridContraintes.gridy=1;
					gridContraintes.insets = new Insets(0, 20, 100, 0);
					this.add(plateauxTir[this.partie.getJoueurActuel()+1],gridContraintes);
					
					*/
					
					this.repaint();
					this.revalidate();
				}
			
				
			}
			
			
			
		}
		
	}



	


	
	
}




