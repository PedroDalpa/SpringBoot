package academy.dev.esssencialspringboot.util;


import academy.dev.esssencialspringboot.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody() {
        return AnimePutRequestBody.builder()
                .name(AnimeCreator.createValidUpdateAnime().getName())
                .id(AnimeCreator.createValidUpdateAnime().getId())
                .build();
    }
}
