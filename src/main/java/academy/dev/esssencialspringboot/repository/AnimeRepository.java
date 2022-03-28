package academy.dev.esssencialspringboot.repository;

import academy.dev.esssencialspringboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> listAll();
}
