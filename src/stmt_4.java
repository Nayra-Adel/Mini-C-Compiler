package compilers_phase2;

public class stmt_4 extends stmt{
	while_stmt while_stmt;
	
	public stmt_4(while_stmt while_stmt) {
		this.while_stmt = while_stmt;
	}

	@Override
	public void printNode() {
		System.out.println("-------stmt_4-------------");
		System.out.println("while_stmt = ");
		if(while_stmt!=null) while_stmt.printNode() ; else System.out.println("null");			
	}
}
