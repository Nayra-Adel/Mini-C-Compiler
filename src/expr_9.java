package compilers_phase2;

public class expr_9 extends expr{
	Token NEW;
	type_spec type_spec;
	Token openSquare;
	expr expr;
	Token closeSquare;
	lr_expr lr_expr;

	public expr_9(Token nEW, type_spec type_spec, Token openSquare, expr expr, Token closeSquare, lr_expr lr_expr) {
		super();
		NEW = nEW;
		this.type_spec = type_spec;
		this.openSquare = openSquare;
		this.expr = expr;
		this.closeSquare = closeSquare;
		this.lr_expr = lr_expr;
	}




	@Override
	public void printNode() {
		System.out.println("-------expr_9-------------");
		
		System.out.println("new = ");
		if(NEW!=null) 
			System.out.println(NEW.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("type_spec = ");
		if(type_spec!=null) 
			type_spec.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("open square = ");
		if(openSquare!=null) 
			System.out.println(openSquare.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("expr = ");
		if(expr!=null) 
			expr.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("close square = ");
		if(closeSquare!=null) 
			System.out.println(closeSquare.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("lr_expr = ");
		if(lr_expr!=null) 
			lr_expr.printNode() ; 
		else 
			System.out.println("null");
		
	}
}
