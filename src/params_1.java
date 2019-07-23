package compilers_phase2;

public class params_1 extends params{
	param param;
	lr_param_list lr_param_list;
	
	public params_1(param param, lr_param_list lr_param_list) {
		this.param = param;
		this.lr_param_list = lr_param_list;
	}

	@Override
	public void printNode() {
		System.out.println("-------params_1-------------");
		System.out.println("param = ");
		if(param!=null) param.printNode() ; else System.out.println("null");	
		System.out.println("lr_param_list = ");
		if(lr_param_list!=null) lr_param_list.printNode() ; else System.out.println("null");	
	}

}
