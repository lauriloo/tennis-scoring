package ee.meriloo.tennis.scoring.input;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.Match;
import ee.meriloo.tennis.scoring.business.match.MatchBuilder;
import ee.meriloo.tennis.scoring.business.player.Player;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Lauri on 20.12.2015.
 */
public class SimpleControlBoardDevice implements ControlBoardDevice {

    private Match match;
    private boolean canStartNewMach = true;


    public void addPlayer(String name) throws GameException {
        if(canStartNewMach || StringUtils.isNotEmpty(name)){
            MatchBuilder.addPlayer(new Player(name));
        } else {
            throw new GameException();
        }
    }

    public void start() throws GameException {
        if(canStartNewMach){
            this.match = MatchBuilder.build();
            canStartNewMach = false;
        } else {
            throw new GameException();
        }
    }

    public void score(int playerIndex) throws GameException {
        if(match.matchHasEnded()){
            throw new GameException();
        }
        match.score(playerIndex);
    }


}
