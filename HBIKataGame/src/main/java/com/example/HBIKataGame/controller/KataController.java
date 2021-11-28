package com.example.HBIKataGame.controller;

import com.example.HBIKataGame.entites.Player;
import com.example.HBIKataGame.services.GameLogique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class KataController {
    @Autowired
    private GameLogique gameLogique;

    @RequestMapping({"/addplayer/{playername}"})
    public String addplayer(@PathVariable String playername){
        gameLogique.addPlayer(playername);
        return playername;

    }
    @RequestMapping({"/addpoint/{playername}"})
    public String addPoint(@PathVariable String playername){

        gameLogique.gagneLePoint(gameLogique.getPlayerbyName(playername));
        return "le score est "+gameLogique.getPlayerbyName(playername).getGameScore();
    }

    @RequestMapping({"/getscore"})
            public Map<String,Player> getScore(){

        return gameLogique.afficherScores();
    }
}
