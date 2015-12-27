package ee.meriloo.tennis.scoring.output;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.TennisMatch;
import ee.meriloo.tennis.scoring.business.util.ConsoleScoreBoard;

/**
 * Created by Lauri on 18.12.2015.
 */
public class SimpleDisplayDevice implements DisplayDevice {

    ConsoleScoreBoard consoleScoreBoard = new ConsoleScoreBoard();


    public String getScoreBoard() throws GameException {
        return consoleScoreBoard.formatScoreBoardData(TennisMatch.getThisMatch());
    }

    public boolean isFinished() {
        return TennisMatch.getThisMatch().hasEnded();
    }

    public String getWinner() throws GameException {
        return TennisMatch.getThisMatch().getWinner();
    }





}
