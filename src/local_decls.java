package compilers_phase2;

public class local_decls implements Node{
	
	var_decl var_decl;
	local_decls local_decls;
	
	public local_decls(compilers_phase2.var_decl var_decl, local_decls local_decls) {
		super();
		this.var_decl = var_decl;
		this.local_decls = local_decls;
	}


	@Override
	public void printNode() {
		System.out.println("-------local_decls-------------");
		
		System.out.println("var decls = ");
		if(var_decl!=null) 
			var_decl.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("local decls = ");
		if(local_decls!=null) 
			local_decls.printNode() ; 
		else 
			System.out.println("null");
		
	}

}
