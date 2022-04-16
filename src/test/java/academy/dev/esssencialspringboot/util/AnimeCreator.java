package academy.dev.esssencialspringboot.util;

import academy.dev.esssencialspringboot.domain.Anime;

public class AnimeCreator {
    public static Anime createAnimeToBeSaved() {
        return Anime.builder().name("Naturo").build();
    }
    public static Anime createValidAnime() {
        return Anime.builder()
                .name("Naturo")
                .id(1L)
                .build();
    }
    public static Anime createValidUpdateAnime() {
        return Anime.builder()
                .name("DBZ")
                .id(1L)
                .build();
    }
}
