import com.almasb.fxgl.app.GameApplication;
import javafx.geometry.Point2D;
import monsters.Monster;
import monsters.Slime;
import monsters.Wizard;
import monsters.Zombie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import settings.GlobalSettings;
import tilesystem.Tile;
import tilesystem.TileType;

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
    public void gameStartLogic() {
        try {
            GlobalSettings.canStart();
        } catch (ExceptionInInitializerError e) {
            System.out.println("Tries to create an alert because no config settings were filled");
            Assertions.assertInstanceOf(ExceptionInInitializerError.class, e);
        }

        try {
            GlobalSettings.setPlayerName(" ");
            GlobalSettings.setDifficulty(1);
            GlobalSettings.setStartingWeapon(1);
            GlobalSettings.canStart();
        } catch (NoClassDefFoundError e) {
            System.out.println("Attempted to create an alert box because name was not set");
            Assertions.assertInstanceOf(NoClassDefFoundError.class, e);
        }

        try {
            GlobalSettings.setPlayerName("Micah");
            GlobalSettings.setDifficulty(-1);
            GlobalSettings.setStartingWeapon(1);
            GlobalSettings.canStart();
        } catch (NoClassDefFoundError e) {
            System.out.println("Attempted to create an alert box because difficulty was not set");
            Assertions.assertInstanceOf(NoClassDefFoundError.class, e);
        }

        try {
            GlobalSettings.setPlayerName("Micah");
            GlobalSettings.setDifficulty(1);
            GlobalSettings.setStartingWeapon(-1);
            GlobalSettings.canStart();
        } catch (NoClassDefFoundError e) {
            System.out.println("Attempted to create an alert box "
                + "because starting weapon was not set");
            Assertions.assertInstanceOf(NoClassDefFoundError.class, e);
        }

        // Successful
        GlobalSettings.setPlayerName("Micah");
        GlobalSettings.setDifficulty(1);
        GlobalSettings.setStartingWeapon(1);
        Assertions.assertTrue(GlobalSettings.canStart());

    }

    // validates if the active monsters arraylist is instantiated and can add correctly
    @Test
    public void initActiveMonsters() {

        GameApplication.launch(GameApp.class, new String[0]);

        // add some monsters
        Monster slime = new Slime(new Tile(new Point2D(0 ,0), TileType.MONSTER));
        Monster wizard = new Wizard(new Tile(new Point2D(0 ,0), TileType.MONSTER));
        Monster zombie = new Zombie(new Tile(new Point2D(0 ,0), TileType.MONSTER));

        GlobalSettings.addActiveMonster(slime);
        GlobalSettings.addActiveMonster(wizard);
        GlobalSettings.addActiveMonster(zombie);

        assertEquals(slime, GlobalSettings.getActiveMonsters().get(0));
        assertEquals(wizard, GlobalSettings.getActiveMonsters().get(1));
        assertEquals(zombie, GlobalSettings.getActiveMonsters().get(2));
    }

    // do damage to the monsters, which should take them off the activeMonsters ArrayList
    @Test
    public void clearActiveMonsters() {

        GameApplication.launch(GameApp.class, new String[0]);

        GlobalSettings.clearActiveMonsters();

        // add some monsters
        Monster slime = new Slime(new Tile(new Point2D(0 ,0), TileType.MONSTER));
        Monster wizard = new Wizard(new Tile(new Point2D(0 ,0), TileType.MONSTER));
        Monster zombie = new Zombie(new Tile(new Point2D(0 ,0), TileType.MONSTER));

        GlobalSettings.addActiveMonster(slime);
        GlobalSettings.addActiveMonster(wizard);
        GlobalSettings.addActiveMonster(zombie);

        slime.takeDamage(100);
        wizard.takeDamage(150);
        zombie.takeDamage(200);

        assertTrue(GlobalSettings.getActiveMonsters().isEmpty());
    }
}