package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Parser {
	String text;
	ArrayList<Word> wordsArray;
	Map<Word,Double> wordVovelnessMap;
	ArrayList<Word> sortedByVovelnessArray;
	
	

	public Parser(String text) {
		this.text=text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<Word> getWordsArray() {
		return wordsArray;
	}

	public void setWordsArray(ArrayList<Word> wordsArray) {
		this.wordsArray = wordsArray;
	}

	public Map<Word, Double> getWordVovelnessMap() {
		return wordVovelnessMap;
	}

	public void setWordVovelnessMap(Map<Word, Double> wordVovelnessMap) {
		this.wordVovelnessMap = wordVovelnessMap;
	}

	public void parce(){
		removeTabsParagraphsPunctuationAndSequentialWhiteSpaces();
		splitByWords();
		mapWords();	
		sortByVovelness();
		
		
	}
	
	

	

	private void sortByVovelness() {
		 sortedByVovelnessArray=new ArrayList<Word>(wordVovelnessMap.keySet());
		 Collections.sort(sortedByVovelnessArray,new Comparator<Word>() {
			 @Override
			public int compare(Word o1, Word o2) {
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
		
		wordsArray=new ArrayList<Word>();
		
		for (String s:array){
			wordsArray.add(new Word(s));
		}
	}

	private void mapWords() {
		wordVovelnessMap=new HashMap<Word, Double>();
		for (Word word:wordsArray){
			if (!wordVovelnessMap.containsKey(word)){
				wordVovelnessMap.put(word, countVovelness(word));
			}
		}
	}

	private Double countVovelness(Word word) {
		Integer vovelsAmount=0;
		Letter l;
		for (char ch:word.getActualString().toCharArray()){
			l =new Letter(ch);
			if (l.isVovel()){
				vovelsAmount++;
			}
		}
		return (double)vovelsAmount/(double)word.getActualString().length();
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

	public ArrayList<Word> getSortedByVovelnessArray() {
		return sortedByVovelnessArray;
	}

	public void setSortedByVovelnessArray(ArrayList<Word> sortedByVovelnessArray) {
		this.sortedByVovelnessArray = sortedByVovelnessArray;
	}

	
}
