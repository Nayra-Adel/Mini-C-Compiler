package compilers_phase2;

public class if_stmt implements Node{
	
	Token IF;
	Token openRound;
	expr expr;
	Token closeRound;
	stmt stmt;
	lf_if_stmt lf_if_stmt;
	
	public if_stmt(Token iF, Token openRound, compilers_phase2.expr expr, Token closedRound, compilers_phase2.stmt stmt,
			compilers_phase2.lf_if_stmt lf_if_stmt) {
		super();
		IF = iF;
		this.openRound = openRound;
		this.expr = expr;
		this.closeRound = closedRound;
		this.stmt = stmt;
		this.lf_if_stmt = lf_if_stmt;
	}

	@Override
	public void printNode() {
		System.out.println("-------if_stmt-------------");
		System.out.println("if = ");
		if(IF!=null) 
			System.out.println(IF.getValue());  
		else 
			System.out.println("null");
		
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
		
		System.out.println("stmt = ");
		if(stmt!=null) 
			stmt.printNode() ; 
		else 
			System.out.println("null");
		
		
		System.out.println("lf_if_stmt = ");
		if(lf_if_stmt!=null) 
			lf_if_stmt.printNode() ; 
		else 
			System.out.println("null");
		
	}
	
	

}
