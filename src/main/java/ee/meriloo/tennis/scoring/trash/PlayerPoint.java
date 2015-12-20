package ee.meriloo.tennis.scoring.trash;

import ee.meriloo.tennis.scoring.match.Player;

/**
 * Created by Lauri on 19.12.2015.
 */
public class PlayerPoint {

    private final Player player;
    private int points;

    public PlayerPoint(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint(){
        ++points;
    }
}
