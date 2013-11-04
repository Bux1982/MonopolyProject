package logik.karte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gemeinschaftskarte extends Karte{

	private static List<Gemeinschaftskarte> gemeinschaftsKarten = new ArrayList<Gemeinschaftskarte>();
	
	/**
	 * Erstellt eine neue GemeinschaftsKarte und fügt sie dem GemeinschaftsKartenStapel hinzu
	 * @param text der Text der Karte
	 * @param geld  der Geldbetrag der Karte
	 */
	public Gemeinschaftskarte(String text, int geld) {
		super(text, geld);
		gemeinschaftsKarten.add(this);
	}
	
	public static List<Gemeinschaftskarte> getAlleKarten() {
		List<Gemeinschaftskarte> result = new ArrayList<Gemeinschaftskarte>();
		Collections.shuffle(result);
		result.addAll(gemeinschaftsKarten);
		return result;
	}
}
