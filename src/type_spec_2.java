package compilers_phase2;

public class type_spec_2 extends type_spec{
	
	Token _bool;
	
	public type_spec_2(Token _bool) {
		this._bool = _bool;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------type_spec_2-------------");
		System.out.println("bool = ");
		if(_bool!=null) System.out.println(_bool.getValue());  else System.out.println("null");	
		
	}

}
