package compilers_phase2;

public class args implements Node{
	arg_list arg_list;

	public args(arg_list arg_list) {
		super();
		this.arg_list = arg_list;
	}
	
	public void printNode() {
		System.out.println("-------args-------------");
		
		System.out.println("args = ");
		if(arg_list!=null) 
			arg_list.printNode() ; 
		else 
			System.out.println("null");
	}
}
