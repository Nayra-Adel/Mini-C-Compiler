package compilers_phase2;

public class lr_param_list implements Node{

	Token comma;
	param param;
	lr_param_list lr_param_list;
	
	public lr_param_list(Token comma, param param, lr_param_list lr_param_list) {
		this.comma = comma;
		this.param = param;
		this.lr_param_list = lr_param_list;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lr_param_list-------------");
		System.out.println("comma = ");
		if(comma!=null) System.out.println(comma.getValue());  else System.out.println("null");
		System.out.println("param = ");
		if(param!=null) param.printNode() ; else System.out.println("null");	
		System.out.println("lr_param_list = ");
		if(lr_param_list!=null) lr_param_list.printNode() ; else System.out.println("null");	
		
	}
	
}
