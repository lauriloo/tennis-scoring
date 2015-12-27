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
public class AdvantageSet extends AbstractPlay {

    public static final int MIN_GAMES_TO_WIN = 6;
    public static final int MIN_GAMES_LEADE_TO_WIN = 2;
    private PlayType playType = PlayType.TWOPLAYERGAME;

    public AdvantageSet(){
        this.plays = new ArrayList<Play>();
    }

    public AdvantageSet(List<Play> plays) {
        super();
        this.plays = plays;
    }


    public void score(int playerIndex) throws GameException {
        if(plays.size() == 0 || plays.get(plays.size()-1).hasEnded()){
            plays.add(PlayBuilder.build(playType));
        }
        plays.get(plays.size()-1).score(playerIndex);
        if(plays.get(plays.size()-1).hasEnded()){
            incrementScore(plays.get(plays.size()-1).getWinnerIndex());
        }
    }



    public boolean hasEnded() {
        if (Math.abs((getFirstPlayerScore() - getSecondPlayerScore())) < MIN_GAMES_LEADE_TO_WIN){
            return false;
        } else if (getFirstPlayerScore() >= MIN_GAMES_TO_WIN || getSecondPlayerScore() >= MIN_GAMES_TO_WIN){
            return true;
        }
        return false;
    }


}
