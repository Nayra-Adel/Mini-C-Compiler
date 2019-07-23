package compilers_phase2;

public class type_spec_1 extends type_spec{
	
	Token _void;
	
	public type_spec_1(Token _void) {
		this._void = _void;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------type_spec_1-------------");
		System.out.println("void = ");
		if(_void!=null) System.out.println(_void.getValue());  else System.out.println("null");	
		
	}

}
