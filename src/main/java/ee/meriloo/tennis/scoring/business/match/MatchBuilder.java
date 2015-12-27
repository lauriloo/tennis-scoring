package ee.meriloo.tennis.scoring.business.match;

import ee.meriloo.tennis.scoring.business.exceptions.GameException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lauri on 20.12.2015.
 */
public class MatchBuilder {

    private static final int MAX_PLAYERS = 2;
    private static List<Player> players = new LinkedList<Player>();
    private static  PlayType gameType = PlayType.GAME;
    private static  PlayType setType = PlayType.ADVANTAGESET;
    private static  PlayType matchType = PlayType.BESTOFTHREEMATCH;

    public static void addPlayer(Player player) throws GameException {
        if(players.size() < MAX_PLAYERS){
            players.add(player);
        } else {
            throw new GameException();
        }
    }

    public static Match build() throws GameException {
        if (players.size() == MAX_PLAYERS) {
            Match newMatch;

            if (matchType == PlayType.BESTOFTHREEMATCH) {
                newMatch = new TennisMatch(players, 3, gameType, setType, matchType);
                players = new LinkedList<Player>();
                return newMatch;
            } else if (matchType == PlayType.FIVESETSMATCH) {
                newMatch = new TennisMatch(players, 5, gameType, setType, matchType);
                players = new LinkedList<Player>();
                return newMatch;

            }
        }

        throw new GameException();
    }


    public static void setSetType(PlayType setType) {
        MatchBuilder.setType = setType;
    }

    public static void setGameType(PlayType gameType) {
        MatchBuilder.gameType = gameType;
    }

    public static void setMatchType(PlayType matchType) {
        MatchBuilder.matchType = matchType;
    }


}
