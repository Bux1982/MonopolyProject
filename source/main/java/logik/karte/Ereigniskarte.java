package logik.karte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ereigniskarte extends Karte{

	private static List<Ereigniskarte> ereignisKarten = new ArrayList<Ereigniskarte>();
	
	/**
	 * Erstellt eine neue Ereigniskarte und fügt Sie dem Ereigniskartenstapel hinzu
	 * @param text der Text der Karte
	 * @param geld der Geldbetrag der Karte
	 */
	public Ereigniskarte(String text, int geld) {
		super(text, geld);
		ereignisKarten.add(this);
	}

	public static List<Ereigniskarte> getAlleKarten() {
		List<Ereigniskarte> result = new ArrayList<Ereigniskarte>();
		Collections.shuffle(result);
		result.addAll(ereignisKarten);
		return result;
	}
}
