package logik.karte;

/**
 * Stellt eine Karte dar
 * @author Sven
 *
 */
public abstract class Karte {
	
	private final String text;
	private final int geld;
		
	public Karte(String text, int geld){
		this.text = text;
		this.geld = geld;
	}
		
	/**
	 * @return Geld welches bei der Karte ausgezahlt oder eingezogen wird 
	 */
	public int getGeld(){
		return geld;
	};

	/**
	 * @return Text der Karte
	 */
	public String getText(){
		return text;
	};
}
