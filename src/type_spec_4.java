package compilers_phase2;

public class type_spec_4 extends type_spec{
	Token _float;
	
	public type_spec_4(Token _float) {
		this._float = _float;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------type_spec_4-------------");
		System.out.println("float = ");
		if(_float!=null) System.out.println(_float.getValue());  else System.out.println("null");	
		
	}
}
