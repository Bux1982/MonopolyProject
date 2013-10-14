package logik.spielfeld;


public class Los extends Spielfeld{

	private final int geldwert; 
	
	/**
	 * Standard-Konstruktor
	 */
	private Los(String name, int position, int geldwert){
		super(name, position);
		this.geldwert = geldwert;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getGeldwert() {
		return geldwert;
	}
}
