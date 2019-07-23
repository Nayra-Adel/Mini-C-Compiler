package compilers_phase2;

public class decl_1 implements Node{


	type_spec type_spec;
	Token identefier;
	lf_decl lf_decl;

	public decl_1(type_spec type_spec, Token identefier, lf_decl lf_decl) {
		this.type_spec = type_spec;
		this.identefier = identefier;
		this.lf_decl = lf_decl;
	}

	@Override
	public void printNode() {
		System.out.println("-------decl-------------");

		System.out.println("type_spec = ");
		if (type_spec != null)
			type_spec.printNode();
		else
			System.out.println("null");

		System.out.println("identefier = ");
		if (identefier != null)
			System.out.println(identefier.getValue());
		else
			System.out.println("null");

		System.out.println("lf_decl = ");
		if (lf_decl != null)
			lf_decl.printNode();
		else
			System.out.println("null");
	}


}
