package compilers_phase2;

public class lf_expr_expr_5 extends lf_expr_expr{
	Token lessThan;
	expr expr;
	public lf_expr_expr_5(Token lessThan, expr expr) {
		super();
		this.lessThan = lessThan;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_5-------------");
		
		System.out.println("less than = ");
		if(lessThan!=null) 
			System.out.println(lessThan.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
