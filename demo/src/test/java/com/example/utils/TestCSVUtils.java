package com.example.utils;

import com.example.models.Game;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestCSVUtils {

    private static List<Game> gameList;


    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        System.out.println(caminho);
        gameList = CsvUtils.readGameCsv(caminho);
    }

    @Test
    public void testNumberOfLines(){
        int numLines = gameList.size();
        Assert.assertEquals(100,numLines);
    }
}