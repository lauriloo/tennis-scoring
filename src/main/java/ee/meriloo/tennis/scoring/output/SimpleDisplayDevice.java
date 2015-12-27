package ee.meriloo.tennis.scoring.output;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.play.Play;
import ee.meriloo.tennis.scoring.business.match.TennisMatch;
import ee.meriloo.tennis.scoring.business.match.Match;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lauri on 18.12.2015.
 */
public class SimpleDisplayDevice implements DisplayDevice {



    DisplayData displayData = new DisplayData();


    public String getScoreBoard() throws GameException {
        return composeScoreBoard(TennisMatch.getThisMatch());
    }

    public boolean isFinished() {
        return TennisMatch.getThisMatch().hasEnded();
    }

    public String getWinner() throws GameException {
        return TennisMatch.getThisMatch().getWinner();
    }


    private String composeScoreBoard(Match match) throws GameException {
        StringBuilder output = new StringBuilder();
        Map<String,String> dataMap;

        final int nameFieldLength = 35;
        final int scoreFieldLength = 7;
        final int gamesWonFieldLength = 11;
        final int setsWonFieldLength = 10;

        output.append(StringConstants.PIPE + StringConstants.SPACE +StringUtils.center(StringConstants.NAME, nameFieldLength));
        output.append(StringConstants.PIPE + StringUtils.center(StringConstants.SCORE, scoreFieldLength));
        output.append(StringConstants.PIPE + StringUtils.center(StringConstants.GAMESWON, gamesWonFieldLength));
        output.append(StringConstants.PIPE + StringUtils.center(StringConstants.SETSWON, setsWonFieldLength)+ StringConstants.PIPE + StringConstants.LINEBREAK);



        if(match != null){
            dataMap = displayData.getDisplayData(match);

            output.append(StringConstants.PIPE + StringConstants.SPACE + StringUtils.rightPad(StringConstants.FIRSTPLAYER + StringConstants.SPACE + dataMap.get(StringConstants.FIRSTPLAYERNAME), nameFieldLength));
            output.append(StringConstants.PIPE +StringUtils.center(dataMap.get(StringConstants.FIRSTPLAYERSCORE), scoreFieldLength));
            output.append(StringConstants.PIPE +StringUtils.center(dataMap.get(StringConstants.FIRSTPLAYERGAMESWON), gamesWonFieldLength));
            output.append(StringConstants.PIPE +StringUtils.center(dataMap.get(StringConstants.FIRSTPLAYERSETSWON), setsWonFieldLength)+ StringConstants.PIPE + StringConstants.LINEBREAK);

            output.append(StringConstants.PIPE + StringConstants.SPACE + StringUtils.rightPad(StringConstants.SECONDPLAYER + StringConstants.SPACE + dataMap.get(StringConstants.SECONDPLAYERNAME), nameFieldLength));
            output.append(StringConstants.PIPE + StringUtils.center(dataMap.get(StringConstants.SECONDPLAYERSCORE), scoreFieldLength));
            output.append(StringConstants.PIPE + StringUtils.center(dataMap.get(StringConstants.SECONDPLAYERGAMESWON), gamesWonFieldLength));
            output.append(StringConstants.PIPE + StringUtils.center(dataMap.get(StringConstants.SECONDPLAYERSETSWON), setsWonFieldLength)+ StringConstants.PIPE + StringConstants.LINEBREAK);
        }

        return output.toString();
    }



   
}
