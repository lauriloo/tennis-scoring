package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.player.Player;

import java.util.List;

/**
 * Created by Lauri on 21.12.2015.
 */
public class FiveSetsMatch extends BaseMatch {

    private static final int MIN_SETS_TO_WIN = 3;


    FiveSetsMatch(List<Player> players) {
        super(players);
    }

    public boolean matchHasEnded() {
        if (firstPlayerSetsWon == MIN_SETS_TO_WIN || secondPlayerSetsWon == MIN_SETS_TO_WIN ){
            return true;
        } else {
            return false;
        }
    }
}
