package metier;

public class PorteAvion extends Bateau {
	/**
	 * Construit un Porte avion avec un nom et une taille adéquats
	 * @param plateau plateau de jeu
	 */
	public PorteAvion(Plateau plateau) {
		super("Porte avions",0,0,5,"vertical",plateau);
	}
}
