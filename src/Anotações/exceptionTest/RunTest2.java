package Anotações.exceptionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest2 {
    public static void main(String[] args) {
        int tests = 0;
        int passed =0;

        Class<?> testClass = ClassTest2.class;

         for(Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)){
                tests++;

                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                }catch (InvocationTargetException wrappedEx){
                    Throwable exc = wrappedEx.getCause();

                    ExceptionTest excAnnotation =
                            m.getAnnotation(ExceptionTest.class);
                    Class<? extends Throwable> excType = excAnnotation.value();
                    if(excType.isInstance(exc)) {
                        passed++;
                        continue;
                    }
                        System.out.printf(
                                "Test %s failed: expected %s, got %s%n",
                                m, excType.getName(), exc);
                    } catch (Exception _){
                    System.out.println("Invalid Test: " + m);
                }
            }
        }
    }
}
