package compilers_phase2;

public class stmt_5 extends stmt{
	return_stmt return_stmt;
	
	public stmt_5(return_stmt return_stmt) {
		this.return_stmt = return_stmt;
	}

	@Override
	public void printNode() {
		System.out.println("-------stmt_5-------------");
		System.out.println("return_stmt = ");
		if(return_stmt!=null) return_stmt.printNode() ; else System.out.println("null");			
	}
}
