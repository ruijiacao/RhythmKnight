package settings;

import ui.IGenerator;

import java.util.Arrays;
import java.util.List;

public class GlobalSettings {
    public static int windowWidth = 1920;
    public static int windowHeight = 1080;
    public static String gameTitle = "Rhythm Knight";
    public static String version = "Milestone 2";
    public static List<String> credits = Arrays.asList(
            "Kyle Fry - Game Design/Programming",
            "Albin Liang - Programming/Debugging",
            "Jinuk Yun - Production Modeling",
            "Ruijia Cao - Model/Design Implementation",
            "Micah Lingle - Character/Level Design"
    );

    // Game config
    public static String playerName;
    public static int difficulty = -1;            // enum?
    public static int startingWeapon = -1;

    public static boolean canStart() {
        boolean canStart = true;
        if (GlobalSettings.playerName == null || GlobalSettings.playerName.isBlank()
                && GlobalSettings.difficulty == -1
                && GlobalSettings.startingWeapon == -1) {
            IGenerator.createAlert("", "Please use the configuration menu to set your preferences "
                    + "before starting the game!");
            canStart = false;
        }
        else {
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

}