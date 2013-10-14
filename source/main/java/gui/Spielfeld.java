package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Spielfeld extends Frame
{
	Image los = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/Los.gif");
	Image freiParken = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/FreiParken.gif");
	Image fragezeichen = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/Fragezeichen.gif");
	Image gemeinschaftsfeld = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/Gemeinschaftsfeld.gif");
	Image lock = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/Lock_HatNickSchoenGemacht.gif");
	Image monopolyLogo = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/MonopolyLogo.svg.gif");
	Image polizist = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/Polizist.gif");
	Image ring = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/Ring.gif");
	Image knast = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/knast.gif");
	Image birne = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/Birne.gif");
	Image wasserhahn = Toolkit.getDefaultToolkit().getImage( "J:/Monopoli/Monopolybilder/wasserhahn.gif");
	ImageObserver observer;
	
	
	
	private int spriteMasse = 8;   //Hoehe und Breite der Sprites in PX
	private int anz_spieler = 6;	//Index 6 ist reserviert f¸r Blinken
	private int anz_frames = 6;
	private int figur_streckfaktor = 8;
	String imgPath = "K:/Monopoly - Sven/FigurenGrid.PNG";
	private ImageIcon[][] figurFrames = new ImageIcon[anz_spieler][anz_frames];
	
	
	
	
	
	public Spielfeld()
	{
		super("Monopoly");
		setSize(1280, 1000);
		setImage();
		
		
		
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		//Oberer linker Punkt des Spielfeldes
		int startX = 10;
		int startY = 50;
		
		//Berechnen der Feld-Breite (oben und unten)
		int feldBreite = 66;
		
		//Berechnen der Feld-H√∂he (links und rechts)
		int feldHoehe = 66;
		
		//Grˆﬂe der Eckfelder (Los, Freiparken,...)
		int eckfeldLaenge = 100;
		
		//Ma√üe des Spielfeldes
		int spielfeldGroesse = (eckfeldLaenge*2+9*feldHoehe);
		int spielfeldBreite = (eckfeldLaenge*2+9*feldBreite);
		
		double strassenNamenAnteil = 0.3;
		
		int besitzKennzeichnung = 10;	//Anzahl der Pixel
		
		
		
		
		
		
		
		
		
		
		//Zeichnen des Spielfeldes (‰uﬂerer Rahmen)
		g.drawRect(startX, startY, spielfeldBreite, spielfeldGroesse);
		
		
		
		
		
		
		
		
		
		
		//Zeichnen der Eckfelder
		g.drawRect(startX, startY, eckfeldLaenge, eckfeldLaenge);						//Frei parken
		g.drawRect(startX+spielfeldBreite-eckfeldLaenge, startY, eckfeldLaenge, eckfeldLaenge);	//In das Gef√§ngnis
		g.drawRect(startX+spielfeldBreite-eckfeldLaenge, startY+spielfeldGroesse-eckfeldLaenge, eckfeldLaenge, eckfeldLaenge);				//Los
		g.drawRect(startX, startY+spielfeldGroesse-eckfeldLaenge, eckfeldLaenge, eckfeldLaenge);						//Gef√§ngnis
		
		//Zeichnen des inneren Vierecks
		g.drawRect(startX+eckfeldLaenge, startY+eckfeldLaenge, (spielfeldBreite-2*eckfeldLaenge), (spielfeldGroesse-2*eckfeldLaenge));
		
		
		
		
		
		
		
		
		
		
		//Zeichnen der Straﬂen (oben)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX+eckfeldLaenge+(i+1)*feldBreite, startY, startX+eckfeldLaenge+(i+1)*feldBreite, startY+eckfeldLaenge);
		}
		
		
		
		//Zeichnen der Straﬂen (unten)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX+eckfeldLaenge+(i+1)*feldBreite, startY+spielfeldGroesse-eckfeldLaenge, startX+eckfeldLaenge+(i+1)*feldBreite, startY+spielfeldGroesse);
		}
		
		
		
		//Zeichnen der Straﬂen (links)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX, startY+eckfeldLaenge+(i+1)*feldHoehe, startX+eckfeldLaenge, startY+eckfeldLaenge+(i+1)*feldHoehe);
		}
		
		
		
		//Zeichnen der Straﬂen (rechts)
		for(int i = 0; i < 8; i++)
		{
			g.drawLine(startX+spielfeldBreite-eckfeldLaenge, startY+eckfeldLaenge+(i+1)*feldHoehe, startX+spielfeldBreite, startY+eckfeldLaenge+(i+1)*feldHoehe);
		}
		
		
		
		
		
		
		
		
		
		
		//Los-Feld
		g.drawImage(los, startX+eckfeldLaenge+9*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, eckfeldLaenge-1, eckfeldLaenge-1, null);
		//und die anderen
		g.drawImage(freiParken, startX+eckfeldLaenge+9*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, eckfeldLaenge-1, eckfeldLaenge-1, null);
		
		
		
		
		
		
		
		
		//Hintergrundfarben der Straﬂennamen
		g.setColor(new Color(128, 64, 0));	//Braun
		g.fillRect(startX+eckfeldLaenge+8*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//Badstraﬂe
		g.fillRect(startX+eckfeldLaenge+6*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		//Besitz-Kennzeichnung
		g.setColor(Color.black);
		g.drawString("Badstr.", startX+eckfeldLaenge+8*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		g.drawString("Turmstr.", startX+eckfeldLaenge+6*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		int arx[] = {startX+eckfeldLaenge+8*feldBreite, startX+eckfeldLaenge+8*feldBreite+besitzKennzeichnung, startX+eckfeldLaenge+8*feldBreite+feldBreite-besitzKennzeichnung, startX+eckfeldLaenge+8*feldBreite+1+feldBreite-1};
		int ary[] = {startY+spielfeldGroesse-eckfeldLaenge, startY+spielfeldGroesse-eckfeldLaenge-besitzKennzeichnung, startY+spielfeldGroesse-eckfeldLaenge-besitzKennzeichnung, startY+spielfeldGroesse-eckfeldLaenge};
		g.drawPolygon(arx,ary,arx.length);
		int arx1[] = {startX+eckfeldLaenge+6*feldBreite, startX+eckfeldLaenge+6*feldBreite+besitzKennzeichnung, startX+eckfeldLaenge+6*feldBreite+feldBreite-besitzKennzeichnung, startX+eckfeldLaenge+6*feldBreite+1+feldBreite-1};
		int ary1[] = {startY+spielfeldGroesse-eckfeldLaenge, startY+spielfeldGroesse-eckfeldLaenge-besitzKennzeichnung, startY+spielfeldGroesse-eckfeldLaenge-besitzKennzeichnung, startY+spielfeldGroesse-eckfeldLaenge};
		g.drawPolygon(arx1,ary1,arx1.length);
		
		g.setColor(new Color(0, 255, 255));	//Hellblau
		g.fillRect(startX+eckfeldLaenge+3*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		g.fillRect(startX+eckfeldLaenge+1*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		g.fillRect(startX+eckfeldLaenge+0*feldBreite+1, startY+spielfeldGroesse-eckfeldLaenge+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		g.setColor(Color.black);
		g.drawString("Chausseestr.", startX+eckfeldLaenge+3*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		g.drawString("Elisenstr.", startX+eckfeldLaenge+1*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		g.drawString("Poststr.", startX+eckfeldLaenge+0*feldBreite+10, startY+spielfeldGroesse-eckfeldLaenge+1+(int) (eckfeldLaenge*strassenNamenAnteil-1)+15);
		
		g.setColor(new Color(255, 128, 0));	//Rosa
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+0*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+1*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+3*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.setColor(Color.black);
		g.drawString("Seestr.", (int) (startX+5), startY+eckfeldLaenge+8*feldHoehe+13);
		g.drawString("Hafenstr.", (int) (startX+5), startY+eckfeldLaenge+6*feldHoehe+13);
		g.drawString("Neue Str.", (int) (startX+5), startY+eckfeldLaenge+5*feldHoehe+13);
		
		g.setColor(new Color(255, 0, 255));	//Orange
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+5*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+6*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.fillRect((int) (startX+eckfeldLaenge*(1-strassenNamenAnteil)+1), startY+eckfeldLaenge+8*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.setColor(Color.black);
		g.drawString("M¸nchener Str.", (int) (startX+5), startY+eckfeldLaenge+3*feldHoehe+13);
		g.drawString("Wiener Str.", (int) (startX+5), startY+eckfeldLaenge+1*feldHoehe+13);
		g.drawString("Berliner Str.", (int) (startX+5), startY+eckfeldLaenge+0*feldHoehe+13);
		
		g.setColor(new Color(255, 0, 0));	//Rot
		g.fillRect(startX+eckfeldLaenge+0*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		g.fillRect(startX+eckfeldLaenge+2*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		g.fillRect(startX+eckfeldLaenge+3*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		
		g.setColor(new Color(255, 255, 0));	//Gelb
		g.fillRect(startX+eckfeldLaenge+5*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		g.fillRect(startX+eckfeldLaenge+6*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		g.fillRect(startX+eckfeldLaenge+8*feldBreite+1, startY+1, feldBreite-1, (int) (eckfeldLaenge*strassenNamenAnteil-1));	//
		
		
		g.setColor(new Color(0, 128, 0));	//Gr¸n
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+0*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+1*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+3*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		
		
		g.setColor(new Color(0, 0, 255));	//Dunkelblau
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+6*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		g.fillRect((int) (startX+spielfeldBreite-eckfeldLaenge+1), startY+eckfeldLaenge+8*feldHoehe+1, (int) (eckfeldLaenge*strassenNamenAnteil-1), feldHoehe-1);	//
		
		figurFrames[0][0].paintIcon(this, g, 50, 50);
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
                figurFrames[i][j].setImage(figurFrames[i][j].getImage().getScaledInstance(figur_streckfaktor, figur_streckfaktor, Image.SCALE_DEFAULT));
            }
        }
    }

	
	
	public static void main(String[] args)
	{
		Spielfeld g = new Spielfeld();
	}
}