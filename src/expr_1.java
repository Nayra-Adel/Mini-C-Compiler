package compilers_phase2;

public class expr_1 extends expr{
	Token identefier;
	lf_expr_IDENT lf_expr_IDENT;
	lr_expr lr_expr;
	
	public expr_1(Token identefier, lf_expr_IDENT expr_IDENT, compilers_phase2.lr_expr lr_expr) {
		super();
		this.identefier = identefier;
		this.lf_expr_IDENT = lf_expr_IDENT;
		this.lr_expr = lr_expr;
	}


	@Override
	public void printNode() {
		System.out.println("-------expr_1-------------");
		
		System.out.println("identefier = ");
		if(identefier!=null) 
			System.out.println(identefier.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lf_expr_IDENT = ");
		if(lf_expr_IDENT!=null) 
			lf_expr_IDENT.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
	
}
