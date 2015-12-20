package ee.meriloo.tennis.scoring.match;

import ee.meriloo.tennis.scoring.match.set.TennisSet;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface TennisMatch {

    void addNewSet(TennisSet tenniSet);

    //void incrementSetScore(int index) throws GameException;

    //List<Game> getGames();

    //boolean setHasEnded();

    //int getSetScore(int index) throws GameException;

    //int getWinnerIndex() throws GameException;
}
