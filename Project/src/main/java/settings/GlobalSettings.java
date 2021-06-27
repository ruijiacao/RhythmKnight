package settings;

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

    // Game config
    private static String playerName;
    private static int difficulty = -1;            // enum?
    private static int startingWeapon = -1;

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
}