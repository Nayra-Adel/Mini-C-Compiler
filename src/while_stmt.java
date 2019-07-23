package compilers_phase2;

public class while_stmt implements Node{
	Token WHILE;
	Token openRound;
	expr expr;
	Token closeRound;
	stmt stmt;
	
	public while_stmt(Token WHILE, Token openRound, expr expr, Token closeRound, stmt stmt) {
		this.WHILE = WHILE;
		this.openRound = openRound;
		this.expr = expr;
		this.closeRound = closeRound;
		this.stmt = stmt;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------while_stmt-------------");
		
		System.out.println("while = ");
		if(WHILE!=null) 
			System.out.println(WHILE.getValue());  
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
		
	}
}
