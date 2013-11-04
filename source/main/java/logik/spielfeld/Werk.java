package logik.spielfeld;

/**
 * Erstellt eine neues Werk
 * 
 * @author Sven
 */
public class Werk extends Grundstueck{

	/**
	 * Erstellt eine neues Werk 
	 * @param name name des Spielfelds
	 * @param spielfeldposition Position auf dem Spielplan
	 * @param preis Preis für den Kauf des Grundstücks
	 * @param grundmiete Grundmiete für das Grundstück
	 * @param hypothekswert Wert für die Hypothek
	 * @param gruppe Spielfeldposition der anderen Grundstücke der Gruppe 
	 */
	public Werk(String name, int spielfeldposition, int preis, int grundmiete,
			int hypothekswert, int[] gruppe) {
		super(name, spielfeldposition, preis, grundmiete, hypothekswert, gruppe);
	}
}
