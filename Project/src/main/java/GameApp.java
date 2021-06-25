import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.util.Duration;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class GameApp extends GameApplication {

    // Global app variables
    int score = 0;
    Text scoreText;
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
        int bpm = 135;
        Conductor conductor = new Conductor(bpm, OSTPath, score);
        scoreText = new Text("Level " + currLevel + " / Floor " + currFloor + "\n0");
        scoreText.setX(200);
        scoreText.setY(100);
        scoreText.setScaleX(3);
        scoreText.setScaleY(3);
        scoreText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(scoreText);
        var cutout = FXGL.getAssetLoader().loadTexture("cutout.png");

        FXGL.getGameTimer().runOnceAfter(() ->{conductor.startAndKeepRhythm(cutout);}, Duration.millis(1));

        ArrayList<Tile> tiles = new ArrayList<>();

        Tile tile1 = new Tile(FXGL.getAssetLoader().loadTexture("unvisited.png"), new Point2D(665, 335));
        Tile tile2 = new Tile(FXGL.getAssetLoader().loadTexture("unvisited.png"), new Point2D(857, 223));
        tiles.add(tile1);
        tiles.add(tile2);
        TileMap tileMap = new TileMap(tiles, conductor, scoreText);
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
    }
    public static void main(String[] args) {
        launch(args);
    }
}
