package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.play.AbstractPlay;
import ee.meriloo.tennis.scoring.business.match.play.Play;
import ee.meriloo.tennis.scoring.business.match.play.PlayBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public abstract class BaseMatch extends AbstractPlay implements Match {

    private static Match thisMatch;
    protected final List<Player> players;
    private final PlayType gameType;
    private final PlayType setType;
    private final PlayType matchType;
    protected static Object monitor = new Object();

    BaseMatch(List<Player> players, PlayType gameType, PlayType setType, PlayType matchType) {
        this.gameType = gameType;
        this.setType = setType;
        this.matchType = matchType;
        this.plays = new ArrayList<Play>();
        this.players = players;
        thisMatch = this;
        this.setSubPlayType(PlayType.ADVANTAGESET);
    }

    BaseMatch(List<Player> players, List<Play> plays, PlayType gameType, PlayType setType, PlayType matchType) {
        this.gameType = gameType;
        this.setType = setType;
        this.matchType = matchType;
        this.plays = plays;
        this.players = players;
        thisMatch = this;
        this.setSubPlayType(PlayType.ADVANTAGESET);
    }

    public void score(int playerIndex) throws GameException {
        synchronized(monitor)
        {
            if(plays.size() == 0 || plays.get(plays.size()-1).hasEnded()){
                plays.add(PlayBuilder.build(getSubPlayType()));
            }
            plays.get(plays.size()-1).score(playerIndex);
            if(plays.get(plays.size()-1).hasEnded()){
                incrementScore(plays.get(plays.size()-1).getWinnerIndex());
            }
        }
    }

    public void incrementScore(int index) throws GameException {
        synchronized(monitor)
        {
            super.incrementScore(index);
        }

    }

    public List<Play> getPlays() {
        synchronized(monitor)
        {
            return super.getPlays();
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
