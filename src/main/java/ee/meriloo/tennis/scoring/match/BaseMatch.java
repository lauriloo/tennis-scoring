package ee.meriloo.tennis.scoring.match;

import ee.meriloo.tennis.scoring.match.game.Game;
import ee.meriloo.tennis.scoring.match.game.TwoPlayerGame;
import ee.meriloo.tennis.scoring.match.set.TennisSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public abstract class BaseMatch implements TennisMatch {

    protected final List<Player> players;
    protected List<TennisSet> tennisSets;
    protected boolean finished = false;
    protected Game currentGame;

    BaseMatch(List<Player> players) {
        this.players = players;
        this.tennisSets = new ArrayList<TennisSet>();
        this.currentGame = new TwoPlayerGame();
    }


    /*public List<Player> getPlayers() {
        return players;
    }

    public List<TennisSet> getTennisSets() {
        return tennisSets;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }*/
}
