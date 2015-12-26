package ee.meriloo.tennis.scoring.business.set;

import ee.meriloo.tennis.scoring.business.game.abstractgame.Game;

import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public interface Set extends Game {

    List<Game> getGames();

}
