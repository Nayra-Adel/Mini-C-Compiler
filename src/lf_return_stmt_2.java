package compilers_phase2;

public class lf_return_stmt_2 extends lf_return_stmt{
	expr expr;
	Token semicolon;
	
	
	public lf_return_stmt_2(compilers_phase2.expr expr, Token semicolon) {
		this.expr = expr;
		this.semicolon = semicolon;
	}


	@Override
	public void printNode() {
		System.out.println("-------left_return_stmt_2-------------");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("semicolon = ");
		if(semicolon!=null) 
			System.out.println(semicolon.getValue());  
		else 
			System.out.println("null");		
	}
}
