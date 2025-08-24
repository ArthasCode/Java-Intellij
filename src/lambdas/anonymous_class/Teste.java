package lambdas.anonymous_class;

import APIs_minhas.LoggerProxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;

public class Teste {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("abacaxi", "laranja", "maçã", "uva"));

        // Prática não mais utilizada!
//      Collections.sort(words, new Comparator<String>(){
//            public int compare(String s1, String s2){
//                return Integer.compare(s1.length(), s2.length());
//            }
//        });
        // Agora, é só lambda
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        LoggerProxy.registrarLog(words, Teste.class, Level.INFO);
    }
}
