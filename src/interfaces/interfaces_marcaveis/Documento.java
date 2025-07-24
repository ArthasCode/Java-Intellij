package interfaces.interfaces_marcaveis;

public class Documento implements Processable{
    private String name;

    public Documento(){}

    public Documento(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Documento doc = new Documento("planilha.excel");
        Processor.process(doc);

        // Não pode ser processado por não
        // implementar a interface Processable
        // Usuario user = new Usuario("Arthas");
        // Processor.process(user);
    }
}
