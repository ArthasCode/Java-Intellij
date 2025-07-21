package teste;

import java.util.logging.Logger;

public class Pessoa {
    private String name;

    Pessoa(String name){
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Teste{
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Arthas");

        Logger logger = Logger.getLogger(pessoa.getClass().getName());
        logger.info(pessoa.toString());
    }
}