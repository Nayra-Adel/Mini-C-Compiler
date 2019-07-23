package compilers_phase2;

public class type_spec_3 extends type_spec{
	Token _int;
	
	public type_spec_3(Token _int) {
		this._int = _int;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------type_spec_3-------------");
		System.out.println("int = ");
		if(_int!=null) System.out.println(_int.getValue());  else System.out.println("null");	
		
	}
}
