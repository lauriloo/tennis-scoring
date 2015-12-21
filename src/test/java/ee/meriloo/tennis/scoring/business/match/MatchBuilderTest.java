package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lauri on 22.12.2015.
 */
public class MatchBuilderTest {

    @Test
    public void testAddPlayer() throws Exception {

    }

    @Test
    public void testBuildBestOfThreeMatch() throws Exception {
        MatchBuilder.addPlayer(new Player("AAA"));
        MatchBuilder.addPlayer(new Player("BBB"));
        Match match = MatchBuilder.buildBestOfThreeMatch();

        assertEquals(match.getPlayers().get(0).getName(),"AAA");
        assertEquals(match.getPlayers().get(1).getName(),"BBB");


    }

    @Test
    public void testBuildFiveSetsMatch() throws Exception {

    }
}