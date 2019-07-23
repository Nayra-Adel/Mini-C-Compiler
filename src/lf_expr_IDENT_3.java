package compilers_phase2;

public class lf_expr_IDENT_3 extends lf_expr_IDENT{
	Token openSquare;
	expr expr;
	Token closeSquare;

	public lf_expr_IDENT_3(Token openSquare, expr expr, Token closeSquare) {
		super();
		this.openSquare = openSquare;
		this.expr = expr;
		this.closeSquare = closeSquare;
		
	}




	@Override
	public void printNode() {
		System.out.println("-------lf_expr_IDENT_3-------------");
		
		System.out.println("open square = ");
		if(openSquare!=null) 
			System.out.println(openSquare.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("close square = ");
		if(closeSquare!=null) 
			System.out.println(closeSquare.getValue());  
		else 
			System.out.println("null");
		
	}
}
