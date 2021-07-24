import com.almasb.fxgl.app.GameApplication;
import javafx.geometry.Point2D;
import monsters.Slime;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.framework.junit.ApplicationTest;
import tilesystem.Tile;
import tilesystem.TileType;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

public class SlimeTest {
    @BeforeAll
    public void testSetUp() throws Exception {
        GameApplication.launch(GameApp.class, new String[0]);
    }

    @Test
    public void doDamageTest() {
        Tile tile = new Tile(new Point2D(405, 435), TileType.INVISIBLE);
        Slime monster = new Slime(tile);
        monster.doDamage(12);
    }


}