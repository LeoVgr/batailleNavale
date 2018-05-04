package metier;

public class Croiseur extends Bateau {
	/**
	 * Construit un Croiseur avec un nom et une taille adéquats
	 * @param plateau plateau de jeu
	 */
	public Croiseur(Plateau plateau) {
		super("Croiseur",0,0,4,"vertical",plateau);
	}
}
