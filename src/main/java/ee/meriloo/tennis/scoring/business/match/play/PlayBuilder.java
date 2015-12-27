package ee.meriloo.tennis.scoring.business.match.play;

import ee.meriloo.tennis.scoring.business.match.AdvantageSet;
import ee.meriloo.tennis.scoring.business.match.PlayType;
import ee.meriloo.tennis.scoring.business.match.Game;

/**
 * Created by Lauri on 27.12.2015.
 */
public class PlayBuilder {


    public static Play build(PlayType playType){
        if(playType == PlayType.ADVANTAGESET){
            return new AdvantageSet();
        } else if(playType == PlayType.GAME){
            return  new Game();
        } else {
            return null;
        }
    }
}
