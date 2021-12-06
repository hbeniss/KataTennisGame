package com.example.HBIKataGame.services;

import com.example.HBIKataGame.entites.Player;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameLogiqImp implements GameLogique{

    private final Map<String, Player> players = new HashMap<>();

    public static List<Integer> POINTS = new ArrayList(Arrays.asList(new Integer[]{0, 15, 30, 40}));


    @Override
    public void addPlayer(Player player) {
        Player newPlayer = player;
        if (players.size()<2) {
            players.put(newPlayer.getName(), newPlayer);
        }
        else
            throw new RuntimeException("Le nombre maximal de joueurs est atteint (2) par jeux");

    }

    @Override
    public Player getPlayerbyName(String playername) {

        return players.get(playername);
    }





    @Override
    public void winGame(Player Player) {

    }


    @Override
    public Player getAdverse(Player player) {

        for(Map.Entry<String,Player> entry : players.entrySet()){
            if (!entry.getKey().equals(player.getName()))
                return entry.getValue();
          //  System.out.println("le score match de l adversaire = "+entry.getValue().getGameScore());
          //  System.out.println("le score set de l adversaire = "+entry.getValue().getSetScore());
        }
        return null;
    }
    @Override
    public void winPointSet(Player player) {
        //System.out.println(player.getName()+" setScore = "+player.getSetScore());

        player.setGameScore(0);
        player.setAvantage(false);
        player.setDuce(false);

        Player adversaire = getAdverse(player);
        adversaire.setGameScore(0);
        adversaire.setAvantage(false);
        adversaire.setDuce(false);

        int currentSetScore = player.getSetScore();

        int  nextSetScore = currentSetScore+1;

        if(currentSetScore == 0){
            player.setSetScore(nextSetScore);
        }
        else if(currentSetScore >0) {
            if (!player.isTieBreak()) {
                if (nextSetScore >= 6 && adversaire.getSetScore() <= 4) {
                    if (adversaire.getSetScore() <= 4) {
                        System.out.println("win the play by 6 and less/equal 4");
                    } else if (currentSetScore >= 6 && adversaire.getSetScore() >= 6) {
                        System.out.println("TieBreak");
                        player.setTieBreak(true);
                        adversaire.setTieBreak(true);
                        player.setSetScore(nextSetScore);
                        if (currentSetScore >= 7 && currentSetScore - adversaire.getSetScore() > 2) {
                            System.out.println("Win2 by TieBreak");
                        }
                    } else if (adversaire.getSetScore() > 4) {
                        System.out.println("hhh----Le set Continue juqua 7 ou TieBreak---hhh");
                        player.setSetScore(nextSetScore);
                    }
                }
                player.setSetScore(nextSetScore);
            }
        }
        System.out.println("Depuis Set Calcule player1 set = "+player.getSetScore());
        System.out.println("Depuis Set Calcule player2 set =  "+adversaire.getSetScore());

    }
    @Override
    public void gagneLePoint(Player player) {
        Player adversaire = getAdverse(player);
        int currentScore = player.getGameScore();
        int newScore = ajouteUnPoint(currentScore);

        if(player.isAvantage() ){
            System.out.println(player.getName()+" Avantage = "+player.isAvantage()+"setScore = "+player.getSetScore());

            winPointSet(player);


        }
        if(!player.isAvantage() ) {
            // player.setGameScore(newScore);
            if (currentScore != 40) {

                player.setGameScore(newScore);
                if ((adversaire.getGameScore() == 40) && (newScore == 40)) {
                    duce(player);
                }
            }
            if ((currentScore == 40)) {
                if (adversaire.getGameScore() < 40) {
                    winPointSet(player);
                } else if (player.isDuce()) {
                    avantage(player);
                } else if (adversaire.getGameScore() == 40 && (adversaire.isAvantage())) {
                    duce(player);
                }
            }

        }
        System.out.println(""+player.toString());
        System.out.println(adversaire.toString());
    }

    public void duce (Player player){
        Player adversaire = getAdverse(player);
        player.setDuce(true);
        adversaire.setDuce(true);
        player.setAvantage(false);
        adversaire.setAvantage(false);
    }
    public void avantage  (Player player){
        Player adversaire = getAdverse(player);
        player.setDuce(false);
        adversaire.setDuce(false);
        player.setAvantage(true);
        adversaire.setAvantage(false);
    }

    @Override
    public int ajouteUnPoint(int curentScore) {
        int index = POINTS.indexOf(curentScore);
        if ( index < POINTS.size()-1 )
            return POINTS.get(index+1);
        return POINTS.get(index);
    }



    @Override
    public Map<String,Player> afficherScores() {

        return players;
    }


}