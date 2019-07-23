package compilers_phase2;

public class var_decl implements Node{
	
	type_spec type_spec;
	Token identefier;
	lf_var_decl lf_var_decl;
	
	public var_decl(type_spec type_spec, Token identefier, lf_var_decl lf_var_decl) {
		this.type_spec = type_spec;
		this.identefier = identefier;
		this.lf_var_decl = lf_var_decl;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------var_decl-------------");
		System.out.println("type_spec = ");
		if(type_spec!=null) type_spec.printNode() ; else System.out.println("null");	
		System.out.println("identefier = ");
		if(identefier!=null) System.out.println(identefier.getValue());  else System.out.println("null");
		System.out.println("lf_var_decl = ");
		if(lf_var_decl!=null) lf_var_decl.printNode() ; else System.out.println("null");
	}

}
