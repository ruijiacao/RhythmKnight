import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import settings.GlobalSettings;
import initializers.Initializer;

public class GameApp extends GameApplication {
    

    // Global app variables
    private static int currLevel;
    private static int currFloor;
    private Entity map;
    private Entity layout;
    private Entity uiBg;

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
