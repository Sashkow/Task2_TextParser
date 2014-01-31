package main;



import parser.Parser;


import reader.ReaderFromTextFile;




public class Main {
	
	public static void main(String[] args) {
		String text=ReaderFromTextFile.readFromFile("programming.txt");
		Parser parser=new Parser(text);
		System.out.println(parser.getText());
		parser.parce();
		System.out.println("after");
		System.out.println(parser.getText());// text without puncturation
		System.out.println(parser.getWordsArray());// splited into words array
		System.out.println(parser.getWordVovelnessMap());// mapped words to vovel letters percentage
		System.out.println(parser.getSortedByVovelnessArray());// sorted by vovel percentage accending
		
		
	}

}
