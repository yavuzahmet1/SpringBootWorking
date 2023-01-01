package worldsbuilding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import worldsbuilding.service.UsersGameService;
import worldsbuilding.service.WorldsService;

@RestController
public class WorldController {
    private UsersGameService usersGameService;
    private WorldsService worldsService;

    @Autowired
    public WorldController(UsersGameService usersGameService, WorldsService worldsService) {
        this.usersGameService = usersGameService;
        this.worldsService = worldsService;
    }


    @GetMapping("/start")
    public String startGame() {
        return usersGameService.addGameToDataStore(worldsService.getRandomWorlds());
    }
}
