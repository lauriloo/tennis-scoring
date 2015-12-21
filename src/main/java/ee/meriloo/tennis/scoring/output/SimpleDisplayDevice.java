package ee.meriloo.tennis.scoring.output;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.Game;
import ee.meriloo.tennis.scoring.business.match.BaseMatch;
import ee.meriloo.tennis.scoring.business.match.Match;
import ee.meriloo.tennis.scoring.business.set.Set;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by Lauri on 18.12.2015.
 */
public class SimpleDisplayDevice implements DisplayDevice {

    public String getScoreBoard() throws GameException {
        return composeScoreBoard(BaseMatch.getThisMatch());
    }

    public boolean isFinished() {
        return BaseMatch.getThisMatch().matchHasEnded();
    }

    public String getWinner() throws GameException {
        return BaseMatch.getThisMatch().getWinner();
    }


    private String composeScoreBoard(Match match) throws GameException {
        StringBuilder output = new StringBuilder();
        final int nameFieldLength = 35;
        final int scoreFieldLength = 7;
        final int advantageFieldLength = 11;
        final int setsWonFieldLength = 10;

        output.append("| "+StringUtils.center("Name", nameFieldLength));
        output.append("|"+StringUtils.center("Score", scoreFieldLength));
        output.append("|"+StringUtils.center("Advantage", advantageFieldLength));
        output.append("|"+StringUtils.center("Sets won", setsWonFieldLength)+"|\n");
        if(match != null){
            String player0 = match.getPlayers().get(0).getName();
            String player1 = match.getPlayers().get(1).getName();
            int score0 = 0;
            int score1 = 0;
            int advantage0 = 0;
            int advantage1 = 0;
            int setsWon0 = 0;
            int setsWon1 = 0;
            if(match.getSets().size()>0){
                Set lastSet = match.getSets().get(match.getSets().size()-1);
                if (lastSet.getGames().size()>0){
                    Game lastGame = lastSet.getGames().get(lastSet.getGames().size()-1);
                    score0 = lastGame.getPoints(0);
                    score1 = lastGame.getPoints(1);
                    advantage0 = lastSet.getSetScore(0);
                    advantage1 = lastSet.getSetScore(1);
                    setsWon0 = match.getMatchScore(0);
                    setsWon1 = match.getMatchScore(1);
                }
            }

            output.append("| "+StringUtils.rightPad("Player 0 "+player0, nameFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(score0), scoreFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(advantage0), advantageFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(setsWon0), setsWonFieldLength)+"|\n");
            output.append("| "+StringUtils.rightPad("Player 1 "+player1, nameFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(score1), scoreFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(advantage1), advantageFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(setsWon1), setsWonFieldLength)+"|\n");
        }

        return output.toString();
    }

    private List<String> makeEqualLength(List<String> strings){
        System.out.println(StringUtils.center("ab", 4));
        return null;
    }
}
