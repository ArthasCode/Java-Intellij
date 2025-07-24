package interfaces.interfaces_marcaveis;

public class Processor {
    public static <T extends Processable> void process(T processable){
        System.out.println("Objeto processado: " + processable);
    }
}
