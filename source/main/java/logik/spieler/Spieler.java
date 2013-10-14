package logik.spieler;

import java.util.ArrayList;
import java.util.List;
import logik.spielfeld.Grundstueck;
import logik.spielfeld.Spielfeld;

/**
 * Darstellung eines Spielers
 * @author Sven
 */
public class Spieler {
	
	private int geld = 0;
	private final Figur figur;
	private List <Grundstueck> besitz = new ArrayList<Grundstueck>();
	private Spielfeld spielfeld;
	
	/**
	 * Erstellt einen neuen Spieler
	 * @param figur Figur des Spielers
	 */
	private Spieler(Figur figur, int geld){
		this.figur = figur;
		this.geld = geld;
	}
	
	/**
	 * Ändert den Geldstand des Spielers
	 * @param geld das Geld welches zum aktuellen Stand addiert wird
	 */
	public void changeGeld(int geld) {
		this.geld +=  geld; 
	}

	/**
	 * @return {@link Figur} des Spielers
	 */
	public Figur getFigur() {
		return figur;
	}

	/**
	 * @return aktueller Geldstand des Spielers
	 */
	public int getGeld() {
		return geld;
	}
	
	/**
	 * @return das aktuelle Spielfeld auf dem der Spieler steht
	 */
	public Spielfeld getSpielfeld(){
		return spielfeld;
	}
	
	public void setSpielfeld(Spielfeld spielfeld){
		this.spielfeld = spielfeld;
	}
	
	public List<Grundstueck> getBesitz(){
		return besitz;
	}
	
	public void addBesitz (Grundstueck grundstueck){
		besitz.add(grundstueck);
		grundstueck.changeBesitzer(this);
	}
	
	public void removeBesitz(Grundstueck grundstueck){
		besitz.remove(grundstueck);
		grundstueck.changeBesitzer(null);
	}
}


