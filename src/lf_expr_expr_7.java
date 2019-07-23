package compilers_phase2;

public class lf_expr_expr_7 extends lf_expr_expr{
	Token greaterThan;
	expr expr;
	
	public lf_expr_expr_7(Token greaterThan, expr expr) {
		super();
		this.greaterThan = greaterThan;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_7-------------");
		
		System.out.println("greater than = ");
		if(greaterThan!=null) 
			System.out.println(greaterThan.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
