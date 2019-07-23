package compilers_phase2;

public class lf_expr_expr_13 extends lf_expr_expr{
	Token percentage;
	expr expr;
	
	public lf_expr_expr_13(Token percentage, expr expr) {
		super();
		this.percentage = percentage;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_13-------------");
		
		System.out.println("percentage = ");
		if(percentage!=null) 
			System.out.println(percentage.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
