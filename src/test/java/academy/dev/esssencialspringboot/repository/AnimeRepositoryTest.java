package academy.dev.esssencialspringboot.repository;

import static academy.dev.esssencialspringboot.util.AnimeCreator.createAnimeToBeSaved;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import academy.dev.esssencialspringboot.domain.Anime;
import lombok.extern.log4j.Log4j2;

@DataJpaTest
@DisplayName("Tests for Anime repository")
@Log4j2
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persists Anime when successful")
    void save_PersistAnime_WhenSuccessful() {
        Anime anime = createAnimeToBeSaved();
        Anime savedAnime = this.animeRepository.save(anime);

        Assertions.assertThat(savedAnime).isNotNull();
        Assertions.assertThat(savedAnime.getId()).isNotNull();
        Assertions.assertThat(savedAnime.getName()).isEqualTo(anime.getName());
    }

    @Test
    @DisplayName("Save update anime when successful")
    void save_UpdateAnime_WhenSuccessful() {
        Anime anime = createAnimeToBeSaved();
        Anime savedAnime = this.animeRepository.save(anime);

        savedAnime.setName("Overload");

        Anime animeUpdated = this.animeRepository.save(savedAnime);

        Assertions.assertThat(animeUpdated).isNotNull();
        Assertions.assertThat(animeUpdated.getId()).isNotNull();
        Assertions.assertThat(animeUpdated.getName()).isEqualTo(savedAnime.getName());
    }

    @Test
    @DisplayName("Delete remove anime when successful")
    void delete_RemoveAnime_WhenSuccessful() {
        Anime anime = createAnimeToBeSaved();
        Anime savedAnime = this.animeRepository.save(anime);

        this.animeRepository.delete(savedAnime);

        Optional<Anime> animeOptional = this.animeRepository.findById(savedAnime.getId());

        Assertions.assertThat(animeOptional).isEmpty();

    }

    @Test
    @DisplayName("Return empty list when anime not found")
    void findByName_ReturnEmptyList_WhenAnimeIsNotFound() {
        List<Anime> anime = this.animeRepository.findByName("savedAnime");

        Assertions.assertThat(anime).isEmpty();
    }

    @Test
    @DisplayName("Save trow ConstraintViolationException when name is empty")
    void save_TrowConstraintViolationException_WhenNameIsEmpty() {
        Anime anime = new Anime();

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.animeRepository.save(anime));
    }
}