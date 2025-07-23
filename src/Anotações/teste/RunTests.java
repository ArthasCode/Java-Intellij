package Anotações.teste;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName(TestClass.class.getName());

        for(Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Test.class)){
                tests++;
                try{
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception e){
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n",
                passed, tests - passed);
    }
}
