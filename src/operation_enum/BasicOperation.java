package operation_enum;
import APIs_minhas.LoggerProxy;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.logging.Level;

public enum BasicOperation implements Operation{
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        public double apply(double x, double y) {
            return x - y;
        }
    },
    DIVIDE("/"){
        public double apply(double x, double y) {
            return x / y;
        }
    },
    TIMES("*"){
        public double apply(double x, double y) {
            return x * y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(@NotNull String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(BasicOperation.class, x, y);
    }

    public static <T extends Enum<T> & Operation> void test(Class<T> opEnum, double x, double y){
        for(Operation op : opEnum.getEnumConstants())
            LoggerProxy.registrarLog(String.format("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y)), opEnum, Level.INFO);
    }
}
