package ihm;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichageRegles extends JPanel implements MouseListener{
	
	private JLabel jl_listeBat;
	private JLabel jl_titre;
	private JLabel jl_phases;
	private JLabel jl_placement;
	private JLabel jl_tirer;
	private JLabel jl_but;
	
	private JButton jb_retour;
	
	private JPanel jp_centre;
	private JPanel jp_haut;
	private JPanel jp_bas;
	
	private AffichageFenetreApplication fenetreApp;
	
		
		public AffichageRegles(AffichageFenetreApplication fenetreAppConstr) {
			
			// on r�cup�re la fenetre de jeu
			this.fenetreApp=fenetreAppConstr;
			
			
			//d�finition du layout
			this.setLayout(new BorderLayout());
			
			//cr�ation des panel et definition des layout
			jp_centre= new JPanel();
			jp_haut = new JPanel();
			jp_bas = new JPanel();
			
			jp_haut.setLayout(new GridBagLayout());
			jp_bas.setLayout(new GridBagLayout());
			
			jp_centre.setLayout(new GridBagLayout());
			
			//cr�ation des composants graphiques
			jb_retour = new JButton("Retour");
			jb_retour.addMouseListener(this);
			
			jl_but = new JLabel("<html>Le but de ce jeu est de tirer sur tous les bateaux du joueur adverse et de les couler.</html>");
			
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
			
			jl_phases = new JLabel("<html>Une partie se d�roule en 2 phases:"
					+ "<br>"
					+"<br> - une phase o� chaque joueur place ses bateaux sur une grille,"
					+"<br> - une phase o� chaque joueur va essayer de tirer sur les bateaux du joueur adverse."
					+"<br>"
					+"<br>Pour finir le tour, il faut cliquer sur 'valider'.</html>");
			
			jl_placement = new JLabel("<html><h2><center>Placement des bateaux</center></h2>"
					+ "<br>"
					+ "<br>Pour placer un bateau, il faut cliquer sur le nom du bateau souhait�, puis cliquer sur une case de la grille. "
					+ "Vous pourrez alors choisir l'orientation du bateau."
					+ "<br>"
					+ "S'il n'y a pas la place suffisante, un message d'erreur appara�tra. Vous pourrez ensuite le replacer.</html>");
			
			jl_titre = new JLabel("<html><h1>R�gles</h1></html>");
			
			jl_tirer = new JLabel("<html><h2><center>Tirer</center></h2>"
					+ "<br>Pour tirer, il suffit de cliquer sur une case de la grille. "
					+ "Un message s'affichera, indiquant si vous avez ou non touch� un bateau adverse.</html>");
			
			
			// d�finition des contraintes et ajouts des composants
			GridBagConstraints gridContraintes = new GridBagConstraints();
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 1;
			gridContraintes.insets = new Insets(40, 0, 0, 40);
			jp_centre.add(jl_but, gridContraintes);
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 2;
			gridContraintes.insets = new Insets(40, 0, 0, 40);
			jp_centre.add(jl_phases, gridContraintes);
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 3;
			gridContraintes.insets = new Insets(40, 0, 0, 40);
			jp_centre.add(jl_placement, gridContraintes);
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 4;
			gridContraintes.insets = new Insets(40, 0, 0, 40);
			jp_centre.add(jl_tirer, gridContraintes);
			
			gridContraintes.gridx = 1;
			gridContraintes.gridy = 5;
			jp_centre.add(jb_retour, gridContraintes);
			
			
			gridContraintes.gridx=0;
			gridContraintes.gridy=0;
			jp_haut.add(jl_titre, gridContraintes);
			
			gridContraintes.gridx=0;
			gridContraintes.gridy=0;
			jp_bas.add(jb_retour, gridContraintes);
			
			
			this.add(jp_bas, BorderLayout.SOUTH);
			this.add(jp_haut, BorderLayout.NORTH);			
			this.add(jp_centre, BorderLayout.CENTER);
			this.add(jl_listeBat, BorderLayout.WEST);
		
		this.repaint();
		this.revalidate();
		
		}



		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==jb_retour) {
				fenetreApp.changePanel(this,new  AffichageMenuDemarrage(fenetreApp));
			}
			
		}



		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
