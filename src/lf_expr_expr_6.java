package compilers_phase2;

public class lf_expr_expr_6 extends lf_expr_expr{
	Token ge;
	expr expr;
	
	public lf_expr_expr_6(Token ge, expr expr) {
		super();
		this.ge = ge;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_6-------------");
		
		System.out.println("ge = ");
		if(ge!=null) 
			System.out.println(ge.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
