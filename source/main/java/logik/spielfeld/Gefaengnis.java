package logik.spielfeld;

/**
 * Darstellung für das Gefängnisspielfeld
 * 
 * @author Sven
 */
public class Gefaengnis extends Spielfeld{

	private final int ausloese;
	
	/**
	 * Erstellt ein neues Gefängnisfeld
	 * @param spielfeldposition die Position auf dem Spielfeld
	 * @param ausloese der Preis für die Auslöse aus dem Gefängnis
	 */
	public Gefaengnis(int spielfeldposition, int ausloese){
		super("Gefängnis", spielfeldposition);		
		this.ausloese = ausloese;		
	}
	
	public int getAusloese() {
		return ausloese;
	}
}
