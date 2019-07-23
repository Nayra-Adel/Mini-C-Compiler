package compilers_phase2;

public class expr_2 extends expr{
	Token exclamation;
	expr expr;
	lr_expr lr_expr;
	
	public expr_2(Token exclamation, compilers_phase2.expr expr, compilers_phase2.lr_expr lr_expr) {
		super();
		this.exclamation = exclamation;
		this.expr = expr;
		this.lr_expr = lr_expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------expr_2-------------");
		
		System.out.println("exclamation = ");
		if(exclamation!=null) 
			System.out.println(exclamation.getValue());  
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
