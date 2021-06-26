import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalSettingsTest {

    // checks that the default screen resolution on initial startup is 1920 x 1080
    @Test
    public void defaultResolution() {
        int defWidth = GlobalSettings.windowWidth;
        int defHeight = GlobalSettings.windowHeight;
        assertEquals(1920, defWidth);
        assertEquals(1080, defHeight);
    }

    /* checks that the game title is correct & player selected difficulty and weapon are
       defaulted to "unselected" on initial startup */
    @Test
    public void defaultGameSettings() {
        String gameTitle = GlobalSettings.gameTitle;
        int difficulty = GlobalSettings.difficulty;
        int weapon = GlobalSettings.startingWeapon;
        assertEquals("Rhythm Knight", gameTitle);
        assertEquals(-1, difficulty);
        assertEquals(-1, weapon);
    }

}