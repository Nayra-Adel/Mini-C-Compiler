package compilers_phase2;

public class start1 extends start{
    public program program;

    public start1(compilers_phase2.program program) {
        this.program = program;
    }

    @Override
    public void printNode() {
        program.printNode();
    }
}
