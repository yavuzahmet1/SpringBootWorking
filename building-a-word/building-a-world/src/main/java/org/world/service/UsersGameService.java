package org.world.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.world.model.Game;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.UUID.randomUUID;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Scope(value = SCOPE_SINGLETON)
@Service
public class UsersGameService {
    ConcurrentHashMap<String, Object> userGames=new ConcurrentHashMap<>();

    public String addGameToDataStore(String word){
        String userKey=randomUUID().toString();
        userGames.put(userKey,new Game(word,0));

        return userKey;
    }
}
