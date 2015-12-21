package ee.meriloo.tennis.scoring.output;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.game.Game;
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
        return BaseMatch.getThisMatch().matchHasEnded();
    }

    public String getWinner() throws GameException {
        return BaseMatch.getThisMatch().getWinner();
    }


    private String composeScoreBoardOld(Match match) throws GameException {
        StringBuilder output = new StringBuilder();
        final int nameFieldLength = 35;
        final int scoreFieldLength = 7;
        final int advantageFieldLength = 11;
        final int gamesWonFieldLength = 11;
        final int setsWonFieldLength = 10;

        output.append("| "+StringUtils.center("Name", nameFieldLength));
        output.append("|"+StringUtils.center("Score", scoreFieldLength));
        output.append("|"+StringUtils.center("Advantage", advantageFieldLength));
        output.append("|"+StringUtils.center("Games won", gamesWonFieldLength));
        output.append("|"+StringUtils.center("Sets won", setsWonFieldLength)+"|\n");
        if(match != null){
            String player0 = match.getPlayers().get(0).getName();
            String player1 = match.getPlayers().get(1).getName();
            int score0 = 0;
            int score1 = 0;
            String advantage0 = "";
            String advantage1 = "";
            int gamesWon0 = 0;
            int gamesWon1 = 0;
            int setsWon0 = 0;
            int setsWon1 = 0;
            if(match.getSets().size()>0){
                Set lastSet = match.getSets().get(match.getSets().size()-1);
                if (lastSet.getGames().size()>0){
                    Game lastGame = lastSet.getGames().get(lastSet.getGames().size()-1);
                    score0 = lastGame.getPoints(0);
                    score1 = lastGame.getPoints(1);
                    advantage0 = "";
                    advantage1 = "";
                    gamesWon0 = lastSet.getSetScore(0);
                    gamesWon1 = lastSet.getSetScore(1);
                    setsWon0 = match.getMatchScore(0);
                    setsWon1 = match.getMatchScore(1);
                }
            }

            output.append("| "+StringUtils.rightPad("Player 0 "+player0, nameFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(score0), scoreFieldLength));
            output.append("|"+StringUtils.center(advantage0, advantageFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(gamesWon0), advantageFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(setsWon0), setsWonFieldLength)+"|\n");
            output.append("| "+StringUtils.rightPad("Player 1 "+player1, nameFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(score1), scoreFieldLength));
            output.append("|"+StringUtils.center(advantage0, advantageFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(gamesWon1), advantageFieldLength));
            output.append("|"+StringUtils.center(Integer.toString(setsWon1), setsWonFieldLength)+"|\n");
        }

        return output.toString();
    }

    private String composeScoreBoard(Match match) throws GameException {
        StringBuilder output = new StringBuilder();
        Map<String,String> dataMap = null;

        final int nameFieldLength = 35;
        final int scoreFieldLength = 7;
        final int gamesWonFieldLength = 11;
        final int setsWonFieldLength = 10;

        output.append("| "+StringUtils.center("Name", nameFieldLength));
        output.append("|"+StringUtils.center("Score", scoreFieldLength));
        output.append("|"+StringUtils.center("Games won", gamesWonFieldLength));
        output.append("|"+StringUtils.center("Sets won", setsWonFieldLength)+"|\n");



        if(match != null){
            dataMap = getDisplayData(match);
            /*String player0 = match.getPlayers().get(0).getName();
            String player1 = match.getPlayers().get(1).getName();
            int score0 = 0;
            int score1 = 0;
            //String advantage0 = "";
            //String advantage1 = "";
            int gamesWon0 = 0;
            int gamesWon1 = 0;
            int setsWon0 = 0;
            int setsWon1 = 0;
            if(match.getSets().size()>0){
                Set lastSet = match.getSets().get(match.getSets().size()-1);
                if (lastSet.getGames().size()>0){
                    Game lastGame = lastSet.getGames().get(lastSet.getGames().size()-1);
                    score0 = lastGame.getPoints(0);
                    score1 = lastGame.getPoints(1);
                    //advantage0 = "";
                    //advantage1 = "";
                    gamesWon0 = lastSet.getSetScore(0);
                    gamesWon1 = lastSet.getSetScore(1);
                    setsWon0 = match.getMatchScore(0);
                    setsWon1 = match.getMatchScore(1);
                }
            }*/

            output.append("| "+StringUtils.rightPad("Player 0 "+ dataMap.get(FIRSTPLAYERNAME), nameFieldLength));
            output.append("|"+StringUtils.center(dataMap.get(FIRSTPLAYERSCORE), scoreFieldLength));
            //output.append("|"+StringUtils.center(advantage0, advantageFieldLength));
            output.append("|"+StringUtils.center(dataMap.get(FIRSTPLAYERGAMESWON), gamesWonFieldLength));
            output.append("|"+StringUtils.center(dataMap.get(FIRSTPLAYERSETSWON), setsWonFieldLength)+"|\n");
            output.append("| "+StringUtils.rightPad("Player 1 "+dataMap.get(SECONDPLAYERNAME), nameFieldLength));
            output.append("|"+StringUtils.center(dataMap.get(SECONDPLAYERSCORE), scoreFieldLength));
            //output.append("|"+StringUtils.center(advantage1, advantageFieldLength));
            output.append("|"+StringUtils.center(dataMap.get(SECONDPLAYERGAMESWON), gamesWonFieldLength));
            output.append("|"+StringUtils.center(dataMap.get(SECONDPLAYERSETSWON), setsWonFieldLength)+"|\n");
        }

        return output.toString();
    }

    private Map<String, String> getDisplayData(Match match) throws GameException {

        Map<String,String> dataMap = null;
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
                    firstScore = lastGame.getPoints(0);
                    secondScore = lastGame.getPoints(1);
                    firstPlayerGamesWon = lastSet.getSetScore(0);
                    secondPlayerGamesWon = lastSet.getSetScore(1);
                    firstPlayerSetsWon = match.getMatchScore(0);
                    secondPlayerSetsWon = match.getMatchScore(1);
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
        String score1 = "";
        String score2 = "";
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
            System.out.println("First Score: " + firstScore);
            System.out.println("Second Score: " + secondScore);
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
