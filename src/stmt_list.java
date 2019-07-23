package compilers_phase2;

public class stmt_list implements Node{
	stmt stmt;
	stmt_list stmt_list;
	
	public stmt_list(stmt stmt, stmt_list stmt_list) {
		this.stmt = stmt;
		this.stmt_list = stmt_list;;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------stmt_list-------------");
		System.out.println("stmt = ");
		if(stmt!=null) stmt.printNode() ; else System.out.println("null");	
		System.out.println("stmt_list = ");
		if(stmt_list!=null) stmt_list.printNode() ; else System.out.println("null");	
		
		
	}

}
