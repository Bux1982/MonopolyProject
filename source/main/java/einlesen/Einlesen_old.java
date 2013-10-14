package einlesen;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Einlesen_old {
	Path newFile = Paths.get("test1");

    //Reading from file
    try(BufferedReader reader = Files.newBufferedReader(
            newFile, Charset.defaultCharset())){
      String lineFromFile = "";
      System.out.println("The contents of file are: ");
      while((lineFromFile = reader.readLine()) != null){
        System.out.println(lineFromFile);
      }

    }catch(IOException exception){
      System.out.println("Error while reading file");
    }
  }
}
