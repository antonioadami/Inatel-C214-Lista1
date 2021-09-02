package com.example.services;

import com.example.models.Game;
import com.example.models.Platform;
import com.example.models.Publisher;

import java.util.ArrayList;
import java.util.List;

public class ServiceGame {

    public static List<Game> getListByPlatform(List<Game> games, Platform platform){
        List<Game> gamesByPlatform = new ArrayList<>();

        games.stream().filter((game ->
            game.getPlatform().equals(platform.name()))).
            forEach(game -> gamesByPlatform.add(game));

        return gamesByPlatform;

    }


    public static List<Game> getByPuBlisher(List<Game> games , Publisher publisher){
        List<Game> gamesByPublisher = new ArrayList<>();

        games.stream().filter((game ->
            game.getPublisher().replaceAll("\\s+", "").equals(publisher.name()))).
            forEach(game -> gamesByPublisher.add(game));

        return gamesByPublisher;
    }

}