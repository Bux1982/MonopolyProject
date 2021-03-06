package logik.spielfeld;

/**
 * Darstellung einer Strasse auf dem Spielfeld
 * 
 * @author Sven
 */
public class Strasse extends Grundstueck{
	
	private int haeuser;
	private int hotel;
	private final String farbe;
	private final int hauspreis;
	private final int hotelpreis;
	private final int[] mieteprohaus;
	private final int hotelmiete;
	
	/**
	 * Erstellt eine neue Stra�e 
	 * @param name name des Spielfelds
	 * @param spielfeldposition Position auf dem Spielplan
	 * @param preis Preis f�r den Kauf des Grundst�cks
	 * @param grundmiete Grundmiete f�r das Grundst�ck
	 * @param hypothekswert Wert f�r die Hypothek
	 * @param gruppe Spielfeldposition der anderen Grundst�cke der Gruppe
	 * @param farbe die Farbe der Gruppe
	 * @param hauspreis der Preis f�r den Kauf eines einzelnen Hauses
	 * @param hotelpreis der Preis f�r den Kauf eines Hotels
	 * @param mieteprohaus die Miete pro Haus
	 * @param hotelmiete die Miete f�r das Hotel
	 */
	public Strasse(String name, int spielfeldposition, int preis,
			int grundmiete, int hypothekswert, int[] gruppe, String farbe,
			int hauspreis, int hotelpreis, int[] mieteprohaus, int hotelmiete) {
		super(name, spielfeldposition, preis, grundmiete, hypothekswert, gruppe);

		if (mieteprohaus.length != 4){
			throw new IndexOutOfBoundsException("MieteProHaus-Array <> L�nge 4");
		}		
		
		this.hauspreis = hauspreis;
		this.hotelpreis = hotelpreis;
		this.farbe = farbe;
		this.hotelmiete = hotelmiete;
		this.mieteprohaus = mieteprohaus;						
	}

	public int getHauser() {
		return haeuser;
	}

	public void addHaus(int haus) {
		int actHausZahl = this.haeuser;			
		
		this.haeuser += haus;
		
		if (this.haeuser > 4){
			this.haeuser = actHausZahl;
		}
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		if(this.haeuser == 4){
			this.hotel = hotel;
			this.haeuser = 0;
		}			
	}

	public String getFarbe() {
		return farbe;
	}

	public int getHauspreis() {
		return hauspreis;
	}

	public int getHotelpreis() {
		return hotelpreis;
	}

	public int getMieteprohaus(int anzahlHaeuser) {
		return mieteprohaus[anzahlHaeuser];
	}

	public int getHotelmiete() {
		return hotelmiete;
	}		
}
