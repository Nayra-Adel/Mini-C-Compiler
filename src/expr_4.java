package compilers_phase2;

public class expr_4 extends expr{
	Token plus;
	expr expr;
	lr_expr lr_expr;
	
	public expr_4(Token plus, expr expr, lr_expr lr_expr) {
		super();
		this.plus = plus;
		this.expr = expr;
		this.lr_expr = lr_expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------expr_4-------------");
		
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
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
