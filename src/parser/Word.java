package parser;

public class Word{
	private String actualString;
	public Word(String string) {
		this.actualString=string;
	}
	public String getActualString() {
		return actualString;
	}
	public void setActualString(String actualString) {
		this.actualString = actualString;
	}
	
	public String toString(){
		return actualString;
	}

}
