import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.MenuItem;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;


public class GameApp extends GameApplication {

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

    @Override
    protected void initGame() {
        Sound OST = FXGL.getAssetLoader().loadSound("Tutorial.wav");
        FXGL.getAudioPlayer().playSound(OST);
    }

    @Override
    protected void initUI() {
        Entity map = new EntityBuilder()
                .view("TutorialTilemap.png")
                .buildAndAttach();

    }

    public void guideToBeat(Entity tile) {

    }

    public void move(Entity currentTile, Entity newTile) {

    }

    public static void main(String[] args) {
        launch(args);
    }

}
