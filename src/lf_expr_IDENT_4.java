package compilers_phase2;

public class lf_expr_IDENT_4 extends lf_expr_IDENT{
	Token openRound;
	args args;
	Token closeRound;

	public lf_expr_IDENT_4(Token openRound, compilers_phase2.args args, Token closeRound) {
		super();
		this.openRound = openRound;
		this.args = args;
		this.closeRound = closeRound;
	}


	@Override
	public void printNode() {
		System.out.println("-------lf_expr_IDENT_4-------------");
		
		System.out.println("open round = ");
		if(openRound!=null) 
			System.out.println(openRound.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("args = ");
		if(args!=null) 
			args.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("close round = ");
		if(closeRound!=null) 
			System.out.println(closeRound.getValue());  
		else 
			System.out.println("null");
		
	}
}
