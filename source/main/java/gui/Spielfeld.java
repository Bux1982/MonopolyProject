package gui;

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
