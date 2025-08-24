package referencias_para_metodos;

import java.util.ArrayList;
import java.util.List;

public class TesteSortNoCase {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>(List.of("Banana", "abacaxi", "Uva"));

        frutas.sort(String::compareToIgnoreCase);
        frutas.forEach(System.out::println);
    }
}
