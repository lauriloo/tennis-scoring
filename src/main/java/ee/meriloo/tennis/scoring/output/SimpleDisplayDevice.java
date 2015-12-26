package ee.meriloo.tennis.scoring.output;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.abstractgame.Game;
import ee.meriloo.tennis.scoring.business.match.BaseMatch;
import ee.meriloo.tennis.scoring.business.match.Match;
import ee.meriloo.tennis.scoring.business.set.Set;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lauri on 18.12.2015.
 */
public class SimpleDisplayDevice implements DisplayDevice {

    public static final String ADVANTAGE = "AD";
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
    public static final String SECONDPLAYERNAME = "secondPlayerName";


    public String getScoreBoard() throws GameException {
        return composeScoreBoard(BaseMatch.getThisMatch());
    }

    public boolean isFinished() {
        return BaseMatch.getThisMatch().hasEnded();
    }

    public String getWinner() throws GameException {
        return BaseMatch.getThisMatch().getWinner();
    }


    private String composeScoreBoard(Match match) throws GameException {
        StringBuilder output = new StringBuilder();
        Map<String,String> dataMap;

        final int nameFieldLength = 35;
        final int scoreFieldLength = 7;
        final int gamesWonFieldLength = 11;
        final int setsWonFieldLength = 10;

        output.append(PIPE + SPACE +StringUtils.center(NAME, nameFieldLength));
        output.append(PIPE + StringUtils.center(SCORE, scoreFieldLength));
        output.append(PIPE + StringUtils.center(GAMESWON, gamesWonFieldLength));
        output.append(PIPE + StringUtils.center(SETSWON, setsWonFieldLength)+ PIPE + LINEBREAK);



        if(match != null){
            dataMap = getDisplayData(match);

            output.append(PIPE + SPACE + StringUtils.rightPad(FIRSTPLAYER + SPACE + dataMap.get(FIRSTPLAYERNAME), nameFieldLength));
            output.append(PIPE +StringUtils.center(dataMap.get(FIRSTPLAYERSCORE), scoreFieldLength));
            output.append(PIPE +StringUtils.center(dataMap.get(FIRSTPLAYERGAMESWON), gamesWonFieldLength));
            output.append(PIPE +StringUtils.center(dataMap.get(FIRSTPLAYERSETSWON), setsWonFieldLength)+ PIPE + LINEBREAK);

            output.append(PIPE + SPACE + StringUtils.rightPad(SECONDPLAYER + SPACE + dataMap.get(SECONDPLAYERNAME), nameFieldLength));
            output.append(PIPE + StringUtils.center(dataMap.get(SECONDPLAYERSCORE), scoreFieldLength));
            output.append(PIPE + StringUtils.center(dataMap.get(SECONDPLAYERGAMESWON), gamesWonFieldLength));
            output.append(PIPE + StringUtils.center(dataMap.get(SECONDPLAYERSETSWON), setsWonFieldLength)+ PIPE + LINEBREAK);
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

            if (match.getSets().size() > 0) {
                Set lastSet = match.getSets().get(match.getSets().size() - 1);
                if (lastSet.getGames().size() > 0) {
                    Game lastGame = lastSet.getGames().get(lastSet.getGames().size() - 1);
                    firstScore = lastGame.getScore(0);
                    secondScore = lastGame.getScore(1);
                    //firstPlayerGamesWon = lastSet.getScore(0);
                    //secondPlayerGamesWon = lastSet.getScore(1);
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
        dataMap.put(FIRSTPLAYERGAMESWON, Integer.toString(firstPlayerGamesWon));
        dataMap.put(SECONDPLAYERGAMESWON, Integer.toString(secondPlayerGamesWon));
        dataMap.put(FIRSTPLAYERSETSWON, Integer.toString(firstPlayerSetsWon));
        dataMap.put(SECONDPLAYERSETSWON, Integer.toString(secondPlayerSetsWon));
        dataMap.put(FIRSTPLAYERNAME, firstPlayerName);
        dataMap.put(SECONDPLAYERNAME, secondPlayerName);

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
                score1 = ADVANTAGE;
                score2 = DASH;
            } else {
                score2 = ADVANTAGE;
                score1 = DASH;
            }
        } else if((firstScore >= 4 || secondScore >= 4) && (Math.abs(firstScore - secondScore) >= 2)){
            score1 = "";
            score2 = "";
        } else {
            throw new GameException();
        }

        scores.put(FIRSTPLAYERSCORE, score1);
        scores.put(SECONDPLAYERSCORE, score2);
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
