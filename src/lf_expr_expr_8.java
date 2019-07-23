package compilers_phase2;

public class lf_expr_expr_8 extends lf_expr_expr{
	Token and;
	expr expr;
	
	public lf_expr_expr_8(Token and, expr expr) {
		super();
		this.and = and;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_8-------------");
		
		System.out.println("and = ");
		if(and!=null) 
			System.out.println(and.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
