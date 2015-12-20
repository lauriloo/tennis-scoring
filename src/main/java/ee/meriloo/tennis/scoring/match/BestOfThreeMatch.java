package ee.meriloo.tennis.scoring.match;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public class BestOfThreeMatch extends BaseMatch {

    public static final int MIN_SETS_TO_WIN = 3;
    public static final int MIN_SETS_LEADE_TO_WIN = 2;


    BestOfThreeMatch(List<Player> players) {
        super(players);
    }

    public boolean matchHasEnded() {
        if (Math.abs((firstPlayerSetsWon-secondPlayerSetsWon)) < MIN_SETS_LEADE_TO_WIN){
            return false;
        } else if (firstPlayerSetsWon >= MIN_SETS_TO_WIN || secondPlayerSetsWon >= MIN_SETS_TO_WIN){
            return true;
        }
        return false;
    }
}
