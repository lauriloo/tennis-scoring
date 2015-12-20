package ee.meriloo.tennis.scoring.match.set;


import ee.meriloo.tennis.scoring.exceptions.GameException;
import ee.meriloo.tennis.scoring.match.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public class AdvantageSet implements TennisSet {

    public static final int MIN_GAMES_TO_WIN = 6;
    public static final int MIN_GAMES_LEADE_TO_WIN = 2;

    private int firstPlayerSetScore;
    private int secondPlayerSetScore;
    private final List<Game> games;

    public AdvantageSet(){
        this.games = new ArrayList<Game>();
    }


    public void addGameScore(Game game) {
        games.add(game);
    }

    public void incrementSetScore(int index) throws GameException {
        if(!setHasEnded()){
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

    public boolean setHasEnded() {
        if (Math.abs((firstPlayerSetScore-secondPlayerSetScore)) < MIN_GAMES_LEADE_TO_WIN){
            return false;
        } else if (firstPlayerSetScore >= MIN_GAMES_TO_WIN || secondPlayerSetScore >= MIN_GAMES_TO_WIN){
            return true;
        }
        return false;
    }

    public int getSetScore(int index) throws GameException {
        if(index == 0){
            return firstPlayerSetScore;
        } else if(index == 1){
            return secondPlayerSetScore;
        } else {
            throw new GameException();
        }
    }

    public int getWinnerIndex() throws GameException {
        if(setHasEnded()){
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
