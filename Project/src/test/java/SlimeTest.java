import com.almasb.fxgl.app.GameApplication;
import javafx.geometry.Point2D;
import monsters.Slime;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.framework.junit.ApplicationTest;
import tilesystem.Tile;
import tilesystem.TileType;

import static org.junit.Assert.*;

public class SlimeTest extends ApplicationTest{
    
    @BeforeAll
    public static void testSetUp() throws Exception {
        GameApp.main(new String[0]);
    }

    @org.junit.jupiter.api.Test
    public void doDamageTest() {
        Tile tile = new Tile(new Point2D(405, 435), TileType.INVISIBLE);
        Slime monster = new Slime(tile);
        monster.doDamage(12);
        Assertions.assertEquals(38, monster.getHealth());
    }

    @org.junit.jupiter.api.Test
    public void testIsDefeated() {
        Tile tile = new Tile(new Point2D(405, 435), TileType.INVISIBLE);
        Slime monster = new Slime(tile);
        monster.doDamage(51);
        Assertions.assertEquals(true, monster.isDefeated());
    }



}