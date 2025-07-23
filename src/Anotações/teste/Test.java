package Anotações.teste;

import java.lang.annotation.*;

/**
 * A anotação, obrigatoriamente, será tratada em tempo de execução
 * ela funcionará apenas em métodos.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
