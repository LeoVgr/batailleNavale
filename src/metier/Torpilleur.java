package metier;

public class Torpilleur extends Bateau {
	/**
	 * Construit un Torpilleur avec un nom et une taille ad�quats
	 * @param plateau plateau de jeu
	 */
	public Torpilleur(Plateau plateau) {
		super("Torpilleur",0,0,2,"vertical",plateau);
	}
}
