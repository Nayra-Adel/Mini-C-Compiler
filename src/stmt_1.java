package compilers_phase2;

public class stmt_1 extends stmt{
	expr_stmt expr_stmt;
	
	public stmt_1(expr_stmt expr_stmt) {
		this.expr_stmt = expr_stmt;
	}

	@Override
	public void printNode() {
		System.out.println("-------stmt_1-------------");
		System.out.println("expr_stmt = ");
		if(expr_stmt!=null) expr_stmt.printNode() ; else System.out.println("null");			
	}
}
