package com.example.services;

import com.example.models.Game;
import com.example.models.Platform;
import com.example.models.Publisher;
import com.example.utils.CsvUtils;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TesteGameService {

    private static List<Game> gameList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        gameList = CsvUtils.readGameCsv(caminho);
    }

    @Test
    public void testeGamesPS4(){
        List<Game> ps4Games = ServiceGame.getListByPlatform(gameList, Platform.PS4);

        Assert.assertEquals(5,ps4Games.size());
    }

    @Test
    public void testeGamePC(){
        List<Game> PCGames = ServiceGame.getListByPlatform(gameList, Platform.PC);

        Assert.assertEquals(16,PCGames.size());
    }

    @Test
    public void testeGameActivision(){
        List<Game> activisionGames = ServiceGame.getByPuBlisher(gameList, Publisher.Activision);

        Assert.assertEquals(14,activisionGames.size());
    }

    @Test
    public void testeGameSony(){
        List<Game> sonyGames = ServiceGame.getByPuBlisher(gameList, Publisher.SonyComputerEntertainment);

        Assert.assertEquals(6,sonyGames.size());
    }

}