import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import settings.GlobalSettings;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalSettingsTest {

    // checks that the default screen resolution on initial startup is 1920 x 1080
    @Test
    public void defaultResolution() {
        int defWidth = GlobalSettings.getWindowWidth();
        int defHeight = GlobalSettings.getWindowHeight();
        assertEquals(1920, defWidth);
        assertEquals(1080, defHeight);
    }

    /* checks that the game title is correct & player selected difficulty and weapon are
       defaulted to "unselected" on initial startup */
    @Test
    public void defaultGameSettings() {
        String gameTitle = GlobalSettings.getGameTitle();
        int difficulty = GlobalSettings.getDifficulty();
        int weapon = GlobalSettings.getStartingWeapon();
        assertEquals("Rhythm Knight", gameTitle);
        assertEquals(-1, difficulty);
        assertEquals(-1, weapon);
    }

    @Test
    public void GameStartLogic() {
        try {
            GlobalSettings.canStart();
        } catch (ExceptionInInitializerError e) {
            System.out.println("Tries to create an alert because no config settings were filled");
            Assertions.assertInstanceOf(ExceptionInInitializerError.class, e);
        }

        try {
            GlobalSettings.playerName= " ";
            GlobalSettings.getDifficulty = 1;
            GlobalSettings.startingWeapon = 1;
            GlobalSettings.canStart();
        } catch (NoClassDefFoundError e) {
            System.out.println("Attempted to create an alert box because name was not set");
            Assertions.assertInstanceOf(NoClassDefFoundError.class, e);
        }

        try {
            GlobalSettings.playerName = "Micah";
            GlobalSettings.difficulty = -1;
            GlobalSettings.startingWeapon = 1;
            GlobalSettings.canStart();
        } catch (NoClassDefFoundError e) {
            System.out.println("Attempted to create an alert box because difficulty was not set");
            Assertions.assertInstanceOf(NoClassDefFoundError.class, e);
        }

        try {
            GlobalSettings.playerName = "Micah";
            GlobalSettings.difficulty = 1;
            GlobalSettings.startingWeapon = -1;
            GlobalSettings.canStart();
        } catch (NoClassDefFoundError e) {
            System.out.println("Attempted to create an alert box because starting weapon was not set");
            Assertions.assertInstanceOf(NoClassDefFoundError.class, e);
        }

        // Succesful
        GlobalSettings.playerName = "Micah";
        GlobalSettings.difficulty = 1;
        GlobalSettings.startingWeapon = 1;
        Assertions.assertTrue(GlobalSettings.canStart());

    }

}