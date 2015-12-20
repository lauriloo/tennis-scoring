package ee.meriloo.tennis.scoring.input;

import ee.meriloo.tennis.scoring.exceptions.GameException;
import ee.meriloo.tennis.scoring.match.BestOfThreeMatch;
import ee.meriloo.tennis.scoring.match.MatchBuilder;
import ee.meriloo.tennis.scoring.match.Player;
import ee.meriloo.tennis.scoring.matchcontroller.MatchController;
import ee.meriloo.tennis.scoring.matchcontroller.SimpleMatchController;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Lauri on 20.12.2015.
 */
public class SimpleControlBoardDevice implements ControlBoardDevice {

    private MatchController matchController = new SimpleMatchController();
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
            BestOfThreeMatch match = MatchBuilder.build();
            matchController.setMatch(match);
            canStartNewMach = false;
        } else {
            throw new GameException();
        }
    }

    public void score(int playerIndex) throws GameException {
        matchController.score(playerIndex);
    }


}
