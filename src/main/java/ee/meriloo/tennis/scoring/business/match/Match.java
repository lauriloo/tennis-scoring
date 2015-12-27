package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.play.Play;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Match extends Play {


    String getWinner() throws GameException;

    List<Player> getPlayers();

    PlayType getGameType();

    PlayType getSetType();

    PlayType getMatchType();



}
