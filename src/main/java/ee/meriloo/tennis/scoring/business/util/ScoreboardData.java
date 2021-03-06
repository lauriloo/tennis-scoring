package ee.meriloo.tennis.scoring.business.util;

import ee.meriloo.tennis.scoring.business.util.StringConstants;
import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.Match;
import ee.meriloo.tennis.scoring.business.match.play.Play;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lauri on 27.12.2015.
 */
public class ScoreboardData {

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
            return StringConstants.ZERO;
        } else if(score == 1){
            return StringConstants.FIFTEEN;
        } else if(score == 2){
            return StringConstants.THIRTY;
        } else {
            return StringConstants.FORTY;
        }
    }
}
