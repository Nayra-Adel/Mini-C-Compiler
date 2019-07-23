package compilers_phase2;

public class expr_6 extends expr{
	Token bool_lit;
	lr_expr lr_expr;
	

	public expr_6(Token bool_lit, lr_expr lr_expr) {
		super();
		this.bool_lit = bool_lit;
		this.lr_expr = lr_expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------expr_6-------------");
		
		System.out.println("boolean literal = ");
		if(bool_lit!=null) 
			System.out.println(bool_lit.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
