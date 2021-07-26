import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import tilesystem.Tile;
import tilesystem.TileType;

public class TileTest extends ApplicationTest {

    @BeforeAll
    public static void testSetUp() throws Exception {
        GameApplication.launch(GameApp.class, new String[0]);
    }

    @Test
    public void testConstructor() {
        Tile tile1 = new Tile(new Point2D(405, 435), TileType.INVISIBLE);
        assertEquals(tile1.getPosition().getX(), 405.0);
        assertEquals(tile1.getPosition().getY(), 435.0);
    }

    // checks for the correct tile texture
    @Test
    void getTileTexture() {
        Tile tile1 = new Tile(new Point2D(405, 435), TileType.MYSTERY);
        Texture texture = FXGL.getAssetLoader().loadTexture("newUnvisitedTile.png");
        tile1.setTileTexture(texture);
        assertEquals(tile1.getTileTexture(),
            texture);
    }

    @Test
    void getPosition() {
        Tile tile1 = new Tile(new Point2D(405, 435), TileType.NORMAL);
        Point2D pos = new Point2D(405, 435);
        assertEquals(pos, tile1.getPosition());
    }

    @Test
    void isVisited() {
        Tile tile1 = new Tile(new Point2D(405, 435), TileType.NORMAL);
        tile1.setVisited();
        assertTrue(tile1.isVisited());
    }
}
