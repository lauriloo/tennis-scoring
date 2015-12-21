package ee.meriloo.tennis.scoring.business.set;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.Game;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Set {

    void score(int playerIndex) throws GameException;

    void addGameScore(Game game);

    void incrementSetScore(int index) throws GameException;

    List<Game> getGames();

    boolean setHasEnded();

    int getSetScore(int index) throws GameException;

    int getWinnerIndex() throws GameException;

}
