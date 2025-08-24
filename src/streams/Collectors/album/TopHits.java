package streams.Collectors.album;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.toMap;

public class TopHits {
    public static void main(String[] args) {
        Artist a1 = new Artist("Kate Perry");
        Artist a2 = new Artist("Tom Holland");
        Artist a3 = new Artist("Will Smith");
        Album al1 = new Album("musicas boas", a1, 50);
        Album al2 = new Album("musicas do Will Smith", a3, 20);
        Album al3 = new Album("Filmes do Tom Holland", a2, 40);
        Album al4 = new Album("fafasfsafa", a2, 60);

        Stream<Album> albums = new ArrayList<>(List.of(al1, al2, al3, al4)).stream();

        Map<Artist, Album> topHits = albums.collect(
                toMap(Album::artist, a -> a,
                        maxBy(comparing(Album::sales)))
        );

        topHits.forEach((k, v) -> System.out.printf(
                "O album mais vendido do artista %s é o %s%n", k, v
        ));
    }
}
