package compilers_phase2;

public class params_2 extends params{
	Token _void;
	
	public params_2(Token _void) {
		this._void = _void;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------params_2-------------");
		System.out.println("void = ");
		if(_void!=null) System.out.println(_void.getValue());  else System.out.println("null");	
		
	}
}
