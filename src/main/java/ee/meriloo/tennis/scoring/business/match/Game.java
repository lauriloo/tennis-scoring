package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.play.AbstractPlay;

/**
 * Created by Lauri on 20.12.2015.
 */
public class Game extends AbstractPlay {

    public static final int MIN_POINTS_TO_WIN = 4;
    public static final int MIN_POINTS_LEADE_TO_WIN = 2;




    public void score(int playerIndex) throws GameException {
        incrementScore(playerIndex);
    }


    public boolean hasEnded() {
        if (Math.abs((getFirstPlayerScore() - getSecondPlayerScore())) < MIN_POINTS_LEADE_TO_WIN){
            return false;
        } else if (getFirstPlayerScore() >= MIN_POINTS_TO_WIN || getSecondPlayerScore() >= MIN_POINTS_TO_WIN){
            return true;
        }
            return false;
    }




}
