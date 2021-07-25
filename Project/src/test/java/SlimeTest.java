import Player.Player;
import com.almasb.fxgl.app.GameApplication;
import javafx.geometry.Point2D;
import monsters.Slime;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tilesystem.Tile;
import tilesystem.TileType;

import static org.junit.Assert.*;

public class SlimeTest {

    @Test
    public void takeDamageTest() {
        GameApplication.launch(GameApp.class, new String[0]);
        Tile tile = new Tile(new Point2D(405, 435), TileType.INVISIBLE);
//        Tile tile = new Tile(new Point2D(405, 435), TileType.INVISIBLE);
        Slime monster = new Slime(tile);
        monster.takeDamage(12);
        assertEquals(monster.getHealth(), 38);
    }


}