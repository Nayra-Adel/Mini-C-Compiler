package compilers_phase2;

public class expr_5 extends expr{
	Token openRound;
	expr expr;
	Token closeRound;
	lr_expr lr_expr;
	
	public expr_5(Token openRound, compilers_phase2.expr expr, Token closeRound, compilers_phase2.lr_expr lr_expr) {
		super();
		this.openRound = openRound;
		this.expr = expr;
		this.closeRound = closeRound;
		this.lr_expr = lr_expr;
	}

	@Override
	public void printNode() {
		System.out.println("-------expr_5-------------");
		
		System.out.println("open round = ");
		if(openRound!=null) 
			System.out.println(openRound.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("close round = ");
		if(closeRound!=null) 
			System.out.println(closeRound.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
