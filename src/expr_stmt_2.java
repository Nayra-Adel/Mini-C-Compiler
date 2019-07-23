package compilers_phase2;

public class expr_stmt_2 extends expr_stmt{
	Token semicolon;
	
	public expr_stmt_2(Token semicolon) {
		this.semicolon = semicolon;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------expr_stmt_2-------------");
		
		System.out.println("semicolon = ");
		if(semicolon!=null) 
			System.out.println(semicolon.getValue());  
		else 
			System.out.println("null");		
	}
	

}
