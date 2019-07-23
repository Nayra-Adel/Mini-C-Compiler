package compilers_phase2;

public class expr_3 extends expr{
	Token dash;
	expr expr;
	lr_expr lr_expr;
	
	public expr_3(Token dash, expr expr, lr_expr lr_expr) {
		super();
		this.dash = dash;
		this.expr = expr;
		this.lr_expr = lr_expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------expr_3-------------");
		
		System.out.println("dash = ");
		if(dash!=null) 
			System.out.println(dash.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
