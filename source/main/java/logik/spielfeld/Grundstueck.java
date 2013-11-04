package logik.spielfeld;

import logik.spieler.Spieler;

/**
 * Darstellung eines Grundstücks auf dem Spielplan
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
	 * Erstellt ein neues Grundstück
	 * @param name name des Spielfelds
	 * @param spielfeldposition Position auf dem Spielplan
	 * @param preis Preis für den Kauf des Grundstücks
	 * @param grundmiete Grundmiete für das Grundstück
	 * @param hypothekswert Wert für die Hypothek
	 * @param gruppe Spielfeldposition der anderen Grundstücke der Gruppe 
	 */
	public Grundstueck(String name, int spielfeldposition, int preis, int grundmiete, int hypothekswert, int[] gruppe){
		super(name, spielfeldposition);
		this.preis = preis;
		this.grundmiete = grundmiete;
		this.hypothekswert = hypothekswert;				
		this.gruppe = gruppe;
	}	
	
	/**
	 * Ändert den aktuellen Besitzer des Grundstücks
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
