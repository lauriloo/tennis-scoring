package ee.meriloo.tennis.scoring.business.match;

import java.util.List;

/**
 * Created by Lauri on 21.12.2015.
 */
public class FiveSetsMatch extends BaseMatch {

    private static final int MIN_SETS_TO_WIN = 3;


    FiveSetsMatch(List<Player> players) {
        super(players);
    }

    public boolean hasEnded() {
        synchronized(monitor)
        {
            if (getFirstPlayerScore() == MIN_SETS_TO_WIN || getSecondPlayerScore() == MIN_SETS_TO_WIN ){
                return true;
            } else {
                return false;
            }
        }

    }
}
