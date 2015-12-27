package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.output.DisplayDevice;
import ee.meriloo.tennis.scoring.output.SimpleDisplayDevice;
import ee.meriloo.tennis.scoring.output.StringConstants;
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
        Match match = MatchBuilder.build();
        assertEquals(match.getPlayers().get(0).getName(),"AAA");
        assertEquals(match.getPlayers().get(1).getName(),"BBB");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");


        ///

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"-");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"AD");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayDevice.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"2");

        //
        assertEquals(match.getWinner(),"BBB");


    }


}