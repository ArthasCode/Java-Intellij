package streams.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramsStream {
    public static void main(String[] args) throws IOException {
        Path dicitionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try(Stream<String> words = Files.lines(dicitionary)){
            words.collect(Collectors.groupingBy(word -> alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(group -> System.out.printf("%d : %s%n", group.size(), group));
        }
    }

    static String alphabetize(String word) {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
