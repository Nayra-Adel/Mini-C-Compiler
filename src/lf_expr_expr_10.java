package compilers_phase2;

public class lf_expr_expr_10 extends lf_expr_expr{
	Token minus;
	expr expr;
	
	public lf_expr_expr_10(Token minus, expr expr) {
		super();
		this.minus = minus;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_10-------------");
		
		System.out.println("minus = ");
		if(minus!=null) 
			System.out.println(minus.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
