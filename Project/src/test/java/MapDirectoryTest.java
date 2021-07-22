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
    /*
    @Test
    void startingRoomTest() {
        GameApplication.launch(GameApp.class, new String[0]);
        StartingRoom room = new StartingRoom();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getStartMap().get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 1st room + spawn point
    @Test
    public void room1Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room1 room = new Room1();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(1).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 2nd room + spawn point
    @Test
    public void room2Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room2 room = new Room2();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(2).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 3rd room + spawn point
    @Test
    public void room3Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room3 room = new Room3();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(3).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 4th room + spawn point
    @Test
    public void room4Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room4 room = new Room4();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(4).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 5th room + spawn point
    @Test
    public void room5Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room5 room = new Room5();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(5).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 8th room + spawn point
    @Test
    public void room8Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room8 room = new Room8();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(8).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 9th room + spawn point
    @Test
    public void room9Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room9 room = new Room9();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(9).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 10th room + spawn point
    @Test
    public void room10Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room10 room = new Room10();
        MapDirectory maps = new MapDirectory();
        ArrayList<Tile> roomTiles = room.buildTiles();

        for (int i = 0; i < roomTiles.size(); i++) {
            assertNotNull(roomTiles.get(i));
            //assertEquals(roomTiles.get(i).getType(), maps.getIDLayout(10).get(i).getType());
        }
    }

    // validates that the MapDirectory returns the valid 11th room + spawn point
    @Test
    public void room11Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room11 room = new Room11();
        ArrayList<Tile> tiles = room.buildTiles();
        for (int i : new int[]{7, 14, 18, 21, 26, 23, 17, 9, 10, 6, 3}) {
            //assertEquals(TileType.VISITED, tiles.get(i).getType());
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

    // validates that the MapDirectory returns the valid 12th room + spawn point
    @Test
    public void room12Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room12 room = new Room12();
        ArrayList<Tile> tiles = room.buildTiles();
        for (int i : new int[]{7, 4, 2, 3, 6, 9, 10, 20, 24, 21, 25}) {
            //assertEquals(TileType.VISITED, tiles.get(i).getType());
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
        for (int i : new int[]{1, 27}) {
            assertEquals(TileType.EXIT, tiles.get(i).getType());
        }
    }

    @Test
    public void room13Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room13 room = new Room13();
        ArrayList<Tile> tilesList = room.buildTiles();

        for (int i : new int[]{1, 2, 3, 5, 6, 7, 9, 11, 17, 24, 25, 27}) {
            //assertEquals(TileType.VISITED, tilesList.get(i).getType());
        }
        for (int i : new int[]{15, 21}) {
            assertEquals(TileType.GOLD, tilesList.get(i).getType());
        }
        for (int i : new int[]{12, 16, 23}) {
            assertEquals(TileType.MYSTERY, tilesList.get(i).getType());
        }
        for (int i : new int[]{8, 13, 14, 20}) {
            assertEquals(TileType.MONSTER, tilesList.get(i).getType());
        }
        for (int i : new int[]{4, 10}) {
            assertEquals(TileType.EXIT, tilesList.get(i).getType());
        }
        for (int i : new int[]{18, 26}) {
            assertEquals(TileType.LOCKED_EXIT, tilesList.get(i).getType());
        }
    }

    @Test
    public void room14Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room14 room = new Room14();
        ArrayList<Tile> tilesList = room.buildTiles();

        for (int i : new int[]{2, 3, 6, 7, 10, 14, 17, 21, 24, 26, 27}) {
            //assertEquals(TileType.VISITED, tilesList.get(i).getType());
        }
        for (int i : new int[]{11, 22}) {
            assertEquals(TileType.GOLD, tilesList.get(i).getType());
        }
        for (int i : new int[]{8, 9, 19}) {
            assertEquals(TileType.MYSTERY, tilesList.get(i).getType());
        }
        for (int i : new int[]{4, 5, 12, 23}) {
            assertEquals(TileType.MONSTER, tilesList.get(i).getType());
        }
        for (int i : new int[]{1}) {
            assertEquals(TileType.EXIT, tilesList.get(i).getType());
        }
        for (int i : new int[]{13, 18, 20}) {
            assertEquals(TileType.LOCKED_EXIT, tilesList.get(i).getType());
        }
    }

    @Test
    public void room15Test() {
        GameApplication.launch(GameApp.class, new String[0]);
        Room15 room = new Room15();
        ArrayList<Tile> tilesList = room.buildTiles();

        for (int i : new int[]{3, 5, 10, 17, 21, 22, 23, 24, 27}) {
            //assertEquals(TileType.VISITED, tilesList.get(i).getType());
        }
        for (int i : new int[]{8}) {
            assertEquals(TileType.GOLD, tilesList.get(i).getType());
        }
        for (int i : new int[]{7, 15, 20, 26}) {
            assertEquals(TileType.MYSTERY, tilesList.get(i).getType());
        }
        for (int i : new int[]{1, 6, 16}) {
            assertEquals(TileType.MONSTER, tilesList.get(i).getType());
        }
        for (int i : new int[]{2}) {
            assertEquals(TileType.EXIT, tilesList.get(i).getType());
        }
        for (int i : new int[]{13, 19, 25}) {
            assertEquals(TileType.LOCKED_EXIT, tilesList.get(i).getType());
        }
    }

     */
}
