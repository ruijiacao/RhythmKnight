import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;
import java.io.File;


public class GameApp extends GameApplication {

    // Global app variables
    int score = 0;
    Text scoreText;
    private static Media OST;
    private static MediaPlayer songPlayer;
    static int currLevel;
    static int currFloor;
    Entity map;

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
    This method is called as soon as the game opens as well.

    The song to be played is initialized and started through a MediaPlayer
    and other game objects such as sound effects and tiles are instantiated.
    =================================
     */
    @Override
    protected void initGame() {
        String OSTPath = "." + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "assets" + File.separator +
                "sounds" + File.separator + "Diodes.mp3";
        currLevel = 1;
        currFloor = 1;

        Conductor conductor = new Conductor(135, OSTPath, 0);
        var cutout = FXGL.getAssetLoader().loadTexture("cutout.png");
        conductor.startAndKeepRhythm(cutout);

        var tile1 = FXGL.getAssetLoader().loadTexture("unvisited.png");
        tile1.setX(665);
        tile1.setY(335);
        tile1.setScaleX(1.35);
        tile1.setScaleY(1.35);
        tile1.setOpacity(1);

        FXGL.getGameScene().addUINodes(tile1);
        tile1.setOnMouseClicked(mouseEvent -> { conductor.checkRhythm(tile1, scoreText); });


        var tile2 = FXGL.getAssetLoader().loadTexture("unvisited.png");
        tile2.setX(857);
        tile2.setY(223);
        tile2.setScaleX(1.35);
        tile2.setScaleY(1.35);
        tile2.setOpacity(1);

        FXGL.getGameScene().addUINodes(tile2);
        tile2.setOnMouseClicked(mouseEvent -> {conductor.checkRhythm(tile2, scoreText);});
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
    }
    public static void main(String[] args) {
        launch(args);
    }
}