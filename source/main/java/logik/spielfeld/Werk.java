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
	 * @param preis Preis f�r den Kauf des Grundst�cks
	 * @param grundmiete Grundmiete f�r das Grundst�ck
	 * @param hypothekswert Wert f�r die Hypothek
	 * @param gruppe Spielfeldposition der anderen Grundst�cke der Gruppe 
	 */
	public Werk(String name, int spielfeldposition, int preis, int grundmiete,
			int hypothekswert, int[] gruppe) {
		super(name, spielfeldposition, preis, grundmiete, hypothekswert, gruppe);
	}
}
