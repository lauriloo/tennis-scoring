package ee.meriloo.tennis.scoring.matchcontroller;

import ee.meriloo.tennis.scoring.exceptions.GameException;
import ee.meriloo.tennis.scoring.match.BestOfThreeMatch;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface MatchController {

    // ControlBoardDevice

    void setMatch(BestOfThreeMatch match);

    void score(int playerIndex) throws GameException;

    //

}
