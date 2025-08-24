package referencias_para_metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TesteUpperCase {
    public static void main(String[] args) {
    List<String> palavras = new ArrayList<>(List.of("alohomola", "Olá", "IA", "Não sei"));

    palavras = palavras.stream()
            .map(String::toUpperCase)
            .toList();
    palavras.forEach(System.out::println);
    }
}
