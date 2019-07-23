package compilers_phase2;

public class lf_expr_IDENT_5 extends lf_expr_IDENT{
	Token dot;
	Token size;

	public lf_expr_IDENT_5(Token dot, Token size) {
		super();
		this.dot = dot;
		this.size = size;
	}

	@Override
	public void printNode() {
		System.out.println("-------lf_expr_IDENT_5-------------");
		
		System.out.println("dot = ");
		if(dot!=null) 
			System.out.println(dot.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("size = ");
		if(size!=null) 
			System.out.println(size.getValue());  
		else 
			System.out.println("null");
		
	}
}
