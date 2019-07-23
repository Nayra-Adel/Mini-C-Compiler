package compilers_phase2;

public class lf_expr_IDENT_1 extends lf_expr_IDENT{
	Token equal;
	expr expr;

	public lf_expr_IDENT_1(Token equal, expr expr) {
		super();
		this.equal = equal;
		this.expr = expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------lf_expr_IDENT_1-------------");
		
		System.out.println("dash = ");
		if(equal!=null) 
			System.out.println(equal.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
	}
}
