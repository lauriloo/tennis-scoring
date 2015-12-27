package ee.meriloo.tennis.scoring.business.match;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public class BestOfThreeMatch extends BaseMatch {

    private static final int MAX_SETS = 3;
    private static final int MIN_SETS_LEADE_TO_WIN = 2;


    BestOfThreeMatch(List<Player> players) {
        super(players);
    }

    public boolean hasEnded() {
        synchronized(monitor)
        {
            if (Math.abs((getFirstPlayerScore() - getSecondPlayerScore())) == MIN_SETS_LEADE_TO_WIN){
                return true;
            } else if ((getFirstPlayerScore() + getSecondPlayerScore()) == MAX_SETS){
                return true;
            }
            return false;
        }

    }




}
