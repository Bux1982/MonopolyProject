package logik;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import logik.karte.Ereigniskarte;
import logik.karte.Gemeinschaftskarte;
import logik.karte.Karte;
import logik.spieler.Figur;
import logik.spieler.Spieler;
import logik.spielfeld.Ereignisfeld;
import logik.spielfeld.Gefaengnis;
import logik.spielfeld.Gemeinschaftsfeld;
import logik.spielfeld.Los;
import logik.spielfeld.Spielfeld;
import logik.spielfeld.Strasse;

import org.junit.Test;

public class OperationTest {

	Operationen operationen = OperationenImpl.getInstance();
	
	@Test
	public void wuerfelWerfenTest() {
		for (int i = 0; i < 100; i++) {
			int wuerfelWerfen = operationen.wuerfelWerfen();
			assertTrue(wuerfelWerfen >= 1 && wuerfelWerfen <= 6);
		}
	}
	
	@Test
	public void auszahlenHypothekTest(){
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);	
		int geld = spieler.getGeld();
		spieler.addBesitz(strasse);			

		operationen.aufnehmenHypothek(spieler, strasse);
		assertTrue(strasse.isHypothekisiert());
		assertEquals(geld+300, spieler.getGeld());
		
		operationen.auszahlenHypothek(spieler, strasse);
		assertFalse(strasse.isHypothekisiert());
		assertEquals(geld, spieler.getGeld());
		
	}
	
	@Test
	public void getKarteTestNull(){
		Gefaengnis gefaengnis = new Gefaengnis(1, 3000);
		Karte karte = operationen.getKarte(gefaengnis);
		assertEquals(null, karte);		
	}
	
	@Test
	public void getKarteTest(){
		Ereignisfeld ereignisFeld = new Ereignisfeld("Ereignisfeld", 1);
		Gemeinschaftsfeld gemeinschaftsfeld = new Gemeinschaftsfeld("Gemeinschaftsfeld", 2);
		Gemeinschaftsfeld gemeinschaftsfeld2 = new Gemeinschaftsfeld("Gemeinschaftsfeld", 2);
		
		Ereigniskarte ereigniskarte = new Ereigniskarte("Karte1", 20);
		Gemeinschaftskarte gemeinschaftskarte = new Gemeinschaftskarte("Karte1", 20);
				
		assertEquals(ereigniskarte, operationen.getKarte(ereignisFeld));
		assertEquals(gemeinschaftskarte, operationen.getKarte(gemeinschaftsfeld));
		assertEquals(gemeinschaftskarte, operationen.getKarte(gemeinschaftsfeld2));
	}

	@Test
	public void kaufeGrundstueckTest(){
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);
		spieler.setSpielfeld(strasse);
		
		boolean success = operationen.kaufeGrundstueck(spieler);
		assertTrue(success);
		assertTrue(spieler.getBesitz().contains(strasse));
		assertTrue(spieler.getGeld()+400 == 5000);
	}
	
	@Test
	public void kaufeHausTest(){
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);
		strasse.changeBesitzer(spieler);
		
		boolean success = operationen.kaufeHaus(spieler, strasse, 1);
		assertTrue(success == true);
	}
	
	@Test
	public void kaufeHotelTest(){		
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);
		spieler.addBesitz(strasse);
		strasse.addHaus(4);
		
		boolean success = operationen.kaufeHotel(spieler, strasse);
		assertTrue(success == true);				
	}
	
	@Test
	public void aufnehmenHypothekTest() {
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);	
		int geld = spieler.getGeld();
		
		operationen.aufnehmenHypothek(spieler, strasse);
		assertFalse(strasse.isHypothekisiert());
		assertEquals(geld, spieler.getGeld());
		
		spieler.addBesitz(strasse);			
		operationen.aufnehmenHypothek(spieler, strasse);
		assertTrue(strasse.isHypothekisiert());
		assertEquals(geld+300, spieler.getGeld());
	}
	
	@Test
	public void bewegeSpielerTest() {
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Spielfeld los = new Los(100);
		Ereignisfeld ereignisFeld1 = new Ereignisfeld("Ereignisfeld", 1);
		Ereignisfeld ereignisFeld2 = new Ereignisfeld("Ereignisfeld2", 2);
		Gemeinschaftsfeld gemeinschaftsfeld1 = new Gemeinschaftsfeld("Gemeinschaftsfeld", 3);
		Gemeinschaftsfeld gemeinschaftsfeld2 = new Gemeinschaftsfeld("Gemeinschaftsfeld", 4);
		
		operationen.bewegeSpieler(spieler, 1);
		assertEquals(ereignisFeld1, spieler.getSpielfeld());
		
		operationen.bewegeSpieler(spieler, -1);
		assertEquals(los, spieler.getSpielfeld());
		
		operationen.bewegeSpieler(spieler, 4);
		assertEquals(gemeinschaftsfeld2, spieler.getSpielfeld());
		
		operationen.bewegeSpieler(spieler, -4);
		assertEquals(los, spieler.getSpielfeld());
		
		operationen.bewegeSpieler(spieler, 2);
		assertEquals(ereignisFeld2, spieler.getSpielfeld());
							
		operationen.bewegeSpieler(spieler, 1);
		assertEquals(gemeinschaftsfeld1, spieler.getSpielfeld());
	}
	
	@Test
	public void verkaufeGebauedeTest() {
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);
		strasse.setHotel(1);
		spieler.addBesitz(strasse);
		
		int geld = spieler.getGeld();
		strasse.addHaus(4);
		operationen.verkaufeGebauede( strasse, 1);
		geld = geld+500;
		assertEquals(geld, spieler.getGeld());
		
		geld = spieler.getGeld();
		strasse.addHaus(1);
		operationen.verkaufeGebauede( strasse, 2);
		geld = geld+2*500;
		assertEquals(geld, spieler.getGeld());
		
		geld = spieler.getGeld();
		strasse.addHaus(2);
		operationen.verkaufeGebauede( strasse, 3);
		geld = geld+3*500;
		assertEquals(geld, spieler.getGeld());
		
		geld = spieler.getGeld();
		strasse.addHaus(3);
		operationen.verkaufeGebauede( strasse, 4);
		geld = geld+4*500;
		assertEquals(geld, spieler.getGeld());
		
		geld = spieler.getGeld();
		strasse.addHaus(4);
		operationen.verkaufeGebauede( strasse, 5);
		geld = geld+4*500;
		assertEquals(geld, spieler.getGeld());
		
		geld = spieler.getGeld();
		strasse.addHaus(4);
		operationen.verkaufeGebauede( strasse, 13);
		geld = geld+4*500;
		assertEquals(geld, spieler.getGeld());
	}	

	@Test
	public void verkaufeGrundstueckAnBankTest() {
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);
		spieler.addBesitz(strasse);
		int geld = spieler.getGeld();
		
		operationen.verkaufeGrundstueck(null, strasse);
		
		assertTrue(spieler.getGeld() > geld);		
	}
	
	@Test
	public void verkaufeGrundstueckAnSpielerTest() {
		int[] gruppe = {1};
		int[] mieteprohaus = {25, 50, 75, 100};
		Figur figur = new Figur("Test");
		Spieler spieler = new Spieler(figur, 5000);
		Spieler spieler2 = new Spieler(figur, 5000);
		Strasse strasse = new Strasse("Test", 1, 400, 50, 300, gruppe, 
				"Rot", 500, 500, mieteprohaus, 200);
		spieler.addBesitz(strasse);
		int geld = spieler.getGeld();
		int geld2 = spieler2.getGeld();
		
		operationen.verkaufeGrundstueck(spieler2, strasse);
		
		assertTrue(spieler.getGeld() > geld);
		assertTrue(spieler2.getGeld() < geld2);	
	}
}
