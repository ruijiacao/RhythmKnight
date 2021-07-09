package settings;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import ui.AppMainMenu;
import ui.IGenerator;

import java.util.Arrays;
import java.util.List;

public class GlobalSettings {
    private static int windowWidth = 1920;
    private static int windowHeight = 1080;
    private static String gameTitle = "Rhythm Knight";
    private static String version = "Milestone 2";
    private static List<String> credits = Arrays.asList(
            "Kyle Fry - Game Design/Programming",
            "Albin Liang - Programming/Debugging",
            "Jinuk Yun - Production Modeling",
            "Ruijia Cao - Model/Design Implementation",
            "Micah Lingle - Character/Level Design"
    );
    private static Texture playerSprite;

    //Room Counter
    private static int roomCounter = 0;

    // Game config
    private static String playerName;
    private static int difficulty = -1;            // enum?
    private static int startingWeapon = -1;

    public static boolean canStart() {
        boolean canStart = true;
        if (GlobalSettings.playerName == null || GlobalSettings.playerName.isBlank()
                && GlobalSettings.difficulty == -1
                && GlobalSettings.startingWeapon == -1) {
            IGenerator.createAlert("", "Please use the configuration menu to set your preferences "
                    + "before starting the game!");
            canStart = false;
        } else {
            if (GlobalSettings.playerName == null || GlobalSettings.playerName.isBlank()) {
                IGenerator.createAlert("", "A name was not selected, please try again");
                canStart = false;
            }
            if (GlobalSettings.difficulty == -1) {
                IGenerator.createAlert("", "A difficulty was not selected, please try again");
                canStart = false;
            }
            if (GlobalSettings.startingWeapon == -1) {
                IGenerator.createAlert("", "A starting weapon was not selected, please try again");
                canStart = false;
            }
        }
        return canStart;
    }
  
    public static int getWindowWidth() {
        return windowWidth;
    }

    public static int getWindowHeight() {
        return windowHeight;
    }

    public static String getGameTitle() {
        return gameTitle;
    }

    public static String getVersion() {
        return version;
    }

    public static List<String> getCredits() {
        return credits;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        GlobalSettings.playerName = playerName;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        GlobalSettings.difficulty = difficulty;
    }

    public static int getStartingWeapon() {
        return startingWeapon;
    }

    public static void setStartingWeapon(int startingWeapon) {
        GlobalSettings.startingWeapon = startingWeapon;
    }

    public static void setPlayerSprite(Texture playerSprite) {
        GlobalSettings.playerSprite = playerSprite;
    }

    public static void setPlayerPos(Point2D playerPos) {
        playerSprite.setX(playerPos.getX());
        playerSprite.setY(playerPos.getY());
    }

    public static Texture getPlayerSprite() {
        return playerSprite;
    }
    public static int getRoomCounter() {
        return roomCounter;
    }

    public static void setDefault(GameSettings game) {
        game.setWidth(GlobalSettings.getWindowWidth());
        game.setHeight(GlobalSettings.getWindowHeight());
        game.setTitle(GlobalSettings.getGameTitle());
        game.setVersion(GlobalSettings.getVersion());
        game.setMainMenuEnabled(true);
        game.setSceneFactory(new SceneFactory() {
            @NotNull
            @Override
            public FXGLMenu newMainMenu() {
                return new AppMainMenu(MenuType.MAIN_MENU);
            }
        });
    }
}