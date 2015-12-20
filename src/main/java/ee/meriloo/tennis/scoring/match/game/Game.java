package ee.meriloo.tennis.scoring.match.game;

import ee.meriloo.tennis.scoring.exceptions.GameException;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Game {

    public void addAPoint(int index) throws GameException;

    public int getPoints(int index) throws GameException;

    public boolean gameHasEnded();

    public int getWinnerIndex() throws GameException;


}
