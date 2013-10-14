package logik;

import logik.karte.Karte;
import logik.spieler.Spieler;
import logik.spielfeld.Grundstueck;
import logik.spielfeld.Spielfeld;

public class OperationenImpl implements Operationen{

	private static Operationen instance = null;
	
	/**
	 * Instance des Singleton-Objekts
	 * @return  das Singelton der Klasse
	 */
	public static Operationen getInstance(){
		if(instance == null){
			instance = new OperationenImpl();
		}
		return instance;
	}
	
	/**
	 * Standard-Konstruktor
	 */
	private OperationenImpl(){
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
	public void bewegeSpieler(Spieler spieler, int wuerfelErgebnis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Karte getKarte(Spielfeld spielfeld) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean kaufeGrundstueck(Spieler spieler) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean kaufeHaus(Spieler spieler, Grundstueck grundstueck,
			int anzahl) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean kaufeHotel(Spieler spieler, Grundstueck grundstueck) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verkaufeGebauede(Spieler spieler, Grundstueck grundstueck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verkaufeGrundstueck(Spieler spieler, Grundstueck grundstueck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int wuerfelWerfen() {
		// TODO Auto-generated method stub
		return 0;
	}

}
