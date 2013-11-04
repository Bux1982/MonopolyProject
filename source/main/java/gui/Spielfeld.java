package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Spielfeld extends Frame implements MouseListener
{
	//String bilderPfad = "J:/Monopoli/Monopolybilder/";
	String bilderPfad = "C:/Eigene Dateien/Java/Schule/MonopolyWorkspace/Monopolybilder/";
	
	Image los = Toolkit.getDefaultToolkit().getImage(bilderPfad + "Los.gif");
	Image freiParken = Toolkit.getDefaultToolkit().getImage(bilderPfad + "FreiParken.gif");
	Image fragezeichen = Toolkit.getDefaultToolkit().getImage(bilderPfad + "Fragezeichen.gif");
	Image gemeinschaftsfeld = Toolkit.getDefaultToolkit().getImage(bilderPfad + "Gemeinschaftsfeld.gif");
	Image lock = Toolkit.getDefaultToolkit().getImage(bilderPfad + "Lock_HatNickSchoenGemacht.gif");
	Image monopolyLogo = Toolkit.getDefaultToolkit().getImage(bilderPfad + "MonopolyLogo.svg.gif");
	Image polizist = Toolkit.getDefaultToolkit().getImage(bilderPfad + "Polizist.gif");
	Image ring = Toolkit.getDefaultToolkit().getImage(bilderPfad + "Ring.gif");
	Image knast = Toolkit.getDefaultToolkit().getImage(bilderPfad + "knast.gif");
	Image birne = Toolkit.getDefaultToolkit().getImage(bilderPfad + "Birne.gif");
	Image wasserhahn = Toolkit.getDefaultToolkit().getImage(bilderPfad + "wasserhahn.gif");
	ImageObserver observer;
	
	
	
	
	
	private int spriteMasse = 8;   //Hoehe und Breite der Sprites in PX
	private int anz_spieler = 6;	//Index 6 ist reserviert für Blinken
	private int anz_frames = 6;
	private int figur_streckfaktor = 8;
	//String imgPath = "K:/Monopoly - Sven/FigurenGrid.PNG";
	String imgPath = "C:/Sonstiges/FigurenGrid.gif";
	private ImageIcon[][] figurFrames = new ImageIcon[anz_spieler][anz_frames];
	
	
	
	
	
	/*los				Fertig
	freiParken			Fertig
	fragezeichen		Muss noch
	gemeinschaftsfeld	Muss noch
	lock				Muss noch
	monopolyLogo		Fertig
	polizist			Fertig
	ring				Muss noch
	knast				Fertig
	birne				Muss noch
	wasserhahn			Muss noch*/
	
	public Spielfeld()
	{
		super("Monopoly");
		setSize(1280, 1000);
		addMouseListener(this);
		setImage();
		
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		//Bildschirm löschen
		g.setColor(Color.white);
		g.fillRect(0, 0, 1280, 1000);
		g.setColor(Color.black);
		
		//Oberer linker Punkt des Spielfeldes
		int startX = 10;
		int startY = 50;
		
		//Berechnen der Feld-Breite (oben und unten)
		int feldBreite = 66;
		
		//Berechnen der Feld-HÃ¶he (links und rechts)
		int feldHoehe = 66;
		
		//Grösse der Eckfelder (Los, Freiparken,...)
		int eckfeldLaenge = 100;
		
		//MaÃŸe des Spielfeldes
		int spielfeldGroesse = (eckfeldLaenge*2+9*feldHoehe);
		int spielfeldBreite = (eckfeldLaenge*2+9*feldBreite);
		
		double strassenNamenAnteil = 0.3;
		
		int besitzKennzeichnung = 14;	//Anzahl der Pixel
		
		
		
		
		
		
		
		
		
		
		//Auslesen der Häuserzahlen
		int anzahlHaeuser_badstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_turmstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_chausseestr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_elisenstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_poststr = (int) Math.round(Math.random()*5);
		
		int anzahlHaeuser_seestr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_hafenstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_neuestr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_munchenerstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_wienerstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_berlinerstr = (int) Math.round(Math.random()*5);
		
		int anzahlHaeuser_theaterstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_museumstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_opernplatz = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_lessingstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_schillerstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_goethestr = (int) Math.round(Math.random()*5);
		
		int anzahlHaeuser_rathhausplatz = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_hauptstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_bahnhofstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_parkstr = (int) Math.round(Math.random()*5);
		int anzahlHaeuser_schlossallee = (int) Math.round(Math.random()*5);
		
		
		
		
		
		
		
		
		
		
		//Zeichnen des Spielfeldes (äusserer Rahmen)
		g.drawRect(startX, startY, spielfeldBreite, spielfeldGroesse);
		
		
		
		
		
		
		
		
		
		
		//Zeichnen der Eckfelder
		g.drawRect(startX, startY, eckfeldLaenge, eckfeldLaenge);						//Frei parken
		g.drawRect(startX+spielfeldBreite-eckfeldLaenge, startY, eckfeldLaenge, eckfeldLaenge);	//In das GefÃ¤ngnis
		g.drawRect(startX+spielfeldBreite-eckfeldLaenge, startY+spielfeldGroesse-eckfeldLaenge, eckfeldLaenge, eckfeldLaenge);				//Los
		g.drawRect(startX, startY+spielfeldGroesse-eckfeldLaenge, eckfeldLaenge, eckfeldLaenge);						//GefÃ¤ngnis
		
		//Zeichnen des inneren Vierecks
		g.drawRect(startX+eckfeldLaenge, startY+eckfeldLaenge, (spielfeldBreite-2*eckfeldLaenge), (spielfeldGroesse-2*eckfeldLaenge));
		
		
		
		
		
		
		
		
		
		
		//Zeichnen der Strassen (oben)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX+eckfeldLaenge+(i+1)*feldBreite, startY, startX+eckfeldLaenge+(i+1)*feldBreite, startY+eckfeldLaenge);
		}
		
		
		
		//Zeichnen der Strassen (unten)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX+eckfeldLaenge+(i+1)*feldBreite, startY+spielfeldGroesse-eckfeldLaenge, startX+eckfeldLaenge+(i+1)*feldBreite, startY+spielfeldGroesse);
		}
		
		
		
		//Zeichnen der Strassen (links)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX, startY+eckfeldLaenge+(i+1)*feldHoehe, startX+eckfeldLaenge, startY+eckfeldLaenge+(i+1)*feldHoehe);
		}
		
		
		
		//Zeichnen der Strassen (rechts)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX+spielfeldBreite-eckfeldLaenge, startY+eckfeldLaenge+(i+1)*feldHoehe, startX+spielfeldBreite, startY+eckfeldLaenge+(i+1)*feldHoehe);
		}
		
		
		
		
		
		
		
		
		
		
		//Grafiken darstellen
		g.drawImage(los, startX+eckfeldLaenge+9*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, eckfeldLaenge-1, eckfeldLaenge-1, null);
		g.drawImage(freiParken, startX+1, startY+1, eckfeldLaenge-1, eckfeldLaenge-1, null);
		g.drawImage(polizist, startX+eckfeldLaenge+9*feldBreite+1, startY+1, eckfeldLaenge-1, eckfeldLaenge-1, null);
		g.drawImage(knast, startX+1, startY+spielfeldGroesse-eckfeldLaenge+1, eckfeldLaenge-1, eckfeldLaenge-1, null);
		g.drawImage(monopolyLogo, startX+(spielfeldBreite/2)-125, startY+(spielfeldGroesse/2)-43, 250, 86, null);
		
		g.drawImage(fragezeichen, startX+eckfeldLaenge+2*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, eckfeldLaenge-1, null);		//Neben Chausseestrasse
		g.drawImage(fragezeichen, startX+eckfeldLaenge+feldBreite+1, startY+1, feldBreite-1, eckfeldLaenge-1, null);										//Neben Theaterstrasse
		g.drawImage(fragezeichen, startX+eckfeldLaenge+9*feldBreite+1, startY+1+eckfeldLaenge+5*feldHoehe, eckfeldLaenge-1, feldHoehe-1, null);				//Neben Parkstrasse
		
		g.drawImage(lock, startX+eckfeldLaenge+4*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, eckfeldLaenge-1, null);				//Südbahnhof
		g.drawImage(lock, startX+1, startY+1+eckfeldLaenge+4*feldHoehe, eckfeldLaenge-1, feldHoehe-1, null);												//Westbahnhof
		g.drawImage(lock, startX+eckfeldLaenge+4*feldBreite+1, startY+1, feldBreite-1, eckfeldLaenge-1, null);												//Nordbahnhof
		g.drawImage(lock, startX+eckfeldLaenge+9*feldBreite+1, startY+1+eckfeldLaenge+4*feldHoehe, eckfeldLaenge-1, feldHoehe-1, null);						//Hauptbahnhof
		
		g.drawImage(gemeinschaftsfeld, startX+eckfeldLaenge+7*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, eckfeldLaenge-1, null);	//Gemeinschaftsfeld (Bad- und Turmstrasse)
		g.drawImage(gemeinschaftsfeld, startX+1, startY+1+eckfeldLaenge+2*feldHoehe, eckfeldLaenge-1, feldHoehe-1, null);									//Gemeinschaftsfeld (Wiener- und Münchenerstrasse)
		g.drawImage(gemeinschaftsfeld, startX+eckfeldLaenge+9*feldBreite+1, startY+1+eckfeldLaenge+2*feldHoehe, eckfeldLaenge-1, feldHoehe-1, null);		//Gemeinschaftsfeld (Haupt- und Bahnhofsstrasse)
		
		g.drawImage(wasserhahn, startX+eckfeldLaenge+7*feldBreite+1, startY+1, feldBreite-1, eckfeldLaenge-1, null);										//Wasserwerk
		
		g.drawImage(birne, startX+1, startY+1+eckfeldLaenge+7*feldHoehe, eckfeldLaenge-1, feldHoehe-1, null);												//Elektizitätswerk
		
		g.drawImage(ring, startX+eckfeldLaenge+9*feldBreite+1, startY+1+eckfeldLaenge+7*feldHoehe, eckfeldLaenge-1, feldHoehe-1, null);						//Zusatzsteuer
		
		g.drawString("Einkom-", startX+eckfeldLaenge+5*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5);
		g.drawString("mens-", startX+eckfeldLaenge+5*feldBreite+10+5, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5+17);
		g.drawString("steuer", startX+eckfeldLaenge+5*feldBreite+10+5, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5+34);
		
		
		
		
		
		
		
		
		
		
		//Hintergrundfarben der Strassennamen
		g.setColor(new Color(128, 64, 0));	//Braun
		g.fillRect(startX+eckfeldLaenge+8*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Badstr
		g.fillRect(startX+eckfeldLaenge+6*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Turmstr
		//Häuser/Hotel für Badstr
		if(anzahlHaeuser_badstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_badstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_badstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_badstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_badstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Häuser/Hotel für Turmstr
		if(anzahlHaeuser_turmstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_turmstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_turmstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_turmstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_turmstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Besitz-Kennzeichnung
		g.setColor(Color.black);
		g.drawString("Badstr.", startX+eckfeldLaenge+8*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		g.drawString("Turmstr.", startX+eckfeldLaenge+6*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		int ersterX = startX+eckfeldLaenge+8*feldBreite;
		int ersterY = startY+spielfeldGroesse-eckfeldLaenge;
		int arx[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary[] = {ersterY, ersterY-besitzKennzeichnung, ersterY-besitzKennzeichnung, ersterY};
		g.setColor(Color.yellow);
		g.fillPolygon(arx,ary, 4);
		g.setColor(Color.black);
		g.drawPolygon(arx,ary, 4);
		g.drawString("Name", ersterX+15, ersterY-2);
		
		ersterX = startX+eckfeldLaenge+6*feldBreite;
		ersterY = startY+spielfeldGroesse-eckfeldLaenge;
		int arx1[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary1[] = {ersterY, ersterY-besitzKennzeichnung, ersterY-besitzKennzeichnung, ersterY};
		g.drawPolygon(arx1,ary1, 4);
		
		g.setColor(new Color(0, 255, 255));	//Hellblau
		g.fillRect(startX+eckfeldLaenge+3*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Chausseestr.
		g.fillRect(startX+eckfeldLaenge+1*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Elisenstr
		g.fillRect(startX+eckfeldLaenge+0*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Poststr
		//Häuser/Hotel für Chausseestr
		if(anzahlHaeuser_chausseestr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_chausseestr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_chausseestr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_chausseestr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_chausseestr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Häuser/Hotel für Elisenstr
		if(anzahlHaeuser_elisenstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+1*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+1*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_elisenstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+1*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+1*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_elisenstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+1*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+1*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_elisenstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+1*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+1*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_elisenstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+1*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+1*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Häuser/Hotel für Poststr
		if(anzahlHaeuser_poststr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_poststr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_poststr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5+14, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_poststr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5+28, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_poststr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5+42, startY+spielfeldGroesse-eckfeldLaenge+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		g.setColor(Color.black);
		g.drawString("Chaussee-", startX+eckfeldLaenge+3*feldBreite+3, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		g.drawString("strasse", startX+eckfeldLaenge+3*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15+17);
		g.drawString("Elisenstr.", startX+eckfeldLaenge+1*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		g.drawString("Poststr.", startX+eckfeldLaenge+0*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		
		ersterX = startX+eckfeldLaenge+3*feldBreite;
		ersterY = startY+spielfeldGroesse-eckfeldLaenge;
		int arx2[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary2[] = {ersterY, ersterY-besitzKennzeichnung, ersterY-besitzKennzeichnung, ersterY};
		g.drawPolygon(arx2,ary1, 4);
		
		ersterX = startX+eckfeldLaenge+1*feldBreite+1;
		ersterY = startY+spielfeldGroesse-eckfeldLaenge;
		int arx3[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary3[] = {ersterY, ersterY-besitzKennzeichnung, ersterY-besitzKennzeichnung, ersterY};
		g.drawPolygon(arx3,ary1, 4);
		
		ersterX = startX+eckfeldLaenge+0*feldBreite+1;
		ersterY = startY+spielfeldGroesse-eckfeldLaenge;
		int arx4[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary4[] = {ersterY, ersterY-besitzKennzeichnung, ersterY-besitzKennzeichnung, ersterY};
		g.drawPolygon(arx4,ary1, 4);
		
		
		
		
		
		g.setColor(new Color(255, 0, 255));	//Rosa
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+5*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Neue Str
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+6*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Hafen Str
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+8*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//See Str
		//Häuser/Hotel für Seestr
		if(anzahlHaeuser_seestr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_seestr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_seestr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_seestr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_seestr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+8*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		//Häuser/Hotel für Hafenstr
		if(anzahlHaeuser_hafenstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_hafenstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_hafenstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_hafenstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_hafenstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+6*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		//Häuser/Hotel für Neue Str
		if(anzahlHaeuser_neuestr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_neuestr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_neuestr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_neuestr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_neuestr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+5*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		g.setColor(Color.black);
		g.drawString("Seestr.", (int) (startX+5), startY+eckfeldLaenge+8*feldHoehe+13);
		g.drawString("Hafenstr.", (int) (startX+5), startY+eckfeldLaenge+6*feldHoehe+13);
		g.drawString("Neue Str.", (int) (startX+5), startY+eckfeldLaenge+5*feldHoehe+13);
		
		ersterX = startX+eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+8*feldHoehe;
		int arx5[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+besitzKennzeichnung, ersterX};
		int ary5[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx5,ary5, 4);
		
		ersterX = startX+eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+6*feldHoehe;
		int arx6[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+besitzKennzeichnung, ersterX};
		int ary6[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx6,ary6, 4);
		
		ersterX = startX+eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+5*feldHoehe;
		int arx7[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+besitzKennzeichnung, ersterX};
		int ary7[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx7,ary7, 4);
		
		
		
		
		
		g.setColor(new Color(255, 128, 0));	//Orange
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+0*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Berlinerstr
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+1*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Wienerstr
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+3*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Münchenerstr
		//Häuser/Hotel für Münchenerstrasse
		if(anzahlHaeuser_munchenerstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_munchenerstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_munchenerstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_munchenerstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_munchenerstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+3*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		//Häuser/Hotel für Wienerstrasse
		if(anzahlHaeuser_wienerstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_wienerstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_wienerstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_wienerstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_wienerstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+1*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		//Häuser/Hotel für Berlinerstrasse
		if(anzahlHaeuser_berlinerstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_berlinerstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_berlinerstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_berlinerstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_berlinerstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6-(int) (eckfeldLaenge*strassenNamenAnteil-1), startY+eckfeldLaenge+0*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		g.setColor(Color.black);
		g.drawString("Münchener", (int) (startX+5), startY+eckfeldLaenge+3*feldHoehe+13);
		g.drawString("Strasse", (int) (startX+5)+7, startY+eckfeldLaenge+3*feldHoehe+13+17);
		g.drawString("Wiener Str.", (int) (startX+5), startY+eckfeldLaenge+1*feldHoehe+13);
		g.drawString("Berliner Str.", (int) (startX+5), startY+eckfeldLaenge+0*feldHoehe+13);
		
		ersterX = startX+eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+3*feldHoehe;
		int arx8[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+besitzKennzeichnung, ersterX};
		int ary8[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx8,ary8, 4);
		
		ersterX = startX+eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+1*feldHoehe;
		int arx9[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+besitzKennzeichnung, ersterX};
		int ary9[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx9,ary9, 4);
		
		ersterX = startX+eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+0*feldHoehe;
		int arx10[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+besitzKennzeichnung, ersterX};
		int ary10[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx10,ary10, 4);
		
		
		
		
		
		g.setColor(new Color(255, 0, 0));	//Rot
		g.fillRect(startX+eckfeldLaenge+0*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Theaterstr
		g.fillRect(startX+eckfeldLaenge+2*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Museumstr
		g.fillRect(startX+eckfeldLaenge+3*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Opernplatz
		//Häuser/Hotel für Theaterstrasse
		if(anzahlHaeuser_theaterstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_theaterstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_theaterstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_theaterstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_theaterstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+0*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+0*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Häuser/Hotel für Museumstrasse
		if(anzahlHaeuser_museumstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+2*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+2*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_museumstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+2*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+2*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_museumstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+2*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+2*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_museumstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+2*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+2*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_museumstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+2*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+2*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Häuser/Hotel für Opernplatz
		if(anzahlHaeuser_opernplatz == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_opernplatz > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_opernplatz > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_opernplatz > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_opernplatz > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+3*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+3*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		g.setColor(Color.black);
		g.drawString("Theaterstr.", startX+eckfeldLaenge+0*feldBreite+3, startY+10+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5);
		g.drawString("Museum-", startX+eckfeldLaenge+2*feldBreite+3, startY+10+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5);
		g.drawString("strasse", startX+eckfeldLaenge+2*feldBreite+7, startY+10+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5+17);
		g.drawString("Opernplatz", startX+eckfeldLaenge+3*feldBreite+3, startY+10+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5);
		
		ersterX = startX+eckfeldLaenge+0*feldBreite;
		ersterY = startY+eckfeldLaenge;
		int arx11[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary11[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+besitzKennzeichnung, ersterY};
		g.drawPolygon(arx11,ary11, 4);
		
		ersterX = startX+eckfeldLaenge+2*feldBreite;
		ersterY = startY+eckfeldLaenge;
		int arx12[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary12[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+besitzKennzeichnung, ersterY};
		g.drawPolygon(arx12,ary12, 4);
		
		ersterX = startX+eckfeldLaenge+3*feldBreite;
		ersterY = startY+eckfeldLaenge;
		int arx13[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary13[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+besitzKennzeichnung, ersterY};
		g.drawPolygon(arx13,ary13, 4);
		
		
		
		
		
		g.setColor(new Color(255, 255, 0));	//Gelb
		g.fillRect(startX+eckfeldLaenge+5*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Lessingstr
		g.fillRect(startX+eckfeldLaenge+6*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Schillerstr
		g.fillRect(startX+eckfeldLaenge+8*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Goethestr
		//Häuser/Hotel für Lessingstrasse
		if(anzahlHaeuser_lessingstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+5*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+5*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_lessingstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+5*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+5*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_lessingstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+5*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+5*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_lessingstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+5*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+5*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_lessingstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+5*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+5*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Häuser/Hotel für Schillerstrasse
		if(anzahlHaeuser_schillerstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_schillerstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_schillerstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_schillerstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_schillerstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+6*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+6*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		//Häuser/Hotel für Goethestrasse
		if(anzahlHaeuser_goethestr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			g.setColor(Color.black);
			g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+1+5, feldBreite-1-11, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
		}
		else
		{
			if(anzahlHaeuser_goethestr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_goethestr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5+14, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_goethestr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5+28, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
			if(anzahlHaeuser_goethestr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+eckfeldLaenge+8*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
				g.setColor(Color.black);
				g.drawRect(startX+eckfeldLaenge+8*feldBreite+1+5+42, startY+1+5, feldBreite-1-11-42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11);
			}
		}
		g.setColor(Color.black);
		g.drawString("Lessingstr.", startX+eckfeldLaenge+5*feldBreite+3, startY+10+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5);
		g.drawString("Schillerstr.", startX+eckfeldLaenge+6*feldBreite+3, startY+10+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5);
		g.drawString("Goethestr.", startX+eckfeldLaenge+8*feldBreite+3, startY+10+(int) (eckfeldLaenge*strassenNamenAnteil-1)+5);
		
		ersterX = startX+eckfeldLaenge+5*feldBreite;
		ersterY = startY+eckfeldLaenge;
		int arx14[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary14[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+besitzKennzeichnung, ersterY};
		g.drawPolygon(arx14,ary14, 4);
		
		ersterX = startX+eckfeldLaenge+6*feldBreite;
		ersterY = startY+eckfeldLaenge;
		int arx15[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary15[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+besitzKennzeichnung, ersterY};
		g.drawPolygon(arx15,ary15, 4);
		
		ersterX = startX+eckfeldLaenge+8*feldBreite;
		ersterY = startY+eckfeldLaenge;
		int arx16[] = {ersterX, ersterX+besitzKennzeichnung, ersterX+feldBreite-besitzKennzeichnung, ersterX+feldBreite};
		int ary16[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+besitzKennzeichnung, ersterY};
		g.drawPolygon(arx16,ary16, 4);
		
		
		
		
		
		g.setColor(new Color(0, 128, 0));	//Grün
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+0*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Rathausplatz
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+1*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Hauptstr
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+3*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Bahnhofstr
		//Häuser/Hotel für Bahnhofstrasse
		if(anzahlHaeuser_bahnhofstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_bahnhofstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_bahnhofstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_bahnhofstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_bahnhofstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+3*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		//Häuser/Hotel für Hauptstrasse
		if(anzahlHaeuser_hauptstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_hauptstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_hauptstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_hauptstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_hauptstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+1*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		//Häuser/Hotel für Rathhausplatz
		if(anzahlHaeuser_rathhausplatz == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_rathhausplatz > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_rathhausplatz > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_rathhausplatz > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_rathhausplatz > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+0*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		g.setColor(Color.black);
		g.drawString("Rathaus-", startX+spielfeldBreite-eckfeldLaenge+(int) (eckfeldLaenge*strassenNamenAnteil)+2, startY+eckfeldLaenge+0*feldHoehe+13);
		g.drawString("platz", startX+spielfeldBreite-eckfeldLaenge+(int) (eckfeldLaenge*strassenNamenAnteil)+12, startY+eckfeldLaenge+0*feldHoehe+13+17);
		g.drawString("Hauptstr.", startX+spielfeldBreite-eckfeldLaenge+(int) (eckfeldLaenge*strassenNamenAnteil)+2, startY+eckfeldLaenge+1*feldHoehe+13);
		g.drawString("Bahnhofstr.", startX+spielfeldBreite-eckfeldLaenge+(int) (eckfeldLaenge*strassenNamenAnteil)+2, startY+eckfeldLaenge+3*feldHoehe+13);
		
		ersterX = startX+spielfeldBreite-eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+0*feldHoehe;
		int arx17[] = {ersterX, ersterX-besitzKennzeichnung, ersterX-besitzKennzeichnung, ersterX};
		int ary17[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx17,ary17, 4);
		
		ersterX = startX+spielfeldBreite-eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+1*feldHoehe;
		int arx18[] = {ersterX, ersterX-besitzKennzeichnung, ersterX-besitzKennzeichnung, ersterX};
		int ary18[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx18,ary18, 4);
		
		ersterX = startX+spielfeldBreite-eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+3*feldHoehe;
		int arx19[] = {ersterX, ersterX-besitzKennzeichnung, ersterX-besitzKennzeichnung, ersterX};
		int ary19[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx19,ary19, 4);
		
		
		
		
		
		g.setColor(new Color(0, 0, 255));	//Dunkelblau
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+6*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Parkstr
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+8*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//Schlossallee
		//Häuser/Hotel für Schlossallee
		if(anzahlHaeuser_schlossallee == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_schlossallee > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_schlossallee > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_schlossallee > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			
			
			
			if(anzahlHaeuser_schlossallee > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+8*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		//Häuser/Hotel für Parkstrasse
		if(anzahlHaeuser_parkstr == 5)
		{
			g.setColor(Color.red);
			g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
			g.setColor(Color.black);
			g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11);
		}
		else
		{
			if(anzahlHaeuser_parkstr > 0)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_parkstr > 1)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6+14, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_parkstr > 2)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6+28, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
			if(anzahlHaeuser_parkstr > 3)
			{
				g.setColor(Color.green);
				g.fillRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
				g.setColor(Color.black);
				g.drawRect(startX+spielfeldBreite-eckfeldLaenge+6, startY+eckfeldLaenge+6*feldHoehe+6+42, (int) (eckfeldLaenge*strassenNamenAnteil-1)-11, feldHoehe-1-11-42);
			}
		}
		g.setColor(Color.black);
		g.drawString("Parkstr.", startX+spielfeldBreite-eckfeldLaenge+(int) (eckfeldLaenge*strassenNamenAnteil)+2, startY+eckfeldLaenge+6*feldHoehe+13);
		g.drawString("Schloss-", startX+spielfeldBreite-eckfeldLaenge+(int) (eckfeldLaenge*strassenNamenAnteil)+2, startY+eckfeldLaenge+8*feldHoehe+13);
		g.drawString("allee", startX+spielfeldBreite-eckfeldLaenge+(int) (eckfeldLaenge*strassenNamenAnteil)+12, startY+eckfeldLaenge+8*feldHoehe+13+17);
		
		ersterX = startX+spielfeldBreite-eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+6*feldHoehe;
		int arx20[] = {ersterX, ersterX-besitzKennzeichnung, ersterX-besitzKennzeichnung, ersterX};
		int ary20[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx20,ary20, 4);
		
		ersterX = startX+spielfeldBreite-eckfeldLaenge;
		ersterY = startY+eckfeldLaenge+8*feldHoehe;
		int arx21[] = {ersterX, ersterX-besitzKennzeichnung, ersterX-besitzKennzeichnung, ersterX};
		int ary21[] = {ersterY, ersterY+besitzKennzeichnung, ersterY+feldHoehe-besitzKennzeichnung, ersterY+feldHoehe};
		g.drawPolygon(arx21,ary21, 4);
		
		
		
		
		
		
		
		
		
		
		//Beenden Button
		g.setColor(Color.black);
		g.drawRect(1170, 970, 100, 20);
		g.drawString("Beenden", 1180, 985);
		
		
		
		
		
		
		
		
		
		
		//Graphics g, spieler, x1, y1, x2, y2, ppf
		figurBewegen(g, 0, 300, 300, 100, 300, 5);
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 *	Methode zur Darstellung der Figuren während der Bewegung
	 *	spieler gibt die Reihe der Sprites an
	 *	x1, y1 geben die Startposition an (Anzeige des ersten Frames)
	 *	x2, y2 geben die Endposition an (Anzeige des letzten Frames)
	 *	ppf (Pixel per Frame) gibt an, wie häufig der Frame gewechselt wird
	 *	
	 *	Es sind ausschließlich vertikale, horizontale und diagonale (45° Winkel) Bewegungen zulässig
	 *	(Andere führen zu falscher Darstellung)
	 */
	public void figurBewegen(Graphics g, int spieler, int x1, int y1, int x2, int y2, int ppf)
	{
		int pixelGesamt = 0;
		int pixelDiesesFrames = 0;
		int aktFrame = 0;
		
		if(x1 == x2)
		{
			pixelGesamt = Math.abs(y1-y2);
		}
		else
		{
			pixelGesamt = Math.abs(x1-x2);
		}
		
		for(int i = 0; i < pixelGesamt; i++)
		{
			if(x1 < x2)	//Figur geht nach rechts
			{
				if(y1 < y2)	//Figur geht nach unten
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1+i, y1+i);
					pixelDiesesFrames++;
				}
				else if(y1 > y2)	//Figur geht nach oben
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1+i, y1-i);
					pixelDiesesFrames++;
				}
				else	//Y bleibt
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1+i, y1);
					pixelDiesesFrames++;
				}
			}
			else if(x1 > x2)	//Figur geht nach links
			{
				if(y1 < y2)	//Figur geht nach unten
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1-i, y1+i);
					pixelDiesesFrames++;
				}
				else if(y1 > y2)	//Figur geht nach oben
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1-i, y1-i);
					pixelDiesesFrames++;
				}
				else	//Y bleibt
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1-i, y1);
					pixelDiesesFrames++;
				}
			}
			else	//X bleibt
			{
				if(y1 < y2)	//Figur geht nach unten
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1, y1+i);
					pixelDiesesFrames++;
				}
				else if(y1 > y2)	//Figur geht nach oben
				{
					figurFrames[spieler][aktFrame].paintIcon(this, g, x1, y1-i);
					pixelDiesesFrames++;
				}
			}
			
			if(pixelDiesesFrames == ppf)
			{
				pixelDiesesFrames = 0;
				aktFrame++;
				
				if(aktFrame == anz_frames)
				{
					aktFrame = 0;
				}
			}
			
			repaint();
			try{Thread.sleep(   50   );}catch (InterruptedException e){e.printStackTrace();}
		}
	}
	
	
	
	
	
	
	
	
	
	
	private BufferedImage loadImage()
	{
        File imgFile = new File(imgPath);
        BufferedImage buff = null;
        try
        {
            buff = ImageIO.read(imgFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return buff;
    }
	
	
	
	
	private void setImage()
	{ 
        BufferedImage bi = loadImage();
        Image newImg;
        
        for(int i=0; i<anz_spieler; i++)
        {
            for(int j=0; j<anz_frames; j++)
            {
                newImg = bi.getSubimage(i * spriteMasse, j * spriteMasse, spriteMasse, spriteMasse);
                figurFrames[i][j] = new ImageIcon(newImg);
                figurFrames[i][j].setImage(figurFrames[i][j].getImage().getScaledInstance(figur_streckfaktor*spriteMasse, figur_streckfaktor*spriteMasse, Image.SCALE_DEFAULT));
            }
        }
    }
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		Spielfeld g = new Spielfeld();
	}

	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		if(me.getX() > 1170 && me.getX() < 1270
				&& me.getY() > 970 && me.getY() < 990)
		{
			System.exit(0);
		}
	}
	public void mouseReleased(MouseEvent me){}
}

/*package Spielfeld;

import java.awt.*;


public class Spielfeld extends Frame
{
	Spielfeld()
	{
		super("Monopoly");
		setSize(1280, 900);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		Spielfeld spielfeld = new Spielfeld();
	}
	
	public void paint(Graphics g)
	{
		int startX=0;
		int startY=0;
		
		g.drawRect(startX, startY, 80, 80);
		
		
		
	}
	
}
*/