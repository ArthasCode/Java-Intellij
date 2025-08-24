package streams.Collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        Map<String, Long> freq = new HashMap<>();
        Path file = Paths.get(args[0]);

        try(Stream<String> words = Files.lines(file)){
            // Má prática! stream utilizadno uma função não pura!
//            words.forEach(word ->{
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });

            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq);

        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .toList();

        System.out.println(topTen);
    }
}
