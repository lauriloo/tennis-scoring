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
public class TennisMatch extends AbstractPlay implements Match {

    private static Match thisMatch;
    protected final List<Player> players;
    private final int maxSets;

    private final PlayType gameType;
    private final PlayType setType;

    protected static Object monitor = new Object();

    TennisMatch(List<Player> players, int max_sets, PlayType gameType, PlayType setType, PlayType matchType) {
        maxSets = max_sets;
        this.gameType = gameType;
        this.setType = setType;
        this.plays = new ArrayList<Play>();
        this.players = players;
        thisMatch = this;
    }

    public void score(int playerIndex) throws GameException {
        synchronized(monitor)
        {
            if(plays.size() == 0 || plays.get(plays.size()-1).hasEnded()){
                plays.add(PlayBuilder.build(TennisMatch.getThisMatch().getSetType()));
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

    public PlayType getGameType() {
        return gameType;
    }

    public PlayType getSetType() {
        return setType;
    }





    public boolean hasEnded() {
        synchronized(monitor)
        {
            if (Math.abs((getFirstPlayerScore() - getSecondPlayerScore())) > maxSets /2){
                return true;
            } else if ((getFirstPlayerScore() + getSecondPlayerScore()) == maxSets){
                return true;
            } else if ((getFirstPlayerScore() > maxSets /2) || (getSecondPlayerScore() > maxSets /2)){
                return true;
            }
            return false;
        }

    }
}
