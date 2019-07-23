package compilers_phase2;

public class lf_return_stmt_1 extends lf_return_stmt{
	Token semicolon;
	
	
	
	public lf_return_stmt_1(Token semicolon) {
		this.semicolon = semicolon;
	}



	@Override
	public void printNode() {
		System.out.println("-------left_return_stmt_1-------------");
		
		System.out.println("semicolon = ");
		if(semicolon!=null) 
			System.out.println(semicolon.getValue());  
		else 
			System.out.println("null");		
	}
	
}
