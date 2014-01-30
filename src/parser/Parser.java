package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Parser {
	String text;
	ArrayList<String> wordsArray;
	Map<String,Double> wordVovelnessMap;
	ArrayList<String> sortedByVovelnessArray;
	Map<String,Double> sortedByVovelnessMap;
	
	
	public Map<String, Double> getSortedByVovelnessMap() {
		return sortedByVovelnessMap;
	}

	public void setSortedByVovelnessMap(Map<String, Double> sortedByVovelnessMap) {
		this.sortedByVovelnessMap = sortedByVovelnessMap;
	}

	public Parser(String text) {
		this.text=text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> getWordsArray() {
		return wordsArray;
	}

	public void setWordsArray(ArrayList<String> wordsArray) {
		this.wordsArray = wordsArray;
	}

	public Map<String, Double> getWordVovelnessMap() {
		return wordVovelnessMap;
	}

	public void setWordVovelnessMap(Map<String, Double> wordVovelnessMap) {
		this.wordVovelnessMap = wordVovelnessMap;
	}

	public void parce(){
		removeTabsParagraphsPunctuationAndSequentialWhiteSpaces();
		splitByWords();
		mapWords();	
		sortByVovelness();
		sortMapByVovelness();
		
		
	}
	
	

	private void sortMapByVovelness() {
		HashMap<String,Double> map = new HashMap<String,Double>();
        ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
		
	}

	private void sortByVovelness() {
		 sortedByVovelnessArray=new ArrayList<String>(wordVovelnessMap.keySet());
		 Collections.sort(sortedByVovelnessArray,new Comparator<String>() {
			 @Override
			public int compare(String o1, String o2) {
				 if (wordVovelnessMap.get(o1)<wordVovelnessMap.get(o2))
					 return -1;
				 if (wordVovelnessMap.get(o1)==wordVovelnessMap.get(o2))
					 return 0;
				 if (wordVovelnessMap.get(o1)>wordVovelnessMap.get(o2))
					 return 1;
				return 0;
			}
		});
		 
		
		
		
	}

	private void splitByWords() {
		String[] array=text.split(" ");
		wordsArray=new ArrayList<String>(Arrays.asList(array));
	}

	private void mapWords() {
		wordVovelnessMap=new HashMap<String, Double>();
		for (String word:wordsArray){
			if (!wordVovelnessMap.containsKey(word)){
				wordVovelnessMap.put(word, countVovelness(word));
			}
		}
	}

	private Double countVovelness(String word) {
		Integer vovelsAmount=0;
		for (char ch:word.toCharArray()){
			if (isVovel(ch)){
				vovelsAmount++;
			}
		}
		return (double)vovelsAmount/(double)word.length();
	}

	private boolean isVovel(char c) {
		if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U')
			return true;
		//а, е, и, і, о, у є, ю, я ї
		if(c=='а' || c=='е' || c=='и' || c=='і' || c=='о' || c=='у' || c=='є' || c=='ю' || c=='я' || c=='ї')
			return true;
	    return false;
	}
	
	

	private void removeTabsParagraphsPunctuationAndSequentialWhiteSpaces() {
		text = text.replaceAll("	", " ");
		text = text.replaceAll("\\.", "");

		text = text.replaceAll(",", "");
		
		text = text.replaceAll("!", "");
		
		text = text.replaceAll("\\(", "");
		text = text.replaceAll("\\)", "");
		
		text = text.replaceAll("\\?", "");
		
		text =text.replaceAll("\n", " ");
		
		text = text.replaceAll("-", "");
		
		text = text.replaceAll("  ", " ");
		
		text= text.toLowerCase();
		
		
		
		
	}

	public ArrayList<String> getSortedByVovelnessArray() {
		return sortedByVovelnessArray;
	}

	public void setSortedByVovelnessArray(ArrayList<String> sortedByVovelnessArray) {
		this.sortedByVovelnessArray = sortedByVovelnessArray;
	}

	
}
