package logik.spielfeld;

/**
 * Darstellung f�r das Gef�ngnisspielfeld
 * 
 * @author Sven
 */
public class Gefaengnis extends Spielfeld{

	private final int ausloese;
	
	/**
	 * Erstellt ein neues Gef�ngnisfeld
	 * @param spielfeldposition die Position auf dem Spielfeld
	 * @param ausloese der Preis f�r die Ausl�se aus dem Gef�ngnis
	 */
	public Gefaengnis(int spielfeldposition, int ausloese){
		super("Gef�ngnis", spielfeldposition);		
		this.ausloese = ausloese;		
	}
	
	public int getAusloese() {
		return ausloese;
	}
}
