package referencias_para_metodos;

import java.util.ArrayList;
import java.util.List;

public class TesteNomes {
    static List<String> names = new ArrayList<>(List.of("bruno", "pedro", "joanna", "matheus"));

    public static void main(String[] args) {
        names.forEach(System.out::println);
    }
}
