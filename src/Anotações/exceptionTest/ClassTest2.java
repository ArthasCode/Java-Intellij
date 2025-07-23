package Anotações.exceptionTest;

public class ClassTest2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1(){
        int i = 0;
        i = i/i;
    }

    @ExceptionTest(IndexOutOfBoundsException.class)
    public static void m2(){
        String string = "hi";
        double hi = Double.valueOf(string);
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3(){

    }

}
