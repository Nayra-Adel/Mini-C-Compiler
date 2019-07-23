package compilers_phase2;

public class lf_expr_expr_9 extends lf_expr_expr{
	Token plus;
	expr expr;
	
	public lf_expr_expr_9(Token plus, expr expr) {
		super();
		this.plus = plus;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_9-------------");
		
		System.out.println("plus = ");
		if(plus!=null) 
			System.out.println(plus.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
