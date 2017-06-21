package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InFile {
	
	public static String readDocument(String filename) throws FileNotFoundException {
		Scanner inScan = new Scanner(new File(filename));
		String doc = "";
		
		while(inScan.hasNextLine()) {
			doc += inScan.nextLine();
		}
		
		inScan.close();
		return doc;
	}
}
