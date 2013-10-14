package einlesen;

 
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class putDataInDaGame {

	private static BufferedReader readDataFromDisk(String filePath) throws IOException {
		return new BufferedReader(new FileReader(filePath));
	}

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
    	int rent_double = Integer.valueOf(st.nextToken());//Miete Grundstück doppelt;
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
    	
//    	Strasse strasse = new Strasse(fieldname, position);
	}

	
	public static void fillStreets(String filePath) throws IOException
    {
		BufferedReader br = readDataFromDisk(filePath);
		String line;

		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, ";");
			fillstreetsObj(st);

		}

//		StringTokenizer st = putDataInDaGame("j:\\Strassen.csv");


    }
//  @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
//        new putDataInDaGame();
    	fillStreets("j:\\Strassen.csv");
    }

}