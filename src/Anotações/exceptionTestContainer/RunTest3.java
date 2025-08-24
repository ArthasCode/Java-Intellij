package Anotações.exceptionTestContainer;

import APIs_minhas.LoggerProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;

public class RunTest3 {
    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;

        for (Method m : ClassTest3.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest2.class)
            || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;

                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception", m);
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();

                    int oldPassed = passed;

                    ExceptionTest2[] excTypes =
                            m.getAnnotationsByType(ExceptionTest2.class);

                for (ExceptionTest2 excType : excTypes){
                    if (excType.value().isInstance(exc)) {
                        passed++;
                        break;
                }
            }
                if(passed == oldPassed)
                    LoggerProxy.registrarLog(String.format("Test %s failed: %s",
                            m, exc), RunTest3.class, Level.SEVERE);
                } catch (Exception _) {
                    System.out.println("Invalid Test: " + m);
                }
            }
        }
        LoggerProxy.registrarLog(String.format("Passed: %d failed: %s",
                passed, tests - passed), RunTest3.class, Level.INFO);
    }
}
