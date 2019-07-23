package compilers_phase2;

public class stmt_3 extends stmt{
	if_stmt if_stmt;
	
	public stmt_3(if_stmt if_stmt) {
		this.if_stmt = if_stmt;
	}

	@Override
	public void printNode() {
		System.out.println("-------stmt_3-------------");
		System.out.println("if_stmt = ");
		if(if_stmt!=null) if_stmt.printNode() ; else System.out.println("null");			
	}
}
