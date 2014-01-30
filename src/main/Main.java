package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import parser.Parser;


import reader.ReaderFromTextFile;




public class Main {
	
	public static void main(String[] args) {
		String text=ReaderFromTextFile.readFromFile();
		Parser parser=new Parser(text);
		System.out.println(parser.getText());
		parser.doEverything();
		System.out.println("after");
		System.out.println(parser.getText());
		System.out.println(parser.getWordsArray());
		System.out.println(parser.getWordVovelnessMap());
		System.out.println(parser.getSortedByVovelnessArray());
		
		
	}

}
