package compilers_phase2;

public class lf_expr_expr_3 extends lf_expr_expr{
	Token ne;
	expr expr;
	public lf_expr_expr_3(Token ne, expr expr) {
		super();
		this.ne = ne;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_3-------------");
		
		System.out.println("ne = ");
		if(ne!=null) 
			System.out.println(ne.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
