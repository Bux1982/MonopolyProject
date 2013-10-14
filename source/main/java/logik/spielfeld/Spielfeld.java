package logik.spielfeld;

public abstract class Spielfeld {	
	
	private final String name;
	private final int spielfeldPosition;
	
	public Spielfeld(String name, int spielfeldposition) {
		this.name = name;
		this.spielfeldPosition = spielfeldposition;
	}
	
	public String getName(){		
		return name;
	};
		
	public int getSpielfeldposition(){	
		return spielfeldPosition;
	};
	
}
