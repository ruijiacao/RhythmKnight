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
}