package compilers_phase2;

public class decl_2 extends decl{

	fun_decl fun_decl;
	
	public decl_2(fun_decl fun_decl) {
		this.fun_decl = fun_decl;
	}

	@Override
	public void printNode() {
		System.out.println("-------decl_2-------------");
		System.out.println("fun_decl = ");
		if(fun_decl!=null) fun_decl.printNode() ; else System.out.println("null");		
	}

}
