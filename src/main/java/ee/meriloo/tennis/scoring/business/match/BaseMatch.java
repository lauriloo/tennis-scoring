package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.player.Player;
import ee.meriloo.tennis.scoring.business.set.AdvantageSet;
import ee.meriloo.tennis.scoring.business.set.Set;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public abstract class BaseMatch implements Match {


    protected final List<Player> players;
    protected List<Set> sets;
    //protected boolean matchHasEnded = false;

    protected int firstPlayerSetsWon;
    protected int secondPlayerSetsWon;
    BaseMatch(List<Player> players) {
        this.players = players;
        this.sets = new ArrayList<Set>();
    }

    public void score(int playerIndex) throws GameException {
        /*if(matchHasEnded()){
            throw new GameException();
        }*/
        if(sets.size() == 0 || sets.get(sets.size()-1).setHasEnded()){
            sets.add(new AdvantageSet());
        }
        sets.get(sets.size()-1).score(playerIndex);
        if(sets.get(sets.size()-1).setHasEnded()){
            incrementMatchScore(sets.get(sets.size()-1).getWinnerIndex());
        }
    }

    public void addNewSet(Set tenniSet) {
        sets.add(tenniSet);
    }

    public void incrementMatchScore(int index) throws GameException {
        if(!matchHasEnded()){
            if(index == 0){
                ++firstPlayerSetsWon;
            } else if(index == 1){
                ++secondPlayerSetsWon;
            } else {
                throw new GameException();
            }

        } else {
            throw new GameException();
        }
    }

    public List<Set> getSets() {
        return sets;
    }


    public int getMatchScore(int index) throws GameException {
        if(index == 0){
            return firstPlayerSetsWon;
        } else if(index == 1){
            return secondPlayerSetsWon;
        } else {
            throw new GameException();
        }
    }

    public int getWinnerIndex() throws GameException {
        if(matchHasEnded()){
            if (firstPlayerSetsWon > secondPlayerSetsWon){
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new GameException();
        }
    }

    /*public List<Player> getPlayers() {
        return players;
    }

    public List<Set> getTennisSets() {
        return sets;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }*/
}
