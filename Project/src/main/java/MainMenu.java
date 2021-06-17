import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.shape.Rectangle;

public class MainMenu extends GameApplication {
    @Override
    protected void initSettings(GameSettings game) {
        game.setWidth(GlobalSettings.windowWidth);
        game.setHeight(GlobalSettings.windowHeight);
        game.setTitle(GlobalSettings.gameTitle);
        game.setVersion(GlobalSettings.version);
    }

    @Override
    protected void initUI() {
        Entity menu = new EntityBuilder()
                .view("main-menu.png")
                .buildAndAttach();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
