package initializers;

import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import rhythm.Conductor;
import settings.GlobalSettings;
import tilesystem.Tile;
import tilesystem.TileMap;
import ui.Player;

import java.io.File;
import java.util.ArrayList;

public class Initializer {
    // Global app variables
    int score = 0;
    Text userText;
    Text scoreText;
    Text goldText;
    Text healthText;
    public static int currLevel;
    public static int currFloor;

    public void initLevel1() {
        // Absolute filepath!
        String OSTPath = "." + File.separator
                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";
        currLevel = 1;
        currFloor = 1;
        int bpm = 135;
        Conductor conductor = new Conductor(bpm, OSTPath, score);

        userText = new Text(GlobalSettings.playerName);
        userText.setX(200);
        userText.setY(1000);
        userText.setScaleX(3);
        userText.setScaleY(3);
        userText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(userText);

        scoreText = new Text("Level " + currLevel + " / Floor " + currFloor + "\n0");
        scoreText.setX(500);
        scoreText.setY(1000);
        scoreText.setScaleX(3);
        scoreText.setScaleY(3);
        scoreText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(scoreText);

        goldText = new Text("Gold: \n" + (3 - GlobalSettings.difficulty) * 10);
        goldText.setX(800);
        goldText.setY(1000);
        goldText.setScaleX(3);
        goldText.setScaleY(3);
        goldText.setFill(Color.GOLD);
        FXGL.getGameScene().addUINodes(goldText);

        healthText = new Text("HP: \n" + (3 - GlobalSettings.difficulty) * 30);
        healthText.setX(1000);
        healthText.setY(1000);
        healthText.setScaleX(3);
        healthText.setScaleY(3);
        healthText.setFill(Color.MEDIUMVIOLETRED);
        FXGL.getGameScene().addUINodes(healthText);

        var weaponDisplay = FXGL.getAssetLoader().loadTexture("weapons/weapon"
                + GlobalSettings.startingWeapon + ".png");
        weaponDisplay.setScaleX(3);
        weaponDisplay.setScaleY(3);
        weaponDisplay.setX(1600);
        weaponDisplay.setY(1080 - 90);
        FXGL.getGameScene().addUINode(weaponDisplay);

        var cutout = FXGL.getAssetLoader().loadTexture("cutout.png");

        FXGL.getGameTimer().runOnceAfter(() ->{conductor.startAndKeepRhythm(cutout);}, Duration.millis(1));

        ArrayList<Tile> tiles = new ArrayList<>();

        // x + 30, y + 25
        Tile tile1 = new Tile(FXGL.getAssetLoader().loadTexture("unvisited.png"), new Point2D(405, 435));
        Tile tile2 = new Tile(FXGL.getAssetLoader().loadTexture("player.png"), new Point2D(600, 545));
        Tile exit = new Tile(FXGL.getAssetLoader().loadTexture("stairs.png"), new Point2D(1535, 185));
        tiles.add(tile1);
        tiles.add(tile2);
        tiles.add(exit);


        TileMap tileMap = new TileMap(tiles, conductor, scoreText);

        Player player = new Player(FXGL.getAssetLoader().loadTexture("rhythm-knight.png"), tile2);
    }


}
