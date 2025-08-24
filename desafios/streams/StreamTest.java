package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamTest {
    public static void main(String[] args) {
        List<String> names = List.of("Arthas", "Pedro", "Maria", "Ana", "Bruno", "Paula");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        //Exercício 1 Filtrar todos os nomes que começam com a letra A e imprimir na tela
        System.out.println("Exercício 1:");
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
        System.out.println();
        //Exercício 2 Mapear todos os nomes para letras maiúsculas e imprimir.
        System.out.println("Exercício 2:");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();
        //Exercício 3 Pegar todos os números pares da lista numeros e imprimir.
        System.out.println("Exercício 3");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        System.out.println();
        //Exercício 4 Somar todos os números da lista usando reduce.
        System.out.println("Exercício 4:");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println();
        //Exercício 5 Contar quantos nomes possuem mais de 5 letras.
        System.out.println("Exercício 5:");
        long nomesComMaisDe5Letras = names.stream()
                .filter(name -> name.length() > 5)
                .count();

        System.out.println(nomesComMaisDe5Letras);
        System.out.println();
        //Exercício 6 Ordenar a lista de nomes em ordem alfabética usando sorted.
        System.out.println("Exercício 6:");
        names.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
        System.out.println();
        //Exercício 7 Criar uma nova lista apenas com o quadrado de cada número da lista numeros.
        System.out.println("Exercício 7:");
        List<Integer> quad = numbers.stream()
                .map(num -> num * num)
                .toList();
        System.out.println("Lista original: " + numbers);
        System.out.println("Lista modificada: " + quad);
        System.out.println();
        //Exercício 8 Encontrar o maior número usando max.
        System.out.println("Exercício 8:");
        numbers.stream()
                .max(Integer::compare)
                .ifPresent(max -> System.out.println("O número máximo de numbers é: " + max));
        System.out.println();
        //Exercício 9 Agrupar os nomes pela primeira letra usando groupingBy.
        System.out.println("Exercício 9:");
        names.stream()
                .collect(groupingBy(name -> name.charAt(0)))
                .forEach((k, v) ->
                        System.out.printf("O(s) nome(s): %s possuem a inicial: %s%n", v, k));
        System.out.println();
        //Exercício 10 Criar um Map<Integer, List<String>> agrupando os nomes pelo tamanho.
        System.out.println("Exercício 10:");
        Map<Integer, List<String>> sameLengthMap = names.stream()
                .collect(groupingBy(name -> name.length()));
        sameLengthMap.forEach((k, v) ->
                System.out.printf("O(s) nome(s): %s possuem o mesmo tamanho de: %d letras%n", v, k));
        System.out.println("");
        //Exercício 11 Criar um Map<Character, Long> contando quantos nomes começam com cada letra.
        System.out.println("Exercício 11:");
        Map<Character, Long> sameLetterMap = names.stream()
                .collect(groupingBy(name -> name.charAt(0),
                        Collectors.counting()));

        sameLetterMap.forEach((k, v) ->
                System.out.printf("Existe(m) %d nome(s) que começa(m) com %s%n", v, k));
        System.out.println();
        //Exercício 12 Somar todos os números ímpares da lista usando filter + map + reduce.
        System.out.println("Exercício 12:");
        int oddSum = numbers.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("A soma de todos os impares é: " + oddSum);
        System.out.println();
        //Exercício 13 Dada uma lista de frases, criar uma lista com todas as palavras únicas (sem repetição) em ordem alfabética.
        System.out.println("Exercício 13:");
        Stream<String> sentences = List.of("Hello World!", "Hello guys!"
                ,"Hi World!", "Hi guys!").stream();
        List<String> sortedUniqueWords = sentences
                .flatMap(sentence ->
                        Stream.of(sentence.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .sorted(String::compareTo)
                .toList();

        System.out.println(sortedUniqueWords);
        System.out.println();
        //Exercício 14 
    }
}
