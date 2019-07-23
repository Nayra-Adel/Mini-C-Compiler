package compilers_phase2;

public class lf_expr_expr_1 extends lf_expr_expr{
	Token or;
	expr expr;
	public lf_expr_expr_1(Token or, expr expr) {
		super();
		this.or = or;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_1-------------");
		
		System.out.println("or = ");
		if(or!=null) 
			System.out.println(or.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
