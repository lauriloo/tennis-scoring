package ee.meriloo.tennis.scoring.business.match.play;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Play {

    void score(int playerIndex) throws GameException;

    int getScore(int index) throws GameException;

    boolean hasEnded();

    int getWinnerIndex() throws GameException;

    List<Play> getPlays();


}
