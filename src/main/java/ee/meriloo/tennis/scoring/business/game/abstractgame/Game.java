package ee.meriloo.tennis.scoring.business.game.abstractgame;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Game {

    void score(int playerIndex) throws GameException;

    void incrementScore(int index) throws GameException;

    int getScore(int index) throws GameException;

    boolean hasEnded();

    int getWinnerIndex() throws GameException;


}
