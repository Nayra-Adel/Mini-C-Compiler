package compilers_phase2;

public class lr_expr implements Node{
	
	lf_expr_expr lf_expr_expr;
	lr_expr lr_expr;
	
	public lr_expr(compilers_phase2.lf_expr_expr lf_expr_expr, lr_expr lr_expr) {
		super();
		this.lf_expr_expr = lf_expr_expr;
		this.lr_expr = lr_expr;
	}

	@Override
	public void printNode() {
		System.out.println("-------lr_expr-------------");
		
		System.out.println("lf_expr_expr = ");
		if(lf_expr_expr!=null) 
			lf_expr_expr.printNode(); 
		else 
			System.out.println("null");
		
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
	
	

}
