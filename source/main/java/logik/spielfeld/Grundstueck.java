package logik.spielfeld;

import logik.spieler.Spieler;

/**
 * Darstellung eines Grundst�cks auf dem Spielplan
 * 
 * @author Sven
 */
public abstract class Grundstueck extends Spielfeld{
	
	private final int preis;
	private Spieler besitzer;
	private final int grundmiete;
	private final int[] gruppe;
	private final int hypothekswert;
	private boolean hypothekisiert = false;
	
	/**
	 * Erstellt ein neues Grundst�ck
	 * @param name name des Spielfelds
	 * @param spielfeldposition Position auf dem Spielplan
	 * @param preis Preis f�r den Kauf des Grundst�cks
	 * @param grundmiete Grundmiete f�r das Grundst�ck
	 * @param hypothekswert Wert f�r die Hypothek
	 * @param gruppe Spielfeldposition der anderen Grundst�cke der Gruppe 
	 */
	public Grundstueck(String name, int spielfeldposition, int preis, int grundmiete, int hypothekswert, int[] gruppe){
		super(name, spielfeldposition);
		this.preis = preis;
		this.grundmiete = grundmiete;
		this.hypothekswert = hypothekswert;				
		this.gruppe = gruppe;
	}	
	
	/**
	 * �ndert den aktuellen Besitzer des Grundst�cks
	 * @param spieler der neue Besitzer
	 */
	public void changeBesitzer(Spieler spieler){
		besitzer = spieler;
	}

	public Spieler getBesitzer(){
		return besitzer;
	}

	public int getHypothekswert(){
		return hypothekswert;
	};

	public int getPreis(){
		return preis;
	};

	public boolean isHypothekisiert(){
		return hypothekisiert;
	};
	
	public void setHypothekisiert(boolean hypothekisiert){
		this.hypothekisiert = hypothekisiert;
	}
	
	public boolean getHypothekisiert(){
		return hypothekisiert;
	}
	
	public int getGrundmiete(){
		return grundmiete;
	}

	public int[] getGruppe() {
		return gruppe;
	}	
}
