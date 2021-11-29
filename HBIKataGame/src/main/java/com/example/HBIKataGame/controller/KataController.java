package com.example.HBIKataGame.controller;

import com.example.HBIKataGame.entites.Player;
import com.example.HBIKataGame.services.GameLogique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class KataController {
    @Autowired
    private GameLogique gameLogique;

    @RequestMapping(value ="/addplayer",method = RequestMethod.POST)
    public ResponseEntity<?>  addplayer(@RequestBody String playerName) throws  Exception{
        gameLogique.addPlayer(playerName);
        return ResponseEntity.ok().build();
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
