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


}
