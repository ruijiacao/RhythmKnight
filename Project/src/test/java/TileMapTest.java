import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rhythm.Conductor;
import tilesystem.Tile;
import tilesystem.TileMap;

class TileMapTest {

    private Conductor conductor;
    private Text scoreText;
    private TileMap cut;

    @BeforeEach
    public void setCuT() {
        conductor = mock(Conductor.class);
        scoreText = mock(Text.class);

        cut = new TileMap(conductor, scoreText);
    }

    @Test
    public void constructorTest() {
        assertNotNull(cut);
        assertEquals(cut.getSize(), 0);
    }

    @Test
    void addTile() {
        Tile mockTile = mock(Tile.class);
        cut.addTile(mockTile);

        assertEquals(cut.getSize(), 1);
    }

    @Test
    void removeTile() {
        Tile mockTile1 = mock(Tile.class);
        Tile mockTile2 = mock(Tile.class);
        cut.addTile(mockTile1);
        cut.addTile(mockTile2);
        cut.removeTile(mockTile1);
        assertEquals(cut.getSize(), 1);
        cut.removeTile(mockTile2);
        assertEquals(cut.getSize(), 0);
    }

}