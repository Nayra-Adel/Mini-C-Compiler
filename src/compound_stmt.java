package compilers_phase2;

public class compound_stmt implements Node{
	Token openCurly;
	local_decls local_decls;
	stmt_list stmt_list;
	Token closeCurly;

	public compound_stmt(Token openCurly, compilers_phase2.local_decls local_decls,compilers_phase2.stmt_list stmt_list, Token closeCurly) {
		this.openCurly = openCurly;
		this.local_decls = local_decls;
		this.stmt_list = stmt_list;
		this.closeCurly = closeCurly;
	}

	@Override
	public void printNode() {
		System.out.println("-------compound_stmt-------------");
		
		System.out.println("open curly = ");
		if(openCurly!=null) 
			System.out.println(openCurly.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("local decls = ");
		if(local_decls!=null) 
			local_decls.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("stmt list = ");
		if(stmt_list!=null) 
			stmt_list.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("close curly = ");
		if(closeCurly!=null) 
			System.out.println(closeCurly.getValue());  
		else 
			System.out.println("null");
		
	}

}
