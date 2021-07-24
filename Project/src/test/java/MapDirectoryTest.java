import com.almasb.fxgl.app.GameApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rooms.*;
import tilesystem.MapDirectory;
import tilesystem.Tile;
import tilesystem.TileType;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MapDirectoryTest {

    // confirms MapDirectory throws no errors
    @Test
    void testParse() {
        GameApplication.launch(GameApp.class, new String[0]);
        try {
            MapDirectory maps = new MapDirectory();
            assertNotNull(maps);
        } catch (Exception e) {
            fail();
        }
    }

    // confirms that the MapDirectory is not null
    @Test
    void testConstructor() {
        GameApplication.launch(GameApp.class, new String[0]);
        MapDirectory maps = new MapDirectory();
        assertNotNull(maps);
    }

    @Test
    void testFirstMap() {
        GameApplication.launch(GameApp.class, new String[0]);
        MapDirectory maps = new MapDirectory();
        Assertions.assertEquals(maps.getStartMap(), maps.getIDLayout(0));
    }
}
