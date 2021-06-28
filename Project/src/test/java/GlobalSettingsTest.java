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
}