package ee.meriloo.tennis.scoring.match;

import ee.meriloo.tennis.scoring.exceptions.GameException;
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
    protected boolean matchHasEnded = false;

    protected int firstPlayerSetsWon;
    protected int secondPlayerSetsWon;
    //protected Game currentGame;

    BaseMatch(List<Player> players) {
        this.players = players;
        this.tennisSets = new ArrayList<TennisSet>();
        //this.currentGame = new TwoPlayerGame();
    }

    public void addNewSet(TennisSet tenniSet) {
        tennisSets.add(tenniSet);
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

    public List<TennisSet> getSets() {
        return tennisSets;
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
