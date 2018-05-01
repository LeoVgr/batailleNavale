
package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



import ihm.AffichageMenuDeuxJoueurs;
import metier.Bateau;
import metier.Partie;


public class AffichagePartieDeuxJoueurs extends JPanel implements ActionListener{
	
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
	
	
	private int compteur=0;
	
	
	public AffichagePartieDeuxJoueurs(AffichageFenetreApplication fenetreApp, Partie partie) {
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
		
		// création bateau joueur 1
		affNomBat_sousMarin = new AffichageNomBateaux("Sous-Marin", partie,new Bateau[]{partie.getJoueurs()[0].getBateaux()[0],partie.getJoueurs()[1].getBateaux()[0]});
		affNomBat_croiseur = new AffichageNomBateaux("Croiseur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[1],partie.getJoueurs()[1].getBateaux()[1]});
		affNomBat_contreTorpilleur = new AffichageNomBateaux("Contre-torpilleur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[2],partie.getJoueurs()[1].getBateaux()[2]});
		affNomBat_porteAvion = new AffichageNomBateaux("Porte-avion", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[3],partie.getJoueurs()[1].getBateaux()[3]});
		affNomBat_torpilleur = new AffichageNomBateaux("Torpilleur", partie,new Bateau[] {partie.getJoueurs()[0].getBateaux()[4],partie.getJoueurs()[1].getBateaux()[4]});
		
		
		
		jl_tour.setText("Au tour de "+/*jtf_nomJ1.getText()+*/" de jouer ! - Tour "+compteur);		
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
		this.repaint();
		this.validate();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// passage joueur suivant et grille suivante si le bouton valider est pressé
		
		if(e.getSource()==jb_valider) {
			
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
					// si le joueur deux place tous ses bateaux est valide, alors la phase de placement des bateaux est fini
					if(this.partie.getJoueurActuel()==1) {
						//on termine la phase de placement
						this.partie.setPhaseDePlacement(false);
						
						//on enleve la grille de placement 
						this.removeAll();
						this.partie.joueurSuivant();
						
						//on affiche la grille de tir
						plateauxTir[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
						gridContraintes.gridx= 1;
						gridContraintes.gridy=1;
						gridContraintes.insets = new Insets(0, 0, 100, 0);
						this.add(plateauxTir[this.partie.getJoueurActuel()],gridContraintes);
						
						gridContraintes.gridx= 1;
						gridContraintes.gridy=2;
						this.add(jb_valider, gridContraintes);
						
						this.repaint();
						this.revalidate();
						
					}else {
						this.remove(plateauxBateaux[this.partie.getJoueurActuel()]);
						this.partie.joueurSuivant();
						
						
						// on affiche la grille des bateaux du joueurs suivant
						plateauxBateaux[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
						gridContraintes.gridx= 0;
						gridContraintes.gridy=1;
						gridContraintes.insets = new Insets(0, 0, 100, 0);
						this.add(plateauxBateaux[this.partie.getJoueurActuel()],gridContraintes);
						
						this.add(plateauxBateaux[this.partie.getJoueurActuel()]);
						this.repaint();
						this.revalidate();
						bateauxTousPlace=false;
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
					System.out.println("Vos bateaux ne sont pas tous placés");
				}
				
			
				
			}else {
				
			
				//on enleve la grille de placement 
				this.remove(plateauxTir[this.partie.getJoueurActuel()]);
			
				
				//on passe au joueur suivant
				this.partie.joueurSuivant();
				
				//on affiche la grille de tir
				plateauxTir[this.partie.getJoueurActuel()].setPreferredSize(new Dimension(600,600));
				gridContraintes.gridx= 1;
				gridContraintes.gridy=1;
				gridContraintes.insets = new Insets(0, 0, 100, 0);
				this.add(plateauxTir[this.partie.getJoueurActuel()],gridContraintes);
				
				this.repaint();
				this.revalidate();
			}
			
			
			
		}
		
	}



	


	
	
}




