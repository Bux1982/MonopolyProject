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
	 * @param preis Preis für den Kauf des Grundstücks
	 * @param grundmiete Grundmiete für das Grundstück
	 * @param hypothekswert Wert für die Hypothek
	 * @param gruppe Spielfeldposition der anderen Grundstücke der Gruppe 
	 */
	public Bahnhof(String name, int spielfeldposition, int preis,
			int grundmiete, int hypothekswert, int[] gruppe) {
		super(name, spielfeldposition, preis, grundmiete, hypothekswert, gruppe);
	}
}
