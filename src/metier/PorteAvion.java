package metier;

public class PorteAvion extends Bateau {
	/**
	 * Construit un Porte avion avec un nom et une taille ad�quats
	 * @param plateau plateau de jeu
	 */
	public PorteAvion(Plateau plateau) {
		super("Porte avions",0,0,5,"vertical",plateau);
	}
}
