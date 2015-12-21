package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.player.Player;

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

    public boolean matchHasEnded() {
        if (Math.abs((firstPlayerSetsWon-secondPlayerSetsWon)) == MIN_SETS_LEADE_TO_WIN){
            return true;
        } else if ((firstPlayerSetsWon + secondPlayerSetsWon) == MAX_SETS){
            return true;
        }
        return false;
    }

        /*if (Math.abs((firstPlayerSetsWon-secondPlayerSetsWon)) < MIN_SETS_LEADE_TO_WIN){
            return false;
        } else if (firstPlayerSetsWon >= MIN_SETS_TO_WIN || secondPlayerSetsWon >= MIN_SETS_TO_WIN){
            return true;
        }
        return false;
    }*/
}
