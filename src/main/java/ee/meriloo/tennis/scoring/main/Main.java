package ee.meriloo.tennis.scoring.main;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.business.match.BaseMatch;
import ee.meriloo.tennis.scoring.business.match.Match;
import ee.meriloo.tennis.scoring.input.ControlBoardDevice;
import ee.meriloo.tennis.scoring.input.SimpleControlBoardDevice;
import ee.meriloo.tennis.scoring.output.DisplayDevice;
import ee.meriloo.tennis.scoring.output.SimpleDisplayDevice;

/**
 * Created by Lauri on 18.12.2015.
 */
public class Main {

    public static void main(String[] arg) throws GameException {

        ControlBoardDevice controlBoardDevice = new SimpleControlBoardDevice();
        DisplayDevice displayDevice = new SimpleDisplayDevice();

        // add 2 new players
        controlBoardDevice.addPlayer("Mari");
        controlBoardDevice.addPlayer("Ibrahim Ibrahimovitch");

        // get scoreboard then game is not started
        System.out.println();
        System.out.println("get scoreboard then game is not started:");
        System.out.println();
        System.out.println(displayDevice.getScoreBoard());

        // get scoreboard then game is started
        System.out.println();
        System.out.println("get scoreboard then game is started:");
        System.out.println();
        controlBoardDevice.start();
        System.out.println(displayDevice.getScoreBoard());

        System.out.println();
        // score payers randomly until match is ended
        // after each scoring print out scoreboard
        System.out.println();
        System.out.println("score payers randomly until match is ended");
        System.out.println("after each scoring print out scoreboard:");
        System.out.println();
        while(!displayDevice.isFinished()){
            int tmp = (int) ( Math.random() * 2);
            controlBoardDevice.score(tmp);
            System.out.println(displayDevice.getScoreBoard());
        }

        // match is ended, print out the winner
        System.out.println("match is ended, print out the winner: ");
        System.out.println();
        System.out.println(displayDevice.getWinner());

    }
}
