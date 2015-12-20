package ee.meriloo.tennis.scoring.match.game;

import ee.meriloo.tennis.scoring.exceptions.GameException;

/**
 * Created by Lauri on 20.12.2015.
 */
public class TwoPlayerGame implements Game {

    public static final int MIN_POINTS_TO_WIN = 4;
    public static final int MIN_POINTS_LEADE_TO_WIN = 2;

    private int firstPlayerPoints;
    private int secondPlayerPoints;


    public void addAPoint(int index) throws GameException {
        if(!gameHasEnded()){
            if(index == 0){
                ++firstPlayerPoints;
            } else if(index == 1){
                ++secondPlayerPoints;
            } else {
                throw new GameException();
            }

        } else {
            throw new GameException();
        }
    }

    public boolean gameHasEnded() {
        if (Math.abs((firstPlayerPoints-secondPlayerPoints)) < MIN_POINTS_LEADE_TO_WIN){
            return false;
        } else if (firstPlayerPoints >= MIN_POINTS_TO_WIN || secondPlayerPoints >= MIN_POINTS_TO_WIN){
            return true;
        }
            return false;
    }

    public int getPoints(int index) throws GameException {
        if(index == 0){
            return firstPlayerPoints;
        } else if(index == 1){
            return secondPlayerPoints;
        } else {
            throw new GameException();
        }
    }

    public int getWinnerIndex() throws GameException {
        if(gameHasEnded()){
            if (firstPlayerPoints > secondPlayerPoints){
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new GameException();
        }
    }

    /*public static void main(String[] args){
        Game gameScore = new TwoPlayerGame();
        try {
            System.out.println("First palyer score: "+gameScore.getPoints(0));
        } catch (GameException e) {
            e.printStackTrace();
        }
    }*/
}
