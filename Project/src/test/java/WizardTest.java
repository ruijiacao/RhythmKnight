import com.almasb.fxgl.app.GameApplication;
import javafx.geometry.Point2D;
import monsters.Wizard;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import tilesystem.Tile;
import tilesystem.TileType;

import static org.junit.Assert.*;

public class WizardTest extends ApplicationTest {

    @Test
    public void takeDamageTest() {
        GameApplication.launch(GameApp.class, new String[0]);
        Tile tile = new Tile(new Point2D(500, 500), TileType.INVISIBLE);
        Wizard wizard = new Wizard(tile);
        wizard.takeDamage(99);
        assertEquals(wizard.getHealth(), 1);
    }

    @Test
    public void testIsDefeated() {
        GameApplication.launch(GameApp.class, new String[0]);
        Tile tile = new Tile(new Point2D(500, 500), TileType.INVISIBLE);
        Wizard wizard = new Wizard(tile);
        wizard.takeDamage(101);
        Assertions.assertEquals(true, wizard.isDefeated());
    }
}