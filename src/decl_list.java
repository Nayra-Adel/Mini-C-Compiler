package compilers_phase2;

public class decl_list implements Node{
	decl_1 decl;
	lr_decl_list lr_decl_list;
	
	public decl_list(decl_1 decl, lr_decl_list lr_decl_list) {
		this.decl = decl;
		this.lr_decl_list = lr_decl_list;
	}

	@Override
	public void printNode() {
		System.out.println("-------decl_list-------------");
		System.out.println("decl = ");
		if(decl!=null) decl.printNode() ; else System.out.println("null");
		System.out.println(" lr_decl_list = ");
		if(lr_decl_list!=null) lr_decl_list.printNode() ; else System.out.println("null");
		System.out.println("--------------------");
	}
	

}
