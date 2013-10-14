package logik.spielfeld;

import logik.spieler.Spieler;

public abstract class Grundstueck extends Spielfeld{
	
	private final int preis;
	private Spieler besitzer;
	private final int grundmiete;
	private final int[] gruppe;
	private final int hypothekswert;
	private boolean hypothekisiert;
	
	public Grundstueck(String name, int spielfeldposition, int preis, int grundmiete, int hypothekswert, int[] gruppe){
		super(name, spielfeldposition);
		
		this.preis = preis;
		this.grundmiete = grundmiete;
		this.hypothekswert = hypothekswert;				
		hypothekisiert = false;
		this.gruppe = gruppe;
		
		besitzer = null;
	}	
	
	public void changeBesitzer(Spieler spieler){
		besitzer = spieler;
	};

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
