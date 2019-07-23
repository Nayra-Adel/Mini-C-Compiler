package compilers_phase2;

public class lf_expr_expr_4 extends lf_expr_expr{
	Token le;
	expr expr;
	public lf_expr_expr_4(Token le, expr expr) {
		super();
		this.le = le;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_4-------------");
		
		System.out.println("le = ");
		if(le!=null) 
			System.out.println(le.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
