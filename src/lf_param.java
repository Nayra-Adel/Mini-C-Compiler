package compilers_phase2;

public class lf_param implements Node{
	Token closeSquareBracket;
	Token openSquareBracket;
	
	public lf_param(Token closeSquareBracket, Token openSquareBracket) {
		this.closeSquareBracket = closeSquareBracket;
		this.openSquareBracket = openSquareBracket;
	}

	@Override
	public void printNode() {
		System.out.println("-------lf_param-------------");
		System.out.println("open square bracket = ");
		if(openSquareBracket!=null) System.out.println(openSquareBracket.getValue());  else System.out.println("null");	
		System.out.println("close square bracket = ");
		if(closeSquareBracket!=null) System.out.println(closeSquareBracket.getValue());  else System.out.println("null");	
		
	}

}
