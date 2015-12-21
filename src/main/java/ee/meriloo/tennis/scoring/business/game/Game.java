package ee.meriloo.tennis.scoring.business.game;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Game {

    void score(int playerIndex) throws GameException;

    void incrementMatchScore(int index) throws GameException;

    int getPoints(int index) throws GameException;

    boolean gameHasEnded();

    int getWinnerIndex() throws GameException;


}
