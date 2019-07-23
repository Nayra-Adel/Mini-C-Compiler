package compilers_phase2;

public class fun_decl implements Node{

	type_spec type_spec;
	Token identefier;
	Token openRound;
	params params;
	Token closeRound;
	compound_stmt compound_stmt;
	
	public fun_decl(type_spec type_spec, Token identefier,Token openRound,params params,Token leftRound, compound_stmt compound_stmt) {
		this.type_spec = type_spec;
		this.identefier = identefier;
		this.openRound = openRound;
		this.params = params;
		this.closeRound = leftRound;
		this.compound_stmt = compound_stmt;
	}
	
	@Override
	public void printNode() {
		System.out.println("-------fun_decl-------------");
		
		System.out.println("type_spec = ");
		if(type_spec!=null) 
			type_spec.printNode() ; 
		else 
			System.out.println("null");	
		
		System.out.println("identefier = ");
		if(identefier!=null) 
			System.out.println(identefier.getValue()); 
		else 
			System.out.println("null");
		
		System.out.println("open round = ");
		if(openRound!=null) 
			System.out.println(openRound.getValue()); 
		else 
			System.out.println("null");
		
		System.out.println("params = ");
		if(params!=null) 
			params.printNode() ; 
		else 
			System.out.println("null");
		
		System.out.println("close round = ");
		if(closeRound!=null) 
			System.out.println(closeRound.getValue());  
		else 
			System.out.println("null");
		
		System.out.println("compound stmt = ");
		if(compound_stmt!=null) 
			compound_stmt.printNode() ; 
		else 
			System.out.println("null");
		
	}
	
}
