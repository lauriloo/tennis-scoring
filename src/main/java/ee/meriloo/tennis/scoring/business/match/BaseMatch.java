package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.abstractgame.AbstractGame;
import ee.meriloo.tennis.scoring.business.player.Player;
import ee.meriloo.tennis.scoring.business.set.AdvantageSet;
import ee.meriloo.tennis.scoring.business.set.Set;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public abstract class BaseMatch extends AbstractGame implements Match {

    private static Match thisMatch;

    protected final List<Player> players;
    protected List<Set> sets;

    protected static Object monitor = new Object();
    BaseMatch(List<Player> players) {
        this.players = players;
        this.sets = new ArrayList<Set>();
        thisMatch = this;
    }

    public void score(int playerIndex) throws GameException {
        synchronized(monitor)
        {
            if(sets.size() == 0 || sets.get(sets.size()-1).hasEnded()){
                sets.add(new AdvantageSet());
            }
            sets.get(sets.size()-1).score(playerIndex);
            if(sets.get(sets.size()-1).hasEnded()){
                incrementScore(sets.get(sets.size()-1).getWinnerIndex());
            }
        }
    }

    public void incrementScore(int index) throws GameException {
        synchronized(monitor)
        {
            super.incrementScore(index);
        }

    }

    public List<Set> getSets() {
        synchronized(monitor)
        {
            return sets;
        }
    }


    public int getScore(int index) throws GameException {
        synchronized(monitor)
        {
            return super.getScore(index);
        }

    }

    public int getWinnerIndex() throws GameException {
        synchronized(monitor)
        {
            return super.getWinnerIndex();
        }
    }

    public String getWinner() throws GameException {
        synchronized(monitor)
        {
            return getPlayers().get(getWinnerIndex()).getName();
        }

    }

    public static Match getThisMatch() {
        synchronized(monitor)
        {
            return thisMatch;
        }
    }

    public static void resetMatch(){
        synchronized(monitor)
        {
            thisMatch = null;
        }
    }

    public List<Player> getPlayers() {
        synchronized(monitor)
        {
            return players;
        }
    }


}
