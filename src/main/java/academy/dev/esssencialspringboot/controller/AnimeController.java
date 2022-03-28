package academy.dev.esssencialspringboot.controller;

import academy.dev.esssencialspringboot.domain.Anime;
import academy.dev.esssencialspringboot.service.AnimeService;
import academy.dev.esssencialspringboot.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDatetimeToDatabaseStyle(LocalDateTime.now()));
        return animeService.listAll();
    }
}
