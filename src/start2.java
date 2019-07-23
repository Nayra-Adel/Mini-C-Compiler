package compilers_phase2;

public class start2 extends start {
    public stmt_list stmt_list;

    public start2(compilers_phase2.stmt_list stmt_list) {
        this.stmt_list = stmt_list;
    }

    @Override
    public void printNode() {
        stmt_list.printNode();
    }
}
