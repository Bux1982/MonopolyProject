package logik;

import logik.karte.Karte;
import logik.spieler.Spieler;
import logik.spielfeld.Grundstueck;
import logik.spielfeld.Spielfeld;

public interface Operationen {

	public void aufnehmenHypothek(Spieler spieler, Grundstueck grundstueck);

	public int auszahlenHypthek(Spieler spieler, Grundstueck grundstueck);

	public void bewegeSpieler(Spieler spieler, int wuerfelErgebnis);

	public Karte getKarte(Spielfeld spielfeld);

	public boolean kaufeGrundstueck(Spieler spieler);

	public boolean kaufeHaus(Spieler spieler, Grundstueck grundstueck, int anzahl);

	public boolean kaufeHotel(Spieler spieler, Grundstueck grundstueck);

	public void verkaufeGebauede(Grundstueck grundstueck, int gebaudeanzahl);

	public boolean verkaufeGrundstueck(Spieler spieler, Grundstueck grundstueck);

	public int wuerfelWerfen();
}
