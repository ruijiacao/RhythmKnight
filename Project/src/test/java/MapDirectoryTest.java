import com.almasb.fxgl.app.GameApplication;
import org.junit.jupiter.api.Test;
import rooms.*;
import tilesystem.MapDirectory;

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
}
