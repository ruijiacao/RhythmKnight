import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import settings.GlobalSettings;
import initializers.Initializer;

public class GameApp extends GameApplication {

    /*
    ===== GAME WINDOW SETTINGS =====
    Sets the game window settings to default.
    Check settings.GlobalSettings.java for default game settings.
    ================================
     */
    @Override
    protected void initSettings(GameSettings game) {
        GlobalSettings.setDefault(game);
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
        Initializer init = new Initializer();
        init.initStart();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
