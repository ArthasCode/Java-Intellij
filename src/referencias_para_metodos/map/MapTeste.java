package referencias_para_metodos.map;

import java.util.HashMap;
import java.util.Map;

public class MapTeste {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("banana", 1);
        map.put("maçã", 2);

        map.merge("abacaxi", 1, (quant, incr) -> quant + incr);
        map.merge("banana", 1, (quant, incr) -> quant + incr);

        System.out.println(map);
    }
}

