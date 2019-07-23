package compilers_phase2;

public class param implements Node{
	type_spec type_spec;
	Token identefier;
	lf_param lf_param;

	public param(compilers_phase2.type_spec type_spec, Token identefier, compilers_phase2.lf_param lf_param) {
		this.type_spec = type_spec;
		this.identefier = identefier;
		this.lf_param = lf_param;
	}

	@Override
	public void printNode() {
		System.out.println("-------param-------------");
		
		System.out.println("type_spec = ");
		if(type_spec!=null) 
			type_spec.printNode() ; 
		else 
			System.out.println("null");	
		
		System.out.println("identefier = ");
		if(identefier!=null) 
			System.out.println(identefier.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lf_param = ");
		if(lf_param!=null) 
			lf_param.printNode() ; 
		else 
			System.out.println("null");	
		
	}
	
}
