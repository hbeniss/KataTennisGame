package com.example.HBIKataGame.services;

import com.example.HBIKataGame.entites.Player;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameLogiqImp implements GameLogique{

    private final Map<String, Player> players = new HashMap<>();

    public static List<Integer> POINTS = new ArrayList(Arrays.asList(new Integer[]{0, 15, 30, 40}));


    @Override
    public void addPlayer(String playerName) {
        Player newPlayer = new Player();
        if (players.size()<2) {
            newPlayer.setGameScore(0);
            newPlayer.setName(playerName);
            newPlayer.setSetScore(0);

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
}
        return null;
    }
    @Override
    public void winPointSet(Player player,Player adversaire) {

        player.setGameScore(0);
        player.setAvantage(false);
        player.setDuce(false);
        adversaire.setGameScore(0);
        adversaire.setAvantage(false);
        adversaire.setDuce(false);

        int currentSetScore = player.getSetScore();
        //Player adversaire = getAdverse(player);

        int  nextSetScore = currentSetScore+1;

        System.out.println("player1  "+player.getSetScore());
        System.out.println("player2  "+adversaire.getSetScore());
if(!player.isTieBreak()) {
    if (nextSetScore >= 6) {
        if (adversaire.getSetScore() <= 4) {
            System.out.println("win 1");
        } else if (currentSetScore >= 6 && adversaire.getSetScore() >= 6) {
            System.out.println("TieBreak");
            player.setTieBreak(true);
            adversaire.setTieBreak(true);
            player.setSetScore(nextSetScore);
            if (currentSetScore >= 7 && currentSetScore - adversaire.getSetScore() > 2) {
                System.out.println("Win2 by TieBreak");
            }
        } else
            System.out.println("hhh-------hhh");
            player.setSetScore(nextSetScore);
            System.out.println("hhh-------hhh");
    }
   player.setSetScore(nextSetScore);
}
    }
    @Override
    public void gagneLePoint(Player player) {
        Player adversaire = getAdverse(player);
        int currentScore = player.getGameScore();
        int newScore = ajouteUnPoint(currentScore);

        if(player.isAvantage() ){
            //System.out.println("player Avantage = "+player.isAvantage());

            winPointSet(player,adversaire);


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
                        winPointSet(player, adversaire);
                    } else if (player.isDuce()) {
                        avantage(player);
                    } else if (adversaire.getGameScore() == 40 && (adversaire.isAvantage())) {
                        duce(player);
                    }
                }

        }

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
