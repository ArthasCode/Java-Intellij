package Anotações.exceptionTestContainer;

import java.util.ArrayList;
import java.util.List;

public class ClassTest3 {

    @ExceptionTest2(NullPointerException.class)
    @ExceptionTest2(IndexOutOfBoundsException.class)
    public static void m1(){
        List<Integer> list = new ArrayList<>();

        list.addAll(5, null);
    }

    @ExceptionTest2(NullPointerException.class)
    public static void m2(){
        int i = 0;
        i = i/i;
    }
}
