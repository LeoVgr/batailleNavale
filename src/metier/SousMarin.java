package metier;

public class SousMarin extends Bateau{
	/**
	 * Construit un Sous marin avec un nom et une taille ad�quats
	 * @param plateau plateau de jeu
	 */
	public SousMarin(Plateau plateau) {
		super("Sous-marin",0,0,3,"vertical",plateau);
	}
}
