package logik;

import logik.karte.Karte;
import logik.spieler.Spieler;
import logik.spielfeld.Grundstueck;
import logik.spielfeld.Spielfeld;

public interface Operationen {
	
	/**
	 * Nimmt eine Hypothek zu einem Grundstück auf und verringert das Vermögen
	 * des Spielers
	 * 
	 * @param spieler : Spieler, der die Hypothek aufnimmt
	 * @param grundstueck : Grundstück auf das eine Hypothek aufgenommen wird 
	 */
	public void aufnehmenHypothek(Spieler spieler, Grundstueck grundstueck);

	/**
	 * Zahlt eine Hypothek zu einem Grundstück aus und schreibt diese dem Guthaben
	 * des Spielers gut
	 *
	 * @param spieler : Spieler, der die Hypothek bekommt
	 * @param grundstueck : Grundstück von dem die Hypothek ausgezahlt wird
	 * @param Gibt den Hypothekswert zurück 
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
	 * Gibt eine Ereignis- oder Gemeinschaftsfeld-Karte zurück
	 * 
	 * @param spielfeld : Instanz des aktuellen Spielfeldes
	 */
	public Karte getKarte(Spielfeld spielfeld);

	/**
	 * Kauft ein Grundstück und ordnet es dem Besitz des entsprechenden Spielers zu
	 *
	 * @param spieler : Spieler, der das Grundstück kauft
	 * @return Gibt zurück, ob der Kauf des Grundstücks erfolgreich war
	 */	
	public boolean kaufeGrundstueck(Spieler spieler);

	/**
	 * Kauft ein Haus und ordnet es dem Besitz des entsprechenden Spielers zu
	 *
	 * @param spieler : Spieler, der das Haus kauft
	 * @param grundstueck : Grundstück auf dem Häuser gekauft werden
	 * @param anzahl : Anzahl der Häuser, die auf dem Grundstück gekauft wurden
	 * @return Gibt zurück, ob der kauf des Hauses erfolgreich war
	 */
	public boolean kaufeHaus(Spieler spieler, Grundstueck grundstueck, int anzahl);

	/**
	 * Kauft ein Hotel und ordnet es dem Besitz des entsprechenden Spielers zu
	 * 
	 * @param spieler : Spieler, der das Hotel kauft
	 * @param grundstueck : Grundstück auf dem ein Hotel gekauft wird
	 * @return Gibt zurück, ob der Kauf des Hotels erfolgreich war 
	 */
	public boolean kaufeHotel(Spieler spieler, Grundstueck grundstueck);

	/**
	 * Verkauft Gebäude auf einem Grundstück, ändert den Besitz und das Vermögen
	 * des entsprechenden Spielers
	 * 
	 * @param grundstueck : Das Grundstück auf dem die Gebäude verkauft werden
	 * @param gebaudeanzahl : Anzahl der Gebäude, die verkauft werden sollen
	 */
	public void verkaufeGebauede(Grundstueck grundstueck, int gebaudeanzahl);

	/**
	 * Verkauft ein ganzes Grundstück an einen neuen Besitzer
	 * 
	 * @param spieler : Spieler, der das Grundstück gekauft hat
	 * @param grundstueck : Grundstück, welches verkauft worden ist
	 * @return Gibt zurück, ob der Verkauf erfolgreich war
	 */
	public boolean verkaufeGrundstueck(Spieler spieler, Grundstueck grundstueck);

	/**
	 * Die beiden Würfel werden geworfen
	 * 
	 * @return Gibt das Würfelergebnis zurück
	 */
	public int wuerfelWerfen();
}
