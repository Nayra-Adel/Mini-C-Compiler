package compilers_phase2;

public class lf_decl_2 extends lf_decl {
    Token openRound;
    params params;
    Token closeRound;
    compound_stmt compound_stmt;

    public lf_decl_2(Token openRound,params params,Token leftRound, compound_stmt compound_stmt) {
        this.openRound = openRound;
        this.params = params;
        this.closeRound = leftRound;
        this.compound_stmt = compound_stmt;
    }

    @Override
    public void printNode() {
        System.out.println("-------lf_decl_2-------------");

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
