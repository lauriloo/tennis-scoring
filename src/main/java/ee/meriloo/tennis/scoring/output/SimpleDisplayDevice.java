package ee.meriloo.tennis.scoring.output;

/**
 * Created by Lauri on 18.12.2015.
 */
public class SimpleDisplayDevice implements DisplayDevice {

    @Override
    public String getScoreBoard() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String getWinner() {
        return null;
    }
}
