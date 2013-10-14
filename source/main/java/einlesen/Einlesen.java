package einlesen;

 
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO ram dingeling
import logik.*;
import logik.spielfeld.*;
import logik.karte.*;
//import logik.spielfeld.Strasse;

public class Einlesen {

	private static BufferedReader readDataFromDisk(String filePath) throws IOException {
		return new BufferedReader(new FileReader(filePath));
	}
	
	private static BufferedReader getNextStrasse() throws IOException {
		return new BufferedReader(new FileReader("j:\\Strassen.csv"));
	}

	//test change
//	private static void putDataInDaGame(String filePath) throws IOException {
//
////        try
////        {
//    		BufferedReader br = readDataFromDisk(filePath);
//
//            String line;
//            while ((line = br.readLine()) != null) {
//            	System.out.println(line);
//            	
//                StringTokenizer st = new StringTokenizer(line, ";");
////                return st;
//                
//                
////                fillSpecialStreets(st);
//
////                	new Strasse
//
////                System.out.println(name);
//            }
//            br.close();
////        } catch (e) {
////        	
////        }
//
//    }

	private static void fillstreetsObj(StringTokenizer st)
	{
		
		String fieldname = st.nextToken(); //Strassenname;
		int price_street= Integer.valueOf(st.nextToken());//Grundstückswert;
    	int rent = Integer.valueOf(st.nextToken());//Miete Grundstueck;
    	int rent_1house= Integer.valueOf(st.nextToken());//1 Haus;
    	int rent_2house = Integer.valueOf(st.nextToken());//2 Häuser;
    	int rent_3house = Integer.valueOf(st.nextToken());//3 Häuser;
    	int rent_4house = Integer.valueOf(st.nextToken());//4 Häuser;
    	int rent_hotel = Integer.valueOf(st.nextToken());//1 Hotel;
    	int price_house = Integer.valueOf(st.nextToken());//Kosten 1 Haus;
    	int price_hotel = Integer.valueOf(st.nextToken());//Kosten 1 Hotel;
    	int hypothek = Integer.valueOf(st.nextToken());//Hypothek;
    	String color = st.nextToken();//Farbe;
    	int position = Integer.valueOf(st.nextToken());//Position
    	
    	int[] arrMiete = {rent_1house, rent_2house, rent_3house, rent_4house};
    	int[] arrGruppe = getGruppe(color);

    	Strasse strasse = new Strasse(
        		fieldname,
        		position,
        		price_street,
        		rent,
        		hypothek,
        		arrGruppe,
        		color,
        		price_house,
        		price_hotel,
        		arrMiete,
        		rent_hotel
    	);
	}

	//TODO strassen.csv durchlesen und farben auf gleicheit prüfen, dann nachbarn in array schreiben
    private static int[] getGruppe(String ueColor)
    {
    	int[] returnInt;
    	
    }
    	
    	
	private static void fillStationObj(StringTokenizer st)
	{
		
		String fieldname = st.nextToken(); //Strassenname;
		int price_street= Integer.valueOf(st.nextToken());//Grundstückswert;
    	int rent_single = Integer.valueOf(st.nextToken());//Miete Grundstueck;
    	int rent_double= Integer.valueOf(st.nextToken());//1 Haus;
    	int rent_tripple = Integer.valueOf(st.nextToken());//2 Häuser;
    	int rent_multi = Integer.valueOf(st.nextToken());//3 Häuser;
    	int hypothek = Integer.valueOf(st.nextToken());//Hypothek;
    	int position = Integer.valueOf(st.nextToken());//Position
    	//TODO Gruppe
      	Bahnhof bahnhof = new Bahnhof(
      		fieldname,
      		position,
      		price_street,
      		rent_single,
      		hypothek
      	);
	}
	
	public static void fillStation(String filePath) throws IOException
    {
		BufferedReader br = readDataFromDisk(filePath);
		String line;

		line = br.readLine();
		line = br.readLine();
		while ((line) != null) {
			StringTokenizer st = new StringTokenizer(line, ";");
			fillStationObj(st);
			line = br.readLine();
		}
	}
	
	public static void fillStreets(String filePath) throws IOException
    {
		BufferedReader br = readDataFromDisk(filePath);
		String line;

		line = br.readLine();
		line = br.readLine();
		while ((line) != null) {
			StringTokenizer st = new StringTokenizer(line, ";");
			fillstreetsObj(st);
			line = br.readLine();
		}


    }
//  @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
//        new putDataInDaGame();
    	fillStreets("j:\\Strassen.csv");
    	fillStation("j:\\Bahnhoefe.csv");
    }

}