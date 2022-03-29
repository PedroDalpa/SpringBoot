package academy.dev.esssencialspringboot.repository;

import academy.dev.esssencialspringboot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findAll();
}
