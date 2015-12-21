package ee.meriloo.tennis.scoring.input;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Lauri on 21.12.2015.
 */
public class SimpleControlBoardDeviceTest {

    ControlBoardDevice controlBoardDevice;


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testAddPlayer_add3Players_exceptionIsThrown() throws Exception {
        controlBoardDevice = new SimpleControlBoardDevice();
        controlBoardDevice.addPlayer("aaa");
        controlBoardDevice.addPlayer("bbb");
        exception.expect(GameException.class);
        controlBoardDevice.addPlayer("ccc");

    }

    @Test
    public void testAddPlayer_addPlayerWithNoName_exceptionIsThrown() throws Exception {
        controlBoardDevice = new SimpleControlBoardDevice();
        exception.expect(GameException.class);
        controlBoardDevice.addPlayer("sdf");
    }

    @Test
    public void testStart_add2PlayersAndStart_exceptionIsNotThrown() throws Exception {
        controlBoardDevice = new SimpleControlBoardDevice();
        controlBoardDevice.addPlayer("aaa");
        controlBoardDevice.addPlayer("bbb");
        controlBoardDevice.start();
    }



    @Test
    public void testScore() throws Exception {

    }

}