package logik.spielfeld;
/**
 * Darstellung des Bahnhofs
 * 
 * @author Sven
 *
 */
public class Bahnhof extends Grundstueck {

	/**
	 * Erstellt einen neuen Bahnhof
	 * @param name name des Spielfelds
	 * @param spielfeldposition Position auf dem Spielplan
	 * @param preis Preis f�r den Kauf des Grundst�cks
	 * @param grundmiete Grundmiete f�r das Grundst�ck
	 * @param hypothekswert Wert f�r die Hypothek
	 * @param gruppe Spielfeldposition der anderen Grundst�cke der Gruppe 
	 */
	public Bahnhof(String name, int spielfeldposition, int preis,
			int grundmiete, int hypothekswert, int[] gruppe) {
		super(name, spielfeldposition, preis, grundmiete, hypothekswert, gruppe);
	}
}
