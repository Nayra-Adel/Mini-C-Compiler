
package compilers_phase2;

public class expr_stmt_1 extends expr_stmt{
	expr expr;
	Token semicolon;
	
	public expr_stmt_1(expr expr, Token semicolon) {
		this.expr = expr;
		this.semicolon = semicolon;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------expr_stmt_1-------------");
		
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
