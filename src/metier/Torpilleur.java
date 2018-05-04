package metier;

public class Torpilleur extends Bateau {
	/**
	 * Construit un Torpilleur avec un nom et une taille adéquats
	 * @param plateau plateau de jeu
	 */
	public Torpilleur(Plateau plateau) {
		super("Torpilleur",0,0,2,"vertical",plateau);
	}
}
