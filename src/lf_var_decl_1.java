package compilers_phase2;

public class lf_var_decl_1 extends lf_var_decl{
	Token semiColon;
	
	public lf_var_decl_1(Token semiColon) {
		this.semiColon = semiColon;
	}

	@Override
	public void printNode() {
		System.out.println("-------lf_var_decl_1-------------");
		System.out.println("semi colon = ");
		if(semiColon!=null) System.out.println(semiColon.getValue());  else System.out.println("null");	
		
	}
	
}
