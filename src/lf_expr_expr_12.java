package compilers_phase2;

public class lf_expr_expr_12 extends lf_expr_expr{
	Token fs;
	expr expr;
	
	public lf_expr_expr_12(Token fs, expr expr) {
		super();
		this.fs = fs;
		this.expr = expr;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------lf_expr_expr_12-------------");
		
		System.out.println("forward slash = ");
		if(fs!=null) 
			System.out.println(fs.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
