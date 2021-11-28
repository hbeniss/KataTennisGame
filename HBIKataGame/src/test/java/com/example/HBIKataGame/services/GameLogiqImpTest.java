package com.example.HBIKataGame.services;

import com.example.HBIKataGame.entites.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class GameLogiqImpTest {

    @Mock
    GameLogiqImp gameLogiqImp = new GameLogiqImp();

    @Test
    void getAdverse() {
        Player player1 = new Player();
        player1.setName("hello");
        Player player2 = new Player();
        player2.setName("bb");
        gameLogiqImp.addPlayer(player1.getName());
        gameLogiqImp.addPlayer(player2.getName());

        assertEquals(this.gameLogiqImp.getAdverse(player1),player2);
    }

    @Test
    void duceETavantage() {
        Player player1 = new Player();
        player1.setName("P1");
        Player player2 = new Player();
        player2.setName("P2");


        gameLogiqImp.addPlayer(player1.getName());
        gameLogiqImp.addPlayer(player2.getName());


        gameLogiqImp.duce(player1);
     //  assertTrue(player2.isDuce());

       gameLogiqImp.avantage(player1);

        assertFalse(player2.isAvantage());
    }

    @Test
    void verifierSetScrore (){
        Player player1 = new Player();
        player1.setName("P1");
        Player player2 = new Player();
        player2.setName("P2");


        gameLogiqImp.addPlayer(player1.getName());
        gameLogiqImp.addPlayer(player2.getName());

player1.setGameScore(30);
player2.setGameScore(40);
        gameLogiqImp.gagneLePoint(player2);
        assertEquals(player2.getSetScore(),1);

    }
    @Test
    void winPoint(){
        Player player1 = new Player();
        player1.setName("P1");
        Player player2 = new Player();
        player2.setName("P2");


        gameLogiqImp.addPlayer(player1.getName());
        gameLogiqImp.addPlayer(player2.getName());

        player1.setGameScore(30);
        player2.setGameScore(40);
gameLogiqImp.gagneLePoint(player1);
        assertEquals(player1.getGameScore(),40);
    }

}