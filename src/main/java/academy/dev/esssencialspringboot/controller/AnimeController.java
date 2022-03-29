package academy.dev.esssencialspringboot.controller;

import academy.dev.esssencialspringboot.domain.Anime;
import academy.dev.esssencialspringboot.requests.AnimePostRequestBody;
import academy.dev.esssencialspringboot.requests.AnimePutRequestBody;
import academy.dev.esssencialspringboot.service.AnimeService;
import academy.dev.esssencialspringboot.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDatetimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> create(@RequestBody AnimePostRequestBody anime) {
        return new ResponseEntity<>(animeService.create(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> edit(@RequestBody AnimePutRequestBody anime) {
        animeService.update(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
