import com.almasb.fxgl.app.GameApplication;
import org.junit.jupiter.api.Test;
import rooms.*;
import tilesystem.MapDirectory;
import tilesystem.Tile;
import tilesystem.TileType;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MapDirectoryTest {
    // confirms that the MapDirectory is not null
    @Test
    void testConstructor() {
        GameApplication.launch(GameApp.class, new String[0]);
        MapDirectory maps = new MapDirectory();
        assertNotNull(maps);
    }

    // validates that the MapDirectory returns the valid starting room + spawn point
    @Test
    void startingRoomTest() {
        GameApplication.launch(GameApp.class, new String[0]);
        StartingRoom room = new StartingRoom();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            assertEquals(roomTiles.get(i).getType(), maps.getStartMap().get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 1st room + spawn point
    @Test
    public void Room1Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room1 room = new Room1();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(1).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 2nd room + spawn point
    @Test
    public void Room2Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room2 room = new Room2();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(2).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 3rd room + spawn point
    @Test
    public void Room3Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room3 room = new Room3();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(3).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 4th room + spawn point
    @Test
    public void Room4Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room4 room = new Room4();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(4).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 5th room + spawn point
    @Test
    public void Room5Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room5 room = new Room5();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(5).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 5th room + spawn point
    @Test
    public void Room11Test() {
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

    }

    // validates that the MapDirectory returns the valid 5th room + spawn point
    @Test
    public void Room12Test() {
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
    }
}
