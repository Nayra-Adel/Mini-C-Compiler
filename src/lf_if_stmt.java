package compilers_phase2;

public class lf_if_stmt implements Node{
	Token ELSE;
	stmt stmt;
	
	public lf_if_stmt(Token ELSE, stmt stmt) {
		this.ELSE = ELSE;
		this.stmt = stmt;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_if_stmt-------------");
		
		System.out.println("while = ");
		if(ELSE!=null) 
			System.out.println(ELSE.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(stmt!=null) 
			stmt.printNode() ; 
		else 
			System.out.println("null");
	}
	
	
	
}
