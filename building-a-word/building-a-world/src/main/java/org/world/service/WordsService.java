package org.world.service;

import jakarta.annotation.PostConstruct;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WordsService {
    private List<String> worlds;
    @PostConstruct
    private void loadWords() throws IOException {

       worlds=FileUtils.readLines(new File("src/main/resources/wordlist.txt"),"utf-8");

    }
    public String getRandomWorlds(){
        Random random=new Random();

        return worlds.get(random.nextInt(worlds.size()));
    }
}
