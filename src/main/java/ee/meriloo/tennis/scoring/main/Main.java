package ee.meriloo.tennis.scoring.main;

import ee.meriloo.tennis.scoring.input.ControlBoardDevice;
import ee.meriloo.tennis.scoring.input.SimpleControlBoardDevice;
import ee.meriloo.tennis.scoring.match.Player;
import ee.meriloo.tennis.scoring.trash.PlayerPoint;

/**
 * Created by Lauri on 18.12.2015.
 */
public class Main {

    public static void main(String[] arg){

        ControlBoardDevice controlBoardDevice = new SimpleControlBoardDevice();
        /*try {
            controlBoardDevice.addPlayer("Lauri");
            controlBoardDevice.addPlayer("Raul");
            //controlBoardDevice.addPlayer("uhhuu");
            controlBoardDevice.start();
            //controlBoardDevice.start();
        } catch (GameException e) {
            e.printStackTrace();
        }*/
        PlayerPoint playerPoints = new PlayerPoint(new Player("Aivar"));
        System.out.println(playerPoints.getPlayer().getName()+" on algselt punkte: " + playerPoints.getPoints());
        playerPoints.addPoint();
        System.out.println(playerPoints.getPlayer().getName()+" on nüüd punkte: " + playerPoints.getPoints());
    }
}
