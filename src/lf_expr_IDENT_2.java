package compilers_phase2;

public class lf_expr_IDENT_2 extends lf_expr_IDENT{
	Token openSquare;
	expr expr_1;
	Token closeSquare;
	Token equal;
	expr expr_2;

	public lf_expr_IDENT_2(Token openSquare, expr expr_1, Token closeSquare, Token equal, expr expr_2) {
		super();
		this.openSquare = openSquare;
		this.expr_1 = expr_1;
		this.closeSquare = closeSquare;
		this.equal = equal;
		this.expr_2 = expr_2;
	}




	@Override
	public void printNode() {
		System.out.println("-------lf_expr_IDENT_2-------------");
		
		System.out.println("open square = ");
		if(openSquare!=null) 
			System.out.println(openSquare.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr_1!=null) 
			expr_1.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("close square = ");
		if(closeSquare!=null) 
			System.out.println(closeSquare.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("equal = ");
		if(equal!=null) 
			System.out.println(equal.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr_2!=null) 
			expr_2.printNode() ; 
		else 
			System.out.println("null");
	}
}
