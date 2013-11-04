package logik.spieler;

/**
 * Darstellung der Spielfigur eines Spielers
 * 
 * @author Sven
 */
public class Figur {
	
	private final String name;
	
	/**
	 * Erstellt eine neue Figur mit dem Namen
	 * @param name Name der Figur
	 */
	public Figur (String name){
		this.name = name;
	}	
	
	public String getName() {
		return name;
	}
}
