package interfaces.interfaces_marcaveis;

public class Usuario {
    private String name;

    public Usuario() {
    }

    public Usuario(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                '}';
    }
}
