package compilers_phase2;

public class stmt_6 extends stmt{
	Token break_;
	Token semicolon;
	public stmt_6(Token break_, Token semicolon) {
		super();
		this.break_ = break_;
		this.semicolon = semicolon;
	}
	
	public void printNode() {
		System.out.println("-------break_stmt-------------");
		
		System.out.println("break = ");
		if(break_!=null) 
			System.out.println(break_.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("semicolon = ");
		if(semicolon!=null) 
			System.out.println(semicolon.getValue());  
		else 
			System.out.println("null");
	}
}
