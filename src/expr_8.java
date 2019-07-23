package compilers_phase2;

public class expr_8 extends expr{
	Token float_lit;
	lr_expr lr_expr;
	

	public expr_8(Token float_lit, lr_expr lr_expr) {
		super();
		this.float_lit = float_lit;
		this.lr_expr = lr_expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------expr_8-------------");
		
		System.out.println("float literal = ");
		if(float_lit!=null) 
			System.out.println(float_lit.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
