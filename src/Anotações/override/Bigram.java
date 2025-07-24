package Anotações.override;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bigram {
    private char first;
    private char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    // metodo equals com defeito!
    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }
        public static void main (String[] args){
            Set<Bigram> bigrams = new HashSet<>();
            for (int i = 0; i < 10; i++)
                for (char ch = 'a'; ch <= 'z'; ch++)
                    bigrams.add(new Bigram(ch, ch));
            System.out.println(bigrams.size());
        }
    }
