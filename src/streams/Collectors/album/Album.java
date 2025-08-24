package streams.Collectors.album;

import org.jetbrains.annotations.NotNull;

public class Album{
    private String nome;
    private Artist artist;
    private int sales;

    public Album(Artist artist) {
        this.artist = artist;
    }

    public Album(String nome, Artist artist, int sales) {
        this.nome = nome;
        this.artist = artist;
        this.sales = sales;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void SetSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return nome;
    }

    public Artist artist() {
        return artist;
    }

    public int sales() {
        return sales;
    }
}
