package compilers_phase2;

public class arg_list implements Node{
	expr expr;
	lr_arg_list lr_arg_list;
	
	
	public arg_list(expr expr, lr_arg_list lr_arg_list) {
		this.expr = expr;
		this.lr_arg_list = lr_arg_list;
	}


	@Override
	public void printNode() {
		System.out.println("-------arg_list-------------");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("lr_arg_list = ");
		if(lr_arg_list!=null) 
			lr_arg_list.printNode() ; 
		else 
			System.out.println("null");		
	}
}
