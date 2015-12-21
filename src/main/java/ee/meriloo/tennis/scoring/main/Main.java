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
        controlBoardDevice.addPlayer("Mari");
        controlBoardDevice.addPlayer("Ibrahim Ibrahimovitch");
        System.out.println(displayDevice.getScoreBoard());
        controlBoardDevice.start();
        System.out.println();
        while(!displayDevice.isFinished()){
            int tmp = (int) ( Math.random() * 2);
            controlBoardDevice.score(tmp);
            System.out.println(displayDevice.getScoreBoard());
        }

        System.out.println("End of Match");
        System.out.println();
        System.out.println("Winner is: " + displayDevice.getWinner());

    }
}
