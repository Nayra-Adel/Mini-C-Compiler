package compilers_phase2;

public class lf_expr_expr_11 extends lf_expr_expr{
	Token star;
	expr expr;
	
	public lf_expr_expr_11(Token star, expr expr) {
		super();
		this.star = star;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_11-------------");
		
		System.out.println("star = ");
		if(star!=null) 
			System.out.println(star.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
