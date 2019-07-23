package compilers_phase2;

public class stmt_2 extends stmt{
	compound_stmt compound_stmt;
	
	public stmt_2(compound_stmt compound_stmt) {
		this.compound_stmt = compound_stmt;
	}

	@Override
	public void printNode() {
		System.out.println("-------stmt_2-------------");
		
		System.out.println("compound_stmt = ");
		if(compound_stmt!=null) 
			compound_stmt.printNode() ; 
		else 
			System.out.println("null");			
	}
}
