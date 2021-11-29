package com.example.HBIKataGame.services;

import com.example.HBIKataGame.entites.Player;

import java.util.Map;

public interface GameLogique {

    void addPlayer(String playername);
    Player getPlayerbyName(String playername);
    void gagneLePoint(Player player);
    int ajouteUnPoint(int  curentScrore);
    void winPointSet(Player player,Player adversaire);
    void winGame(Player Player);
    Player getAdverse(Player player);
    Map<String,Player> afficherScores();




}
