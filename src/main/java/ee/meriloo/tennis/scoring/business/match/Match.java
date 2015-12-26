package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.Game;
import ee.meriloo.tennis.scoring.business.player.Player;
import ee.meriloo.tennis.scoring.business.set.Set;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Match extends Game {
    

    String getWinner() throws GameException;

    List<Player> getPlayers();

    List<Set> getSets();


}
