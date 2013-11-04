package logik.spielfeld;

/**
 * Darstellung eines Spielfelds, diese hält auch alle Spielfelder die erstellt werden.
 * 
 * @author Sven
 *
 */
public abstract class Spielfeld {	
	
	private final String name;
	private final int spielfeldPosition;
	public static Spielfeld[] alleSpielfelder = new Spielfeld[39];
	
	/**
	 * Erstellt ein neues Spielfeld und fügt es den Spielfeldern hinzu
	 * @param name der Names des Spielfelds 
	 * @param spielfeldposition die Position, beginnend mit 0
	 */
	public Spielfeld(String name, int spielfeldposition) {
		this.name = name;
		this.spielfeldPosition = spielfeldposition;
		alleSpielfelder[spielfeldPosition] = this;
	}
	
	public String getName(){		
		return name;
	}
		
	public int getSpielfeldposition(){	
		return spielfeldPosition;
	}
	
	public static Spielfeld[] getAlleSpielfelder(){
		return alleSpielfelder;
	}
	
}
