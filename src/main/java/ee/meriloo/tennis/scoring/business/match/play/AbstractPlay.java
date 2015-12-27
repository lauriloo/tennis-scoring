package ee.meriloo.tennis.scoring.business.match.play;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.PlayType;

import java.util.List;

/**
 * Created by Lauri on 26.12.2015.
 */
public abstract class AbstractPlay implements Play {

    private int firstPlayerScore;
    private int secondPlayerScore;
    protected List<Play> plays;
    //private PlayType subPlayType;


    protected void incrementScore(int index) throws GameException {
        if(!hasEnded()){
            if(index == 0){
                ++firstPlayerScore;
            } else if(index == 1){
                ++secondPlayerScore;
            } else {
                throw new GameException();
            }

        } else {
            throw new GameException();
        }
    }

    public int getScore(int index) throws GameException {
        if(index == 0){
            return getFirstPlayerScore();
        } else if(index == 1){
            return getSecondPlayerScore();
        } else {
            throw new GameException();
        }
    }

    protected int getFirstPlayerScore() {
        return firstPlayerScore;
    }

    protected int getSecondPlayerScore() {
        return secondPlayerScore;
    }

    public int getWinnerIndex() throws GameException {
        if(hasEnded()){
            if (getFirstPlayerScore() > getSecondPlayerScore()){
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new GameException();
        }
    }


    public List<Play> getPlays() {
        return plays;
    }

    /*protected PlayType getSubPlayType() {
        return subPlayType;
    }

    protected void setSubPlayType(PlayType subPlayType) {
        this.subPlayType = subPlayType;
    }*/
}
