package ee.meriloo.tennis.scoring.business.set;


import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.abstractgame.AbstractGame;
import ee.meriloo.tennis.scoring.business.game.abstractgame.Game;
import ee.meriloo.tennis.scoring.business.game.TwoPlayerGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public class AdvantageSet extends AbstractGame implements Set {

    public static final int MIN_GAMES_TO_WIN = 6;
    public static final int MIN_GAMES_LEADE_TO_WIN = 2;

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


    public List<Game> getGames() {
        return games;
    }

    public boolean hasEnded() {
        if (Math.abs((getFirstPlayerScore() - getSecondPlayerScore())) < MIN_GAMES_LEADE_TO_WIN){
            return false;
        } else if (getFirstPlayerScore() >= MIN_GAMES_TO_WIN || getSecondPlayerScore() >= MIN_GAMES_TO_WIN){
            return true;
        }
        return false;
    }


}
