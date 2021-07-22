package initializers;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.apache.commons.lang3.time.StopWatch;
import rhythm.*;
import settings.GlobalSettings;
import songs.CustomSongList;
import songs.Song;
import songs.SongList;
import tilesystem.*;

import java.io.File;

public class Initializer {
    // Global app variables
    private int score = 0;
    private static int gold = (3 - GlobalSettings.getDifficulty()) * 10;
    private Text userText;
    private Text scoreText;
    private Text goldText;
    private Text healthText;
    private static int currLevel;
    private static int currFloor;
    private static StopWatch time;
    private static Conductor conductor;

    /*
    ========== INITIALIZER FOR LEVEL 1 ==========
    Initializes the GameScene in the following order:
    - Sets the current level and floor
    - Instantiates a Conductor to be used with a specific bpm and song
    - Sets up the starting score
    - Calls the Level UI Initializer to deal with UI
    - Calls the MapLoader to load the starting room
     */
    public void initStart() {
        FXGL.getGameScene().clearGameViews();
        FXGL.getGameScene().clearUINodes();

        String ostPath = SongList.getSongs()[0].getPath();
        int bpm = SongList.getSongs()[0].getBpm();
        //String ostPath = CustomSongList.getSongs()[0].getPath();
        //int bpm = CustomSongList.getSongs()[0].getBpm();

        currLevel = 1;
        currFloor = 1;
        conductor = new Conductor(bpm, ostPath, score);
        MapDirectory maps = new MapDirectory();
        GlobalSettings.setMapDirectory(maps);

        scoreText = new Text("Level " + Initializer.getCurrLevel() + " / Floor "
            + Initializer.getCurrFloor() + "\n0");
        scoreText.setX(500);
        scoreText.setY(1000);
        scoreText.setScaleX(3);
        scoreText.setScaleY(3);
        scoreText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(scoreText);

        LevelUIInitializer.initLevelUI();

        var cutout = FXGL.getAssetLoader().loadTexture("newCutout.png");

        FXGL.getGameTimer().runOnceAfter(() -> conductor.startAndKeepRhythm(cutout), Duration.millis(3));

        GlobalSettings.generatePath(GlobalSettings.getDifficulty());
        MapLoader.loadMap(0, conductor, scoreText);
        GlobalSettings.setRoomCounter(0);
        GlobalSettings.setPlayerHealth((3 - GlobalSettings.getDifficulty()) * 30);

        GlobalSettings.setMonstersKilled(0);
        time = new StopWatch();
        time.start();

        for (Tile t : GlobalSettings.getCurrentMap().getTiles()) {
            if (t.getType().equals(TileType.MONSTER)) {
                t.removeFromScene();
                t.setTileTexture(FXGL.getAssetLoader().loadTexture("newUnvisitedTile.png"));
                t.displayOnScene();
                conductor.checkRhythm(t, scoreText);
                t.setMonster(null);
            }
        }

        GlobalSettings.clearActiveMonsters();

        if (GlobalSettings.getActiveMonsters().isEmpty()) {
            for (Tile t : GlobalSettings.getCurrentMap().getTiles()) {
                if (t.getType().equals(TileType.LOCKED_EXIT)) {
                    t.removeFromScene();
                    t.setTileTexture(FXGL.getAssetLoader().loadTexture("newStaircase.png"));
                    t.displayOnScene();
                    conductor.checkRhythm(t, scoreText);
                    t.setExit(true);
                }
            }
        }
    }

    public static int getCurrFloor() {
        return currFloor;
    }

    public static int getCurrLevel() {
        return currLevel;
    }

    public static int getGold() {
        return gold;
    }

    public static void setGold(int newGold) {
        gold = newGold;
    }

    public static StopWatch getTime() {
        return time;
    }

    public Conductor getConductor() {
        return conductor;
    }
}
