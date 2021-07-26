import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.almasb.fxgl.app.GameApplication;
import javafx.geometry.Point2D;
import java.util.ArrayList;
import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import rhythm.Conductor;
import tilesystem.Tile;
import tilesystem.TileMap;
import tilesystem.TileType;

class TileMapTest extends ApplicationTest {

    private TileMap cut;

    @Test
    public void constructorTest() {
        GameApplication.launch(GameApp.class, new String[0]);
        cut = new TileMap(0, new ArrayList<Tile>());
        assertNotNull(cut);
        assertEquals(cut.getId(), 0);
        assertNotNull(cut.getTiles());
        assertEquals(cut.getSize(), 0);
    }

    @Test
    void addTile() {
        cut = new TileMap(0, new ArrayList<Tile>());
        Tile tile = new Tile(new Point2D(430,405), TileType.INVISIBLE);
        cut.addTile(tile);
        assertEquals(cut.getSize(), 1);
    }

    @Test
    void removeTile() {
        cut = new TileMap(0, new ArrayList<Tile>());
        Tile tile = new Tile(new Point2D(430,405), TileType.INVISIBLE);
        cut.addTile(tile);
        cut.removeTile(tile);
        assertEquals(cut.getSize(), 0);
    }

    @Test
    void getTileTest() {
        cut = new TileMap(0, new ArrayList<Tile>());
        Tile tile = new Tile(new Point2D(430,405), TileType.INVISIBLE);
        cut.addTile(tile);
        assertEquals(tile, cut.getTile(0));
    }
}