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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.atomic.AtomicInteger;


public class GameApp extends GameApplication {

    // Global app variables
    boolean tileActive = false;
    int score = 0;
    Text scoreText;

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
        Sound OST = FXGL.getAssetLoader().loadSound("Tutorial.wav");
        FXGL.getAudioPlayer().playSound(OST);
        FXGL.run(() -> {
            FXGL.getAudioPlayer().playSound(OST);
        }, Duration.seconds(132.30));
        hit = FXGL.getAssetLoader().loadSound("snare01.wav");
        var testTile = FXGL.getAssetLoader().loadTexture("hex.png");
        testTile.setX(665);
        testTile.setY(335);
        testTile.setScaleX(1.35);
        testTile.setScaleY(1.35);
        testTile.setOpacity(0);

        FXGL.getGameScene().addUINodes(testTile);
        FXGL.runOnce(() -> {guideToBeat(testTile);}, Duration.millis(235));

        testTile.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            tileActive = true;
        });

        testTile.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            tileActive = false;
        });
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
        Entity map = new EntityBuilder()
                .view("TutorialTilemap.png")
                .buildAndAttach();

        scoreText = new Text("Tutorial\n0");
        scoreText.setX(100);
        scoreText.setY(100);
        scoreText.setScaleX(3);
        scoreText.setScaleY(3);
        scoreText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(scoreText);
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
        // reset scale
        tile.setScaleX(2.35);
        tile.setScaleY(2.35);
        tile.setOpacity(1);
        AtomicInteger frame = new AtomicInteger(0);

        FXGL.run(() -> {
            frame.addAndGet(1);
            if (frame.get() == 30) {
                tile.setOpacity(1);
                tile.setScaleX(1.35);
                tile.setScaleY(1.35);
                frame.set(0);
            }
            if (tileActive) {
                tile.setOnMouseClicked(mouseEvent -> {
                    // purposefully empty to clear the eventHandler
                });
                if (frame.get() >= 15 && frame.get() < 30) {
                    tile.setOnMouseClicked(mouseEvent -> {
                        scoreBeat(scoreText);
                        score += frame.get();
                        scoreText.setText("Tutorial\n" + Integer.toString(score));
                        FXGL.getAudioPlayer().playSound(hit);
                    });
                }
                tile.setScaleX(tile.getScaleX() + .03);
                tile.setScaleY(tile.getScaleY() + .03);
                tile.setOpacity(tile.getOpacity() - .03);
            }
        }, Duration.millis(1));
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

    // TO BE IMPLEMENTED
    public void move(Entity currentTile, Entity newTile) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}