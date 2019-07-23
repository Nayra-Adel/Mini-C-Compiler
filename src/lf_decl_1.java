package compilers_phase2;

public class lf_decl_1 extends lf_decl {
    lf_var_decl lf_var_decl;

    public lf_decl_1(compilers_phase2.lf_var_decl lf_var_decl) {
        this.lf_var_decl = lf_var_decl;
    }

    @Override
    public void printNode() {
        System.out.println("-------lf_decl_1-------------");

        System.out.println("lf_var_decl = ");
        if(lf_var_decl!=null)
            lf_var_decl.printNode() ;
        else
            System.out.println("null");

    }
}
