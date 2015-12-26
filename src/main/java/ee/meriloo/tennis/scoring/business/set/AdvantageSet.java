package ee.meriloo.tennis.scoring.business.set;


import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.Game;
import ee.meriloo.tennis.scoring.business.game.TwoPlayerGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public class AdvantageSet implements Set {

    public static final int MIN_GAMES_TO_WIN = 6;
    public static final int MIN_GAMES_LEADE_TO_WIN = 2;

    private int firstPlayerSetScore;
    private int secondPlayerSetScore;
    private final List<Game> games;

    public AdvantageSet(){
        this.games = new ArrayList<Game>();
    }


    public void score(int playerIndex) throws GameException {
        if(games.size() == 0 || games.get(games.size()-1).hasEnded()){
            games.add(new TwoPlayerGame());
        }
        games.get(games.size()-1).score(playerIndex);
        if(games.get(games.size()-1).hasEnded()){
            incrementScore(games.get(games.size()-1).getWinnerIndex());
        }
    }

    public void incrementScore(int index) throws GameException {
        if(!hasEnded()){
            if(index == 0){
                ++firstPlayerSetScore;
            } else if(index == 1){
                ++secondPlayerSetScore;
            } else {
                throw new GameException();
            }

        } else {
            throw new GameException();
        }
    }

    public List<Game> getGames() {
        return games;
    }

    public boolean hasEnded() {
        if (Math.abs((firstPlayerSetScore-secondPlayerSetScore)) < MIN_GAMES_LEADE_TO_WIN){
            return false;
        } else if (firstPlayerSetScore >= MIN_GAMES_TO_WIN || secondPlayerSetScore >= MIN_GAMES_TO_WIN){
            return true;
        }
        return false;
    }

    public int getScore(int index) throws GameException {
        if(index == 0){
            return firstPlayerSetScore;
        } else if(index == 1){
            return secondPlayerSetScore;
        } else {
            throw new GameException();
        }
    }

    public int getWinnerIndex() throws GameException {
        if(hasEnded()){
            if (firstPlayerSetScore > secondPlayerSetScore){
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new GameException();
        }
    }


}
