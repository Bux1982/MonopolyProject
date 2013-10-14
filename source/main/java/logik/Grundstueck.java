package logik;

public interface Grundstueck {
	public void changeBesitzer(Spieler spieler);

	public Spieler getBesitzer();

	public int getHypothekswert();

	public int getPreis();

	public boolean isHypothekisiert();
}
