package compilers_phase2;

public class return_stmt implements Node{

	Token RETURN;
	lf_return_stmt lf_return_stmt;
	
	
	
	public return_stmt(Token rETURN, lf_return_stmt lf_return_stmt) {
		RETURN = rETURN;
		this.lf_return_stmt = lf_return_stmt;
	}



	@Override
	public void printNode() {
		System.out.println("-------return_stmt-------------");
		
		
		System.out.println("return = ");
		if(RETURN!=null) 
			System.out.println(RETURN.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lf_return_stmt = ");
		if(lf_return_stmt!=null) 
			lf_return_stmt.printNode() ; 
		else 
			System.out.println("null");
		
	}
	
}
