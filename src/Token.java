package compilers_phase2;

public class Token implements Comparable<Token>{
	private String type;
	private String value;
	private int start;
	
	public Token(String type, String value, int start){
		this.type = type;
		this.value = value;
		this.start = start;
	}
	
	public void setType(String t){
		type = t;
	}
	public void setValue(String v){
		value = v;
	}
	public void setStart(int s){
		start = s;
	}
	public String getType(){
		return type;
	}
	public String getValue(){
		return value;
	}
	public int getStart(){
		return start;
	}

	@Override
	public int compareTo(Token t) {
		
		return Integer.compare(this.start, t.start);
	}
	
	
}
