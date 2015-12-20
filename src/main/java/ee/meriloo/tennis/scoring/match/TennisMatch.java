package ee.meriloo.tennis.scoring.match;

import ee.meriloo.tennis.scoring.exceptions.GameException;
import ee.meriloo.tennis.scoring.match.set.TennisSet;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface TennisMatch {

    void addNewSet(TennisSet tenniSet);

    void incrementMatchScore(int index) throws GameException;

    List<TennisSet> getSets();

    boolean matchHasEnded();

    int getMatchScore(int index) throws GameException;

    int getWinnerIndex() throws GameException;


}
