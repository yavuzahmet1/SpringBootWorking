package org.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.world.service.UsersGameService;
import org.world.service.WordsService;

@RestController
public class WorldController {
    private UsersGameService usersGameService;
    private WordsService wordsService;

    @Autowired
    public WorldController(UsersGameService usersGameService, WordsService wordsService) {
        this.usersGameService = usersGameService;
        this.wordsService = wordsService;
    }

    @GetMapping("/start")
    public String startGame() {
        return usersGameService.addGameToDataStore(wordsService.getRandomWorlds());
    }
}
