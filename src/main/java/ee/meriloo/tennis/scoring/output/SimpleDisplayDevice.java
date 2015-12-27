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

    /*public static final String ADVANTAGE = "AD";
    public static final String DASH = "-";
    public static final String SPACE = " ";
    public static final String PIPE = "|";
    public static final String LINEBREAK = "\n";
    public static final String NAME = "Name";
    public static final String SCORE = "Score";
    public static final String GAMESWON = "Games won";
    public static final String SETSWON = "Sets won";
    public static final String FIRSTPLAYER = "Player 0";
    public static final String SECONDPLAYER = "Player 1";
    public static final String FIRSTPLAYERSCORE = "firstPlayerScore";
    public static final String SECONDPLAYERSCORE = "secondPlayerScore";
    public static final String FIRSTPLAYERGAMESWON = "firstPlayerGamesWon";
    public static final String SECONDPLAYERGAMESWON = "secondPlayerGamesWon";
    public static final String FIRSTPLAYERSETSWON = "firstPlayerSetsWon";
    public static final String SECONDPLAYERSETSWON = "secondPlayerSetsWon";
    public static final String FIRSTPLAYERNAME = "firstPlayerName";
    public static final String SECONDPLAYERNAME = "secondPlayerName";*/


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
            dataMap = getDisplayData(match);

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



    public Map<String, String> getDisplayData(Match match) throws GameException {

        Map<String,String> dataMap;
        int firstScore = 0;
        int secondScore = 0;
        int firstPlayerGamesWon = 0;
        int secondPlayerGamesWon = 0;
        int firstPlayerSetsWon = 0;
        int secondPlayerSetsWon = 0;
        String firstPlayerName = null;
        String secondPlayerName = null;

        if(match != null) {
            firstPlayerName = match.getPlayers().get(0).getName();
            secondPlayerName = match.getPlayers().get(1).getName();

            if (match.getPlays().size() > 0) {
                Play lastSet = match.getPlays().get(match.getPlays().size() - 1);
                if (lastSet.getPlays().size() > 0) {
                    Play lastGame = lastSet.getPlays().get(lastSet.getPlays().size() - 1);
                    firstScore = lastGame.getScore(0);
                    secondScore = lastGame.getScore(1);
                    if(lastSet.hasEnded()){
                        firstPlayerGamesWon = 0;
                        secondPlayerGamesWon = 0;
                    } else {
                        firstPlayerGamesWon = lastSet.getScore(0);
                        secondPlayerGamesWon = lastSet.getScore(1);
                    }
                    firstPlayerSetsWon = match.getScore(0);
                    secondPlayerSetsWon = match.getScore(1);
                }
            }
        }

        dataMap = scoreCoverter(firstScore,secondScore);
        dataMap.put(StringConstants.FIRSTPLAYERGAMESWON, Integer.toString(firstPlayerGamesWon));
        dataMap.put(StringConstants.SECONDPLAYERGAMESWON, Integer.toString(secondPlayerGamesWon));
        dataMap.put(StringConstants.FIRSTPLAYERSETSWON, Integer.toString(firstPlayerSetsWon));
        dataMap.put(StringConstants.SECONDPLAYERSETSWON, Integer.toString(secondPlayerSetsWon));
        dataMap.put(StringConstants.FIRSTPLAYERNAME, firstPlayerName);
        dataMap.put(StringConstants.SECONDPLAYERNAME, secondPlayerName);

        return dataMap;
    }

    private Map<String, String> scoreCoverter(int firstScore, int secondScore) throws GameException {
        String score1;
        String score2;
        Map<String,String> scores = new HashMap<String, String>();

        if(firstScore < 4 && secondScore < 4){
            score1 = scoreBasicConvert(firstScore);
            score2 = scoreBasicConvert(secondScore);
        } else if((firstScore >= 4 && secondScore >= 4) && (firstScore == secondScore) ){
            score1 = scoreBasicConvert(3);
            score2 = scoreBasicConvert(3);
        } else if((firstScore >= 4 || secondScore >= 4) && (Math.abs(firstScore - secondScore) == 1)){
            if(firstScore > secondScore){
                score1 = StringConstants.ADVANTAGE;
                score2 = StringConstants.DASH;
            } else {
                score2 = StringConstants.ADVANTAGE;
                score1 = StringConstants.DASH;
            }
        } else if((firstScore >= 4 || secondScore >= 4) && (Math.abs(firstScore - secondScore) >= 2)){
            score1 = "";
            score2 = "";
        } else {
            throw new GameException();
        }

        scores.put(StringConstants.FIRSTPLAYERSCORE, score1);
        scores.put(StringConstants.SECONDPLAYERSCORE, score2);
        return scores;
    }

    private String scoreBasicConvert(int score){
        if(score == 0){
            return "0";
        } else if(score == 1){
            return "15";
        } else if(score == 2){
            return "30";
        } else {
            return "40";
        }
    }
}
