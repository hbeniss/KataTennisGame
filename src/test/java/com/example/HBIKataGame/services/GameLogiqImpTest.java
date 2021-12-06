package com.example.HBIKataGame.services;

import com.example.HBIKataGame.entites.Player;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class GameLogiqImpTest {

    @InjectMocks
    GameLogiqImp gameLogiqImp = new GameLogiqImp();


    @Test
    void getAdverse() {
        Player player1 = new Player();
        player1.setName("hello");
        Player player2 = new Player();
        player2.setName("bb");
        player2.setSetScore(5);
        player1.setSetScore(4);
        gameLogiqImp.addPlayer(player1);
        gameLogiqImp.addPlayer(player2);
System.out.println("From test "+player2.getSetScore());
        assertEquals(gameLogiqImp.getAdverse(player1).getSetScore(),player2.getSetScore());
    }

    @Test
    void duceETavantage() {
        Player player1 = new Player();
        player1.setName("P1");
        Player player2 = new Player();
        player2.setName("P2");


        gameLogiqImp.addPlayer(player1);
        gameLogiqImp.addPlayer(player2);


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


        gameLogiqImp.addPlayer(player1);
        gameLogiqImp.addPlayer(player2);

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
        player1.setGameScore(30);
        player2.setGameScore(15);
        //player1.setTieBreak(true);
        player1.setSetScore(5);
        player2.setSetScore(5);
        gameLogiqImp.addPlayer(player1);
        gameLogiqImp.addPlayer(player2);
        //gameLogiqImp.winPointSet(player2);
        gameLogiqImp.gagneLePoint(player2);
        assertEquals(player2.getSetScore(),5);

//        gameLogiqImp.addPlayer(player1.getName());
//        gameLogiqImp.addPlayer(player2.getName());
       // player1.setGagneLeSet(false);

//       gameLogiqImp.gagneLePoint(player2);
//        System.out.println("from test "+gameLogiqImp.getAdverse(player1).getSetScore());
//       assertEquals(player2.getGameScore(),15);
      //  assertTrue(player1.isGagneLeSet());
        //assertTrue(player1.isTieBreak());
    }
/*
    @Test
    void getAdvSetScore () {
        Player player1 = new Player();
        player1.setName("P1");
        Player player2 = new Player();
        player2.setName("P2");
        player1.setGameScore(40);
        player2.setGameScore(0);
        //player1.setTieBreak(true);
        player1.setSetScore(5);
        player2.setSetScore(5);
        gameLogiqImp.addPlayer(player1);
        gameLogiqImp.addPlayer(player2);

        assertEquals(gameLogiqImp.returnAdverseSet(player1),player2.getSetScore());
    }*/

}