package initializers;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import rhythm.*;
import settings.GlobalSettings;
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

    /*
    ========== INITIALIZER FOR LEVEL 1 ==========
    Initializes the GameScene in the following order:
    - Sets the current level and floor
    - Instantiates a Conductor to be used with a specific bpm and song
    - Sets up the starting score
    - Calls the Level UI Initializer to deal with UI
    - Calls the MapLoader to load the starting room
     */
    public void initLevel1() {
        // Uncomment the potential filepaths below if music does not play

       //String ostPath = "Project" + File.separator
         //      + "src" + File.separator + "main" + File.separator + "resources" + File.separator
           //    + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";

         String ostPath = "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "assets" + File.separator + "sounds" + File.separator
            + "Diodes.mp3";

        //String ostPath = "." + File.separator + "src" + File.separator + "main" + File.separator
          //  + "resources" + File.separator + "assets" + File.separator + "sounds" + File.separator
            //+ "Diodes.mp3";

        currLevel = 1;
        currFloor = 1;
        int bpm = 135;
        Conductor conductor = new Conductor(bpm, ostPath, score);

        scoreText = new Text("Level " + Initializer.getCurrLevel() + " / Floor " + Initializer.getCurrFloor() + "\n0");
        scoreText.setX(500);
        scoreText.setY(1000);
        scoreText.setScaleX(3);
        scoreText.setScaleY(3);
        scoreText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(scoreText);

        Level_UI_Initializer.initLevelUI();

        var cutout = FXGL.getAssetLoader().loadTexture("newCutout.png");

        FXGL.getGameTimer().runOnceAfter(() -> {
            conductor.startAndKeepRhythm(cutout);
        }, Duration.millis(1));

        GlobalSettings.generatePath(GlobalSettings.getDifficulty());
        MapLoader.loadMap(0, conductor, scoreText);
        GlobalSettings.setRoomCounter(0);
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
}
