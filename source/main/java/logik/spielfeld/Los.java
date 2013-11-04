package logik.spielfeld;

/**
 * Darstellung des Spielfelds Los
 * @author Alina
 *
 */
public class Los extends Spielfeld{

	private final int geldwert; 
	
	/**
	 * Erstellt ein neues Los-Spielfeld
	 * @param geldwert der Geldwert der beim überschreiten von Los ausgezahlt wird
	 */
	public Los(int geldwert){
		super("Los", 0);
		this.geldwert = geldwert;
	}

	public int getGeldwert() {
		return geldwert;
	}
}
