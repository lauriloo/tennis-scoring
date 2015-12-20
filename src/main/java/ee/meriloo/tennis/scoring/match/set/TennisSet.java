package ee.meriloo.tennis.scoring.match.set;

import ee.meriloo.tennis.scoring.exceptions.GameException;
import ee.meriloo.tennis.scoring.match.game.Game;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface TennisSet {

    void addGameScore(Game game);

    void incrementSetScore(int index) throws GameException;

    List<Game> getGames();

    boolean setHasEnded();

    int getSetScore(int index) throws GameException;

    int getWinnerIndex() throws GameException;

}
