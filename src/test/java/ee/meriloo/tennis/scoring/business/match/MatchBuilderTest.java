package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.util.DisplayData;
import ee.meriloo.tennis.scoring.output.DisplayDevice;
import ee.meriloo.tennis.scoring.output.SimpleDisplayDevice;
import ee.meriloo.tennis.scoring.business.util.StringConstants;
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
        DisplayData displayData = new DisplayData();

        MatchBuilder.addPlayer(new Player("AAA"));
        MatchBuilder.addPlayer(new Player("BBB"));
        Match match = MatchBuilder.build();
        assertEquals(match.getPlayers().get(0).getName(),"AAA");
        assertEquals(match.getPlayers().get(1).getName(),"BBB");

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"AD");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"-");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"-");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"AD");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"0");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");


        ///

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(0);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"AD");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"-");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"-");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"AD");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"1");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"2");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"3");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"4");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"15");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"30");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"40");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"5");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"1");

        match.score(1);
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSCORE),"");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERGAMESWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.FIRSTPLAYERSETSWON),"0");
        assertEquals(displayData.getDisplayData(match).get(StringConstants.SECONDPLAYERSETSWON),"2");

        //
        assertEquals(match.getWinner(),"BBB");


    }


}