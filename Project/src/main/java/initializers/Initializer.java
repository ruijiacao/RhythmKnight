package initializers;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import rhythm.Conductor;
import settings.GlobalSettings;
import tilesystem.MapDirectory;
import tilesystem.Tile;
import tilesystem.TileMap;
import tilesystem.TileType;

import java.io.File;
import java.util.ArrayList;

public class Initializer {
    // Global app variables
    private int score = 0;
    private Text userText;
    private Text scoreText;
    private Text goldText;
    private Text healthText;
    private static int currLevel;
    private static int currFloor;

    public void initLevel1() {
        // Uncomment the potential filepaths below if music does not play

        String ostPath = "Project" + File.separator
                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";

        /* String ostPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
            + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";*/

        /*String ostPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";*/

        currLevel = 1;
        currFloor = 1;
        int bpm = 135;
        Conductor conductor = new Conductor(bpm, ostPath, score);

        userText = new Text(GlobalSettings.getPlayerName());
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

        goldText = new Text("Gold: \n" + (3 - GlobalSettings.getDifficulty()) * 10);
        goldText.setX(800);
        goldText.setY(1000);
        goldText.setScaleX(3);
        goldText.setScaleY(3);
        goldText.setFill(Color.GOLD);
        FXGL.getGameScene().addUINodes(goldText);

        healthText = new Text("HP: \n" + (3 - GlobalSettings.getDifficulty()) * 30);
        healthText.setX(1000);
        healthText.setY(1000);
        healthText.setScaleX(3);
        healthText.setScaleY(3);
        healthText.setFill(Color.MEDIUMVIOLETRED);
        FXGL.getGameScene().addUINodes(healthText);

        var weaponDisplay = FXGL.getAssetLoader().loadTexture("weapons/weapon"
                + GlobalSettings.getStartingWeapon() + ".png");
        weaponDisplay.setScaleX(3);
        weaponDisplay.setScaleY(3);
        weaponDisplay.setX(1600);
        weaponDisplay.setY(1080 - 90);
        FXGL.getGameScene().addUINode(weaponDisplay);

        var cutout = FXGL.getAssetLoader().loadTexture("cutout.png");

        FXGL.getGameTimer().runOnceAfter(() -> {
            conductor.startAndKeepRhythm(cutout);
        }, Duration.millis(1));

        MapDirectory maps = new MapDirectory();
        /*
        Texture layoutTexture = FXGL.getAssetLoader().loadTexture("layouts/dungeon/layout4.png");
        Entity layout = new EntityBuilder()
                .view(layoutTexture)
                .buildAndAttach();*/

        TileMap currentMap = new TileMap(maps.getIDLayout(0), conductor, scoreText);

        var playerSprite = FXGL.getAssetLoader().loadTexture("rhythm-knight.png");

        double x = (maps.getMapOrigin(0).getX() - 35);
        double y = (maps.getMapOrigin(0).getY() - 95);
        playerSprite.setX(x);
        playerSprite.setY(y);
        playerSprite.setScaleX(.35);
        playerSprite.setScaleY(.35);
        Entity playerEntity = FXGL.entityBuilder()
            .at(x, y)
            .viewWithBBox(playerSprite)
            .buildAndAttach();
        playerEntity.setScaleX(.35);
        playerEntity.setScaleY(.35);
        getGameWorld().addEntity(playerEntity);
        GameView view = new GameView(playerSprite, 2);
        getGameScene().addGameView(view);
        GlobalSettings.setPlayerSprite(playerSprite);
    }

    public static int getCurrFloor() {
        return currFloor;
    }

    public static int getCurrLevel() {
        return currLevel;
    }

}
