import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.time.TimerAction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;


public class GameApp extends GameApplication {

    // Global app variables
    int score = 0;
    Text scoreText;
    private static Media OST;
    private static MediaPlayer songPlayer;
    int currLevel;
    int currFloor;
    Entity map;
    private TimerAction timerAction;

    /*
    ===== GAME WINDOW SETTINGS =====
    Sets the game window settings to default.
    Check GlobalSettings.java for default game settings.
    ================================
     */
    @Override
    protected void initSettings(GameSettings game) {
        game.setWidth(GlobalSettings.windowWidth);
        game.setHeight(GlobalSettings.windowHeight);
        game.setTitle(GlobalSettings.gameTitle);
        game.setVersion(GlobalSettings.version);
        game.setMainMenuEnabled(true);
        game.setSceneFactory(new SceneFactory() {
            @NotNull
            @Override
            public FXGLMenu newMainMenu() {
                return new AppMainMenu(MenuType.MAIN_MENU);
            }
        });
    }

    /*
    ===== GAME INITIALIZATION =====
    This method is called as soon as
    the scene changes to the tutorial level.
    Sound variable 'hit' is defined in the
    class scope because multiple methods use it.
    The game first starts playing the tutorial music and
    loops it starting one beat after it finishes (30 frames = 1 beat for 120 BPM).
    The game also makes instances of the tiles on the tile map and passes them
    into the guideToBeat() method to match the rhythm of the music.
    =================================
     */
    Sound hit;
    @Override
    protected void initGame() {
        String OSTPath = "./Project/src/main/resources/assets/sounds/Diodes.mp3";
        OST = new Media(new File(OSTPath).toURI().toString());
        songPlayer = new MediaPlayer(OST);
        songPlayer.play();
        currLevel = 1;
        currFloor = 1;

        hit = FXGL.getAssetLoader().loadSound("snare01.wav");

        var tile1 = FXGL.getAssetLoader().loadTexture("unvisited.png");
        tile1.setX(665);
        tile1.setY(335);
        tile1.setScaleX(1.35);
        tile1.setScaleY(1.35);
        tile1.setOpacity(1);

        FXGL.getGameScene().addUINodes(tile1);
        guideToBeat(tile1);

        var tile2 = FXGL.getAssetLoader().loadTexture("unvisited.png");
        tile2.setX(857);
        tile2.setY(223);
        tile2.setScaleX(1.35);
        tile2.setScaleY(1.35);
        tile2.setOpacity(1);

        FXGL.getGameScene().addUINodes(tile2);
        guideToBeat(tile2);
    }

    /*
    ===== UI INITIALIZATION =====
    The UI for the game is set up here.
    The tilemap background as well as the player's
    score is stored here in the UI method and is
    also called as soon as the game starts.
    ==============================
     */
    @Override
    protected void initUI() {
        map = new EntityBuilder()
                .view("TutorialTilemap.png")
                .buildAndAttach();

        scoreText = new Text("Level " + currLevel + " / Floor " + currFloor + "\n0");
        scoreText.setX(200);
        scoreText.setY(100);
        scoreText.setScaleX(3);
        scoreText.setScaleY(3);
        scoreText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(scoreText);

        // Display weapon graphic
        try {
            InputStream weaponPath = new FileInputStream("." + File.separator + "Project" + "src"
                    + File.separator + "main" + File.separator + "resources" + File.separator + "assets"
                    + File.separator + "textures" + File.separator + "weapons" + File.separator + "weapon"
                    + GlobalSettings.startingWeapon + ".png");
            Image weaponImg = new Image(weaponPath);
            //Creating the image view
            ImageView weaponImgNode = new ImageView();
            //Setting image to the image view
            weaponImgNode.setImage(weaponImg);
            //Setting the image view parameters
            weaponImgNode.setLayoutX(500);
            weaponImgNode.setLayoutY(500);
            FXGL.getGameScene().addUINode(weaponImgNode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
    ===== GUIDE TO BEAT =====
    guideToBeat() takes a passed in tile and
    guides its shape according to the beat of
    the song.
    It first doubles the scale of the tile and as
    the beat progresses, makes the tile shrink. The
    player is expected to hit the tile as soon as it
    comes in contact with the matching tilemap in order
    to move and get score.
    It measures frames accordingly and determines if the
    player hit the tile at the appropriate time according
    to the beat and assigns a unique score based on frame
    number.
    Remember: 120BPM = 2 beats/sec = 1 beat every .5 seconds
    = 30 frames (60 frames = 1 second)
    ===========================
     */
    public void guideToBeat(Texture tile) {
        var cutout = FXGL.getAssetLoader().loadTexture("cutout.png");
        FXGL.getGameScene().addUINode(cutout);

        int bpm = 135;
        double beats = bpm * (OST.getDuration().toSeconds() / 60);

        // beat, time
        double[] times = new double[(int) beats + 1];

        int i = 1;
        while (i < beats) {
            times[i] = (60.0 / bpm) * i;
            i++;
        }

        AtomicInteger currBeat = new AtomicInteger(1);

        FXGL.getGameTimer().runAtInterval(() -> {
            double currTime = songPlayer.getCurrentTime().toSeconds();
            tile.setOnMouseClicked(mouseEvent -> {});
            if (currTime >= times[currBeat.get()] - .1) {
                currBeat.set(currBeat.get() + 1);
                AtomicInteger scoreConstant = new AtomicInteger(15);
                FXGL.getGameTimer().runAtInterval(() -> {
                    cutoutAnimation(cutout);
                    tile.setOnMouseClicked(mouseEvent -> {
                        score += 10 + scoreConstant.get();
                        scoreText.setText("Level " + currLevel + " / Floor " + currFloor + "\n" + Integer.toString(score));
                        scoreBeat(scoreText);
                        tileAnimation(tile);
                        FXGL.getAudioPlayer().playSound(hit);
                    });
                    scoreConstant.set(scoreConstant.get() - 1);
                }, Duration.millis(1), 15);
            } else {
                cutout.setOpacity(.15);
            }
        }, Duration.seconds(1 / 60.0));
    }

    /*
    ===== SCORE BEAT =====
    The same as guideToBeat() but for the
    score Node.
    Unlike tiles, the score only moves to the
    beat as long as the player hits the tile
    on time. When the player hits the tile
    in time with the beat, the score will
    dynamically update and will also move to the
    beat once.
    ====================
     */
    public void scoreBeat(Text score) {
        score.setScaleX(2);
        score.setScaleY(2);
        AtomicInteger frame = new AtomicInteger(0);

        FXGL.run(() -> {
            frame.addAndGet(1);
            if (frame.get() == 30) {
                score.setScaleX(3);
                score.setScaleY(3);
                frame.set(0);
            }
            score.setScaleX(score.getScaleX() + .03);
            score.setScaleY(score.getScaleY() + .03);
        }, Duration.millis(1), 30);
    }

    public void cutoutAnimation(Texture cutout) {
        cutout.setOpacity(1);
        FXGL.run(() -> {
            cutout.setOpacity(cutout.getOpacity() - 1 / 15.0);
        }, Duration.millis(1), 15);
    }

    public void tileAnimation (Texture tile) {
        FXGL.run(() -> {
            tile.setScaleX(tile.getScaleX() + 1 / 15.0);
            tile.setScaleY(tile.getScaleX() + 1 / 15.0);
            tile.setOpacity(tile.getOpacity() - 1 / 15.0);
        }, Duration.millis(1), 15);
        tile.setScaleX(1.35);
        tile.setScaleY(1.35);
        tile.setOpacity(1);
    }

    // TO BE IMPLEMENTED
    public void move(Texture currentTile, Texture newTile) {
    }



    public static void main(String[] args) {
        launch(args);
    }
}