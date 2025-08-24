package lambdas.Operation;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);


    private final DoubleBinaryOperator op;
    private final String symbol;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.op = op;
        this.symbol = symbol;
    }

    public double apply(double x, double y){
        return op.applyAsDouble(x , y);
    }
}
