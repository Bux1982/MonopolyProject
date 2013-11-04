package logik;

import logik.karte.Karte;
import logik.spieler.Spieler;
import logik.spielfeld.Grundstueck;
import logik.spielfeld.Spielfeld;

public interface Operationen {
	
	/**
	 * Nimmt eine Hypothek zu einem Grundst�ck auf und verringert das Verm�gen
	 * des Spielers
	 * 
	 * @param spieler : Spieler, der die Hypothek aufnimmt
	 * @param grundstueck : Grundst�ck auf das eine Hypothek aufgenommen wird 
	 */
	public void aufnehmenHypothek(Spieler spieler, Grundstueck grundstueck);

	/**
	 * Zahlt eine Hypothek zu einem Grundst�ck aus und schreibt diese dem Guthaben
	 * des Spielers gut
	 *
	 * @param spieler : Spieler, der die Hypothek bekommt
	 * @param grundstueck : Grundst�ck von dem die Hypothek ausgezahlt wird
	 * @param Gibt den Hypothekswert zur�ck 
	 */
	public int auszahlenHypthek(Spieler spieler, Grundstueck grundstueck);

	/**
	 * Bewegt den Spieler eine entsprechende Anzahl an Feldern vor
	 * 
	 * @param spieler : Spieler, der bewegt wird
	 * @param wuerfelErgebnis : Anzahl an Feldern, die der Spieler bewegt wird
	 */
	public void bewegeSpieler(Spieler spieler, int wuerfelErgebnis);

	/** 
	 * Gibt eine Ereignis- oder Gemeinschaftsfeld-Karte zur�ck
	 * 
	 * @param spielfeld : Instanz des aktuellen Spielfeldes
	 */
	public Karte getKarte(Spielfeld spielfeld);

	/**
	 * Kauft ein Grundst�ck und ordnet es dem Besitz des entsprechenden Spielers zu
	 *
	 * @param spieler : Spieler, der das Grundst�ck kauft
	 * @return Gibt zur�ck, ob der Kauf des Grundst�cks erfolgreich war
	 */	
	public boolean kaufeGrundstueck(Spieler spieler);

	/**
	 * Kauft ein Haus und ordnet es dem Besitz des entsprechenden Spielers zu
	 *
	 * @param spieler : Spieler, der das Haus kauft
	 * @param grundstueck : Grundst�ck auf dem H�user gekauft werden
	 * @param anzahl : Anzahl der H�user, die auf dem Grundst�ck gekauft wurden
	 * @return Gibt zur�ck, ob der kauf des Hauses erfolgreich war
	 */
	public boolean kaufeHaus(Spieler spieler, Grundstueck grundstueck, int anzahl);

	/**
	 * Kauft ein Hotel und ordnet es dem Besitz des entsprechenden Spielers zu
	 * 
	 * @param spieler : Spieler, der das Hotel kauft
	 * @param grundstueck : Grundst�ck auf dem ein Hotel gekauft wird
	 * @return Gibt zur�ck, ob der Kauf des Hotels erfolgreich war 
	 */
	public boolean kaufeHotel(Spieler spieler, Grundstueck grundstueck);

	/**
	 * Verkauft Geb�ude auf einem Grundst�ck, �ndert den Besitz und das Verm�gen
	 * des entsprechenden Spielers
	 * 
	 * @param grundstueck : Das Grundst�ck auf dem die Geb�ude verkauft werden
	 * @param gebaudeanzahl : Anzahl der Geb�ude, die verkauft werden sollen
	 */
	public void verkaufeGebauede(Grundstueck grundstueck, int gebaudeanzahl);

	/**
	 * Verkauft ein ganzes Grundst�ck an einen neuen Besitzer
	 * 
	 * @param spieler : Spieler, der das Grundst�ck gekauft hat
	 * @param grundstueck : Grundst�ck, welches verkauft worden ist
	 * @return Gibt zur�ck, ob der Verkauf erfolgreich war
	 */
	public boolean verkaufeGrundstueck(Spieler spieler, Grundstueck grundstueck);

	/**
	 * Die beiden W�rfel werden geworfen
	 * 
	 * @return Gibt das W�rfelergebnis zur�ck
	 */
	public int wuerfelWerfen();
}
