import com.almasb.fxgl.app.GameApplication;
import org.junit.jupiter.api.Test;
import rooms.*;
import tilesystem.MapDirectory;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MapDirectoryTest {
    // confirms that the MapDirectory is not null
    @Test
    void testConstructor() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            MapDirectory maps = new MapDirectory();
            assertNotNull(maps);
        }).start();
    }

    // validates that the MapDirectory returns the valid starting room + spawn point
    @Test
    void startingRoomTest() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            MapDirectory maps = new MapDirectory();
            assertEquals(new StartingRoom().buildTiles(), maps.getStartMap());
            assertEquals(new StartingRoom().buildTiles().get(0).getPosition(), maps.getMapOrigin(0));
        }).start();
    }

    // validates that the MapDirectory returns the valid 1st room + spawn point
    @Test
    public void Room1Test() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            MapDirectory maps = new MapDirectory();
            assertEquals(new Room1().buildTiles(), maps.getStartMap());
            assertEquals(new Room1().buildTiles().get(0).getPosition(), maps.getMapOrigin(1));
        }).start();
    }

    // validates that the MapDirectory returns the valid 2nd room + spawn point
    @Test
    public void Room2Test() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            MapDirectory maps = new MapDirectory();
            assertEquals(new Room2().buildTiles(), maps.getStartMap());
            assertEquals(new Room2().buildTiles().get(0).getPosition(), maps.getMapOrigin(2));
        }).start();
    }

    // validates that the MapDirectory returns the valid 3rd room + spawn point
    @Test
    public void Room3Test() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            MapDirectory maps = new MapDirectory();
            assertEquals(new Room3().buildTiles(), maps.getStartMap());
            assertEquals(new Room3().buildTiles().get(0).getPosition(), maps.getMapOrigin(3));
        }).start();
    }

    // validates that the MapDirectory returns the valid 4th room + spawn point
    @Test
    public void Room4Test() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            MapDirectory maps = new MapDirectory();
            assertEquals(new Room4().buildTiles(), maps.getStartMap());
            assertEquals(new Room4().buildTiles().get(0).getPosition(), maps.getMapOrigin(4));
        }).start();
    }

    // validates that the MapDirectory returns the valid 5th room + spawn point
    @Test
    public void Room5Test() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            MapDirectory maps = new MapDirectory();
            assertEquals(new Room5().buildTiles(), maps.getStartMap());
            assertEquals(new Room5().buildTiles().get(0).getPosition(), maps.getMapOrigin(5));
        }).start();
    }

    // validates that the MapDirectory returns the valid 5th room + spawn point
    @Test
    public void Room11Test() {
        new Thread(() -> {
            GameApplication.launch(GameApp.class, new String[0]);
            Room11 room = new Room11();
            ArrayList<Tile> tiles = room.buildTiles();
            for (int i : new int[]{7, 14, 18, 21, 26, 23, 17, 9, 10, 6, 3}) {
                assertEquals(TileType.VISITED, tiles.get(i).getType());
            }
            for (int i : new int[]{22, 24}) {
                assertEquals(TileType.MONSTER, tiles.get(i).getType());
            }
            for (int i : new int[]{13, 2}) {
                assertEquals(TileType.GOLD, tiles.get(i).getType());
            }
            for (int i : new int[]{11, 19}) {
                assertEquals(TileType.MYSTERY, tiles.get(i).getType());
            }
            for (int i : new int[]{5, 15}) {
                assertEquals(TileType.LOCKED_EXIT, tiles.get(i).getType());
            }
            for (int i : new int[]{25, 27}) {
                assertEquals(TileType.EXIT, tiles.get(i).getType());
            }
        }).start();

    }

    // validates that the MapDirectory returns the valid 5th room + spawn point
    @Test
    public void Room12Test() {
        new Thread(() -> {
            Room12 room = new Room12();
            ArrayList<Tile> tiles = room.buildTiles();
            for (int i : new int[]{7, 4, 2, 3, 6, 9, 10, 20, 24, 27, 21, 25}) {
                assertEquals(TileType.VISITED, tiles.get(i).getType());
            }
            for (int i : new int[]{5, 11, 18, 26}) {
                assertEquals(TileType.MONSTER, tiles.get(i).getType());
            }
            for (int i : new int[]{12, 19, 23}) {
                assertEquals(TileType.GOLD, tiles.get(i).getType());
            }
            for (int i : new int[]{8, 15, 22}) {
                assertEquals(TileType.MYSTERY, tiles.get(i).getType());
            }
            for (int i : new int[]{13, 14}) {
                assertEquals(TileType.LOCKED_EXIT, tiles.get(i).getType());
            }
            for (int i : new int[]{1, 28}) {
                assertEquals(TileType.EXIT, tiles.get(i).getType());
            }
        }).start();
    }
}
