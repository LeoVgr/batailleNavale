package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichageRegles extends JPanel implements MouseListener{
	
	private JLabel jl_listeBat;
	private JLabel jl_titre;
	private JLabel jl_phases;
	private JLabel jl_placement;
	private JLabel jl_tirer;
	private JLabel jl_but;
	
	private JLabel jl_retour;
	
	private JPanel jp_centre;
	private JPanel jp_haut;
	private JPanel jp_bas;
	private JPanel jp_listeBat;
	
	private AffichageFenetreApplication fenetreApp;
	
		
		public AffichageRegles(AffichageFenetreApplication fenetreAppConstr) {
			
			// on récupère la fenetre de jeu
			this.fenetreApp=fenetreAppConstr;
			
			
			//définition du layout
			this.setLayout(new BorderLayout());
			
			//création des panel et definition des layout
			jp_centre= new JPanel();
			jp_haut = new JPanel();
			jp_bas = new JPanel();
			jp_listeBat = new JPanel();
			
			jp_haut.setLayout(new GridBagLayout());
			jp_bas.setLayout(new GridBagLayout());
			jp_listeBat.setLayout(new GridBagLayout());
			jp_centre.setLayout(new GridBagLayout());
			
			//création des composants graphiques
			jl_retour=new JLabel("Retour");
			Font font = new Font("Arial",Font.BOLD,30);
			jl_retour.setFont(font);
			jl_retour.addMouseListener(this);
			
			
			Font font2 = new Font("Arial",Font.PLAIN,15);
			
			jl_but = new JLabel("<html><center>Le but de ce jeu est de tirer sur tous les bateaux du joueur adverse et de les couler.</center></html>");
			jl_but.setFont(font2);
			
			jl_listeBat = new JLabel("<html><h2>Liste des bateaux</h2>"
					+ "<br>"
					+ "<br>- porte-avions : 5 cases"
					+ "<br>"
					+ "<br>- croiseur : 4 cases"
					+ "<br>"
					+ "<br>- contre-torpilleur : 3 cases"
					+ "<br>"
					+ "<br>- sous-marin : 3 cases"
					+ "<br>"
					+ "<br>- torpilleur : 2 cases</html>");
			jl_listeBat.setFont(font2);
			
			jl_phases = new JLabel("<html>Une partie se déroule en 2 phases:"
					+ "<br>"
					+"<br> - une phase où chaque joueur place ses bateaux sur une grille,"
					+"<br> - une phase où chaque joueur va essayer de tirer sur les bateaux du joueur adverse."
					+"<br>"
					+"<br>Pour finir le tour, il faut cliquer sur 'valider'.</html>");
			jl_phases.setFont(font2);
			
			jl_placement = new JLabel("<html><h2><center>Placement des bateaux</center></h2>"
					+ "<br>"
					+ "<br>Pour placer un bateau, il faut cliquer sur le nom du bateau souhaité, puis cliquer sur une case de la grille. "
					+ "<br>Il se placera verticalement. Si vous voulez le placer horizontalement, il faut appuyer sur <b>'R'</b> une fois le bateau sélectionné."
					+ "<br>"
					+ "S'il n'y a pas la place suffisante, un message d'erreur apparaîtra. Vous pourrez ensuite le replacer."
					+ "<br>Le bateau que vous avez sélectionné s'affiche en <font color=green><b>vert</b></font>."
					+ "S'il a déjà été placé, le survol de la souris le mettra en <font color=red><b>rouge</b></font>.</html>");
			jl_placement.setFont(font2);
			
			jl_titre = new JLabel("<html>Règles</html>");
			Font font3 = new Font("Arial",Font.BOLD,50);
			jl_titre.setFont(font3);
			
			jl_tirer = new JLabel("<html><h2><center>Tirer</center></h2>"
					+ "<br>Pour tirer, il suffit de cliquer sur une case de la grille. "
					+ "Un message s'affichera, indiquant si vous avez ou non touché un bateau adverse.</html>");
			jl_tirer.setFont(font2);
			
			// définition des contraintes et ajouts des composants
			GridBagConstraints gridContraintes = new GridBagConstraints();
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 1;
			gridContraintes.insets = new Insets(40, 0, 0, 0);
			jp_centre.add(jl_but, gridContraintes);
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 2;
			gridContraintes.insets = new Insets(40, 0, 0, 0);
			jp_centre.add(jl_phases, gridContraintes);
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 3;
			gridContraintes.insets = new Insets(40, 0, 0, 0);
			jp_centre.add(jl_placement, gridContraintes);
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 4;
			gridContraintes.insets = new Insets(40, 0, 0, 0);
			jp_centre.add(jl_tirer, gridContraintes);
			
					
			
			gridContraintes.gridx=0;
			gridContraintes.gridy=0;
			jp_haut.add(jl_titre, gridContraintes);
			
			gridContraintes.gridx=0;
			gridContraintes.gridy=0;
			gridContraintes.insets = new Insets(40, 0, 40, 0);
			jp_bas.add(jl_retour, gridContraintes);
			
			gridContraintes.gridx=0;
			gridContraintes.gridy=0;
			gridContraintes.insets = new Insets(0, 30, 0, 0);
			jp_listeBat.add(jl_listeBat, gridContraintes);
			
			
			this.add(jp_bas, BorderLayout.SOUTH);
			this.add(jp_haut, BorderLayout.NORTH);			
			this.add(jp_centre, BorderLayout.CENTER);
			this.add(jp_listeBat, BorderLayout.WEST);
		
		this.repaint();
		this.revalidate();
		
		}



		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==jl_retour) {
				fenetreApp.changePanel(this,new  AffichageMenuDemarrage(fenetreApp));
			}
			
		}



		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource()==jl_retour) {
				jl_retour.setForeground(new Color(175,166,164));
			}
			
		}



		@Override
		public void mouseExited(MouseEvent arg0) {
			jl_retour.setForeground(new Color(0,0,0));
			
		}



		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}



}
