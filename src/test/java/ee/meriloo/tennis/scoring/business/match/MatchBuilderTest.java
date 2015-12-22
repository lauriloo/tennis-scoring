package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.player.Player;
import ee.meriloo.tennis.scoring.output.DisplayDevice;
import ee.meriloo.tennis.scoring.output.SimpleDisplayDevice;
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

        DisplayDevice displayDevice = new SimpleDisplayDevice();

        MatchBuilder.addPlayer(new Player("AAA"));
        MatchBuilder.addPlayer(new Player("BBB"));
        Match match = MatchBuilder.buildBestOfThreeMatch();
        assertEquals(match.getPlayers().get(0).getName(),"AAA");
        assertEquals(match.getPlayers().get(1).getName(),"BBB");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");


        ///

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(SimpleDisplayDevice.SECONDPLAYERSETSWON),"2");

        //
        assertEquals(match.getWinner(),"BBB");


    }


}