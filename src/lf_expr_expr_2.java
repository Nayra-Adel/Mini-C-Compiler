package compilers_phase2;

public class lf_expr_expr_2 extends lf_expr_expr{
	Token eq;
	expr expr;
	public lf_expr_expr_2(Token eq, expr expr) {
		super();
		this.eq = eq;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_2-------------");
		
		System.out.println("eq = ");
		if(eq!=null) 
			System.out.println(eq.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
