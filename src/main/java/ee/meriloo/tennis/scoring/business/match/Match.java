package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.player.Player;
import ee.meriloo.tennis.scoring.business.set.Set;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Match {

    void score(int playerIndex) throws GameException;

    void incrementMatchScore(int index) throws GameException;

    List<Set> getSets();

    boolean matchHasEnded();

    int getMatchScore(int index) throws GameException;

    String getWinner() throws GameException;

    List<Player> getPlayers();


}
