package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderFromTextFile {
	public static String readFromFile(){
		try {
			String text = new Scanner( new File(System.getProperty("user.dir")+"/programming.txt") ).useDelimiter("\\A").next();
			
			return text.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
