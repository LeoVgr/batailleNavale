package metier;

public class ContreTorpilleur extends Bateau {
	/**
	 * Construit un Contre Torpilleur avec un nom et une taille adéquats
	 * @param plateau plateau de jeu
	 */
	public ContreTorpilleur(Plateau plateau) {
		super("Contre torpilleur",0,0,3,"vertical",plateau);
	}
}
