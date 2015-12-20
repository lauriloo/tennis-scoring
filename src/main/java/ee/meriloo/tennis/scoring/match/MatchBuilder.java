package ee.meriloo.tennis.scoring.match;

import ee.meriloo.tennis.scoring.exceptions.GameException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public class MatchBuilder {

    private static final int MAX_PLAYERS = 2;
    private static List<Player> players = new LinkedList<Player>();

    public static void addPlayer(Player player) throws GameException {
        if(players.size() < MAX_PLAYERS){
            players.add(player);
        } else {
            throw new GameException();
        }
    }

    public static BestOfThreeMatch build() throws GameException {
        if(players.size() == MAX_PLAYERS){
            BestOfThreeMatch newMatch = new BestOfThreeMatch(players);
            players = new LinkedList<Player>();
            return newMatch;
        } else {
            throw new GameException();
        }

    }
}
