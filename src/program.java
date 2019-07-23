package compilers_phase2;

public class program implements Node {
	
	public decl_list decl_list;
	
	public program(decl_list decl_list) {
		this.decl_list = decl_list;
	}
	
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("-------program-------------");
		System.out.println("decl_list = ");
		if(decl_list!=null) decl_list.printNode() ; else System.out.println("null");
		System.out.println("--------------------");
	}

}
