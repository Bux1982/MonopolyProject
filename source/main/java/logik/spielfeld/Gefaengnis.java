package logik.spielfeld;


public class Gefaengnis extends Spielfeld{

	private final int ausloese;
	
	public Gefaengnis(String name, int spielfeldposition, int ausloese){
		super(name, spielfeldposition);		
		this.ausloese = ausloese;		
	}
	
	public int getAusloese() {
		return ausloese;
	}
}
