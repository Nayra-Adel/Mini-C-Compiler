package compilers_phase2;

public class lf_var_decl_2 extends lf_var_decl{
	
	Token semiColon;
	Token closeSquareBracket;
	Token openSquareBracket;
	
	public lf_var_decl_2(Token semiColon, Token closeSquareBracket, Token openSquareBracket) {
		this.semiColon = semiColon;
		this.closeSquareBracket = closeSquareBracket;
		this.openSquareBracket = openSquareBracket;
	}

	@Override
	public void printNode() {
		System.out.println("-------lf_var_decl_2-------------");
		System.out.println("open square bracket = ");
		if(openSquareBracket!=null) System.out.println(openSquareBracket.getValue());  else System.out.println("null");	
		System.out.println("close square bracket = ");
		if(closeSquareBracket!=null) System.out.println(closeSquareBracket.getValue());  else System.out.println("null");	
		System.out.println("semi colon = ");
		if(semiColon!=null) System.out.println(semiColon.getValue());  else System.out.println("null");	
		
	}

}
