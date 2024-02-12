package math;

public enum MathOperationType {

    SUM (new Sum()), VURMA (new Vurma());

    MathOperationInt op;

    MathOperationType(MathOperationInt op) {
        this.op = op;
    }

    public double calculate (double a, double b ) {
        return op.calculate(a,b);
    }
}
