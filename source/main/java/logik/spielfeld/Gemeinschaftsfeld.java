package logik.spielfeld;

/**
 * Darstellung eines Gemeinschaftsfelds
 * 
 * @author Sven
 */
public class Gemeinschaftsfeld extends Spielfeld{

	/**
	 * Erstellt eine neues Gemeinschaftsfeld für den Spielplan
	 * @param name Name des Gemeinschaftsfeld
	 * @param spielfeldposition Position auf dem Spielplan
	 */
	public Gemeinschaftsfeld(String name, int spielfeldposition) {
		super(name, spielfeldposition);
	}
}
