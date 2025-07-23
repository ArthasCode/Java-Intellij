package Anotações.exceptionTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indica que o método anotado é um método de teste, que
 * deve ser bem sucedido ao lançar a exceção designada.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
