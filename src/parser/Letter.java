package parser;

public class Letter extends Symbol{

	public Letter(char cha) {
		super(cha);
		
	}
	
	public boolean isVovel() {
		char c=this.getActualChar();
		if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U')
			return true;
		//а, е, и, і, о, у є, ю, я ї
		if(c=='а' || c=='е' || c=='и' || c=='і' || c=='о' || c=='у' || c=='є' || c=='ю' || c=='я' || c=='ї')
			return true;
	    return false;
	}
		
	

}
