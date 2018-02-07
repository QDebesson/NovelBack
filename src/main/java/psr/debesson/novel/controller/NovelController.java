package psr.debesson.novel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import psr.debesson.novel.domain.Novel;
import psr.debesson.novel.domain.NovelSummary;
import psr.debesson.novel.service.NovelService;

import java.util.List;

@RestController
public class NovelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NovelController.class);

    @Autowired
    private NovelService novelService;

    @GetMapping(value = "/novel", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public List<Novel> getNovels() {
        LOGGER.debug("Called GET");
        return novelService.getNovels();
    }

    @PostMapping(value = "/novel", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Novel saveNovel(@RequestBody final Novel novel) {
        LOGGER.debug("Called POST");
        return novelService.saveNovel(novel);
    }

    @PutMapping(value = "/novel/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Novel updateNovel(@RequestBody final Novel novel, @PathVariable("id") Long id) {
        LOGGER.debug("Called PUT");
        return novelService.updateNovel(novel, id);
    }

    @DeleteMapping(value = "/novel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public void deleteNovel(@PathVariable(value = "id") final Long id) {
        LOGGER.debug("Called DELETE");
        novelService.deleteNovel(id);
    }


    @GetMapping(value = "/novel/summary/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public NovelSummary getNovelSummary(@PathVariable(value = "id") final Long id) {
        LOGGER.debug("Called GET");
        return novelService.getNovelSummary(id);
    }

    @PostMapping(value = "/novel/summary/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public NovelSummary createNovelSummary(@RequestBody final NovelSummary summary, @PathVariable("id") Long id) {
        LOGGER.debug("Called POST");
        return novelService.saveNovelSummary(id, summary);
    }
}
