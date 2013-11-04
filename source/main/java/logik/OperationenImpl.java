package logik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import logik.karte.Ereigniskarte;
import logik.karte.Gemeinschaftskarte;
import logik.karte.Karte;
import logik.spieler.Spieler;
import logik.spielfeld.Ereignisfeld;
import logik.spielfeld.Gemeinschaftsfeld;
import logik.spielfeld.Grundstueck;
import logik.spielfeld.Spielfeld;
import logik.spielfeld.Strasse;

public class OperationenImpl implements Operationen {

	private static Operationen instance = null;
	private Random wuerfel = new Random();
	private List<Ereigniskarte> unbenutzteEreigniskarten = new ArrayList<Ereigniskarte>();
	private List<Gemeinschaftskarte> unbenutzteGemeinschaftskarten = new ArrayList<Gemeinschaftskarte>();

	/**
	 * Instance des Singleton-Objekts
	 * 
	 * @return das Singelton der Klasse
	 */
	public static Operationen getInstance() {
		if (instance == null) {
			instance = new OperationenImpl();
		}
		return instance;
	}

	/**
	 * Standard-Konstruktor
	 */
	private OperationenImpl() {
		// Leer
	}

	@Override
	public void aufnehmenHypothek(Spieler spieler, Grundstueck grundstueck) {
		// TODO Auto-generated method stub

	}

	@Override
	public int auszahlenHypthek(Spieler spieler, Grundstueck grundstueck) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void bewegeSpieler(final Spieler spieler, final int wuerfelErgebnis) {
		final int aktuelleSpielfeldPosition = spieler.getSpielfeld()
				.getSpielfeldposition();
		final int neueSpielfeldPosition = aktuelleSpielfeldPosition
				+ wuerfelErgebnis;
		Spielfeld neuesSpielfeld = Spielfeld.alleSpielfelder[neueSpielfeldPosition];
		spieler.setSpielfeld(neuesSpielfeld);
	}

	@Override
	public Karte getKarte(final Spielfeld spielfeld) {
		Karte result = null;

		if (Ereignisfeld.class.isInstance(spielfeld)) {
			if (unbenutzteEreigniskarten.size() == 0) {
				unbenutzteEreigniskarten = Ereigniskarte.getAlleKarten();
			}
			result = unbenutzteEreigniskarten.remove(0);
		}

		if (Gemeinschaftsfeld.class.isInstance(spielfeld)) {
			if (unbenutzteGemeinschaftskarten.size() == 0) {
				unbenutzteGemeinschaftskarten = Gemeinschaftskarte
						.getAlleKarten();
			}
			result = unbenutzteGemeinschaftskarten.remove(0);
		}

		return result;
	}

	@Override
	public boolean kaufeGrundstueck(final Spieler spieler) {
		boolean result = false;
		final Spielfeld spielfeld = spieler.getSpielfeld();
		if (Grundstueck.class.isInstance(spielfeld)) {
			final Grundstueck grundstueck = (Grundstueck) spielfeld;
			final int grundstueckPreis = grundstueck.getPreis();
			if (spieler.getGeld() >= grundstueckPreis) {
				spieler.changeGeld(-grundstueckPreis);
				spieler.addBesitz(grundstueck);
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean kaufeHaus(Spieler spieler, Grundstueck grundstueck,
			int anzahl) {
		boolean result = true;

		if (alleBeiEinemBesitzer(spieler, grundstueck.getGruppe())
				&& Strasse.class.isInstance(grundstueck)) {
			Strasse strasse = (Strasse) grundstueck;
			if (spieler.getGeld() >= strasse.getHauspreis() * anzahl
					&& strasse.getHauser() + anzahl < 5) {
				strasse.addHaus(anzahl);
				spieler.changeGeld(-(strasse.getHauspreis() * anzahl));
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean kaufeHotel(Spieler spieler, Grundstueck grundstueck) {
		if (Strasse.class.isInstance(grundstueck)) {
			Strasse strasse = (Strasse) grundstueck;
			if (alleBeiEinemBesitzer(spieler, grundstueck.getGruppe())
					&& spieler.getGeld() >= strasse.getHotelpreis()
					&& strasse.getHauser() == 4) {
				spieler.changeGeld(-strasse.getHotelpreis());
				strasse.setHotel(1);
				return true;
			}
		}
		return false;
	}

	@Override
	public void verkaufeGebauede(Grundstueck grundstueck, int gebaudeanzahl) {
		if (Strasse.class.isInstance(grundstueck)) {
			Strasse strasse = (Strasse) grundstueck;
			if (gebaudeanzahl > 0 && strasse.getHotel() == 1) {
				strasse.setHotel(0);
				strasse.addHaus(4);
				strasse.getBesitzer().changeGeld(strasse.getHotelpreis());
				gebaudeanzahl--;
			}
			if (gebaudeanzahl > 0) {
				if (gebaudeanzahl > strasse.getHauser()) {
					gebaudeanzahl = strasse.getHauser();
				}
				strasse.addHaus(-gebaudeanzahl);
				strasse.getBesitzer().changeGeld(
						strasse.getHauspreis() * gebaudeanzahl);
			}
		}
	}

	@Override
	public boolean verkaufeGrundstueck(final Spieler spieler,
			final Grundstueck grundstueck) {
		boolean result = false;
		int grundstueckPreis = grundstueck.getPreis();
		if (spieler == null || spieler.getGeld() >= grundstueckPreis) {
			final Spieler aktuellerBesitzer = grundstueck.getBesitzer();
			aktuellerBesitzer.removeBesitz(grundstueck);
			aktuellerBesitzer.changeGeld(grundstueckPreis);

			if(spieler != null){
			spieler.addBesitz(grundstueck);
			spieler.changeGeld(-grundstueckPreis);
			}
			result = true;
		}
		return result;
	}

	@Override
	public int wuerfelWerfen() {
		return (wuerfel.nextInt(6)) + 1;
	}

	/**
	 * Prüft, ob die übergebene Gruppe dem selben Besitzer gehört
	 * 
	 * @param spieler
	 *            der Besitzer der aktuellen Karte
	 * @param gruppe
	 *            die zu der Karte zugehörige Gruppe
	 * @return true, wenn alle Karten der Gruppe dem übergebenem Besitzer
	 *         gehören
	 */
	private boolean alleBeiEinemBesitzer(Spieler spieler, int[] gruppe) {
		boolean result = true;

		for (int position : gruppe) {
			Spielfeld spielfeld = Spielfeld.alleSpielfelder[position];
			if (Grundstueck.class.isInstance(spielfeld)) {
				Spieler besitzer = ((Grundstueck) spielfeld).getBesitzer();
				if (besitzer != spieler) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}
