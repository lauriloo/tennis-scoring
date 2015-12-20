package ee.meriloo.tennis.scoring.matchcontroller;

import ee.meriloo.tennis.scoring.exceptions.GameException;
import ee.meriloo.tennis.scoring.match.BestOfThreeMatch;
import ee.meriloo.tennis.scoring.match.game.Game;

/**
 * Created by Lauri on 20.12.2015.
 */
public class SimpleMatchController implements MatchController {

    private BestOfThreeMatch match;
    private Game currentGame;
    //private GameScoreBuilder gameScoreBuilder = new TwoPlayerGameScoreBuilder(); // Autowired - TwoPlayerGameScoreBuilder

    public void score(int playerIndex) throws GameException {

    }

    public void newGame(){
        //this.currentGame = gameScoreBuilder.getGameScore();
    }

    public void newSet(){

    }




    public void setMatch(BestOfThreeMatch match) {
        this.match = match;
    }

}
