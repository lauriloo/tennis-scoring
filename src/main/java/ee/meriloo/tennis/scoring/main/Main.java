package ee.meriloo.tennis.scoring.main;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import ee.meriloo.tennis.scoring.input.ControlBoardDevice;
import ee.meriloo.tennis.scoring.input.SimpleControlBoardDevice;

/**
 * Created by Lauri on 18.12.2015.
 */
public class Main {

    public static void main(String[] arg) throws GameException {

        ControlBoardDevice controlBoardDevice = new SimpleControlBoardDevice();
        controlBoardDevice.addPlayer("Mari");
        controlBoardDevice.addPlayer("Jüri");
        try {
            controlBoardDevice.start();
        } catch (GameException e) {
            e.printStackTrace();
        }
        try {
        while(true){
            int tmp = (int) ( Math.random() * 2);
            controlBoardDevice.score(tmp);
        }
        } catch (GameException e) {
            System.out.println("End of Match");
        }
        System.out.println("End of Match, really");

    }
}
