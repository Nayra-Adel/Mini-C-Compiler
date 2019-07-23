package compilers_phase2;

public class expr_7 extends expr{
	Token int_lit;
	lr_expr lr_expr;
	

	public expr_7(Token int_lit, lr_expr lr_expr) {
		super();
		this.int_lit = int_lit;
		this.lr_expr = lr_expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------expr_7-------------");
		
		System.out.println("int literal = ");
		if(int_lit!=null) 
			System.out.println(int_lit.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
