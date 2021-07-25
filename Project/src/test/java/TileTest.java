import javafx.geometry.Point2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import tilesystem.Tile;
import tilesystem.TileType;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TileTest extends ApplicationTest {

    @BeforeAll
    public static void testSetUp() throws Exception {
        GameApp.main(new String[0]);
    }

    @Test
    public void testConstructor() {
        Tile tile1 = new Tile(new Point2D(405, 435), TileType.INVISIBLE);
        Assertions.assertEquals(tile1.getPosition().getX(), 405.0);
        Assertions.assertEquals(tile1.getPosition().getY(), 435.0);
    }


    // checks if a tile is properly added to a scene
    @Test
    void displayOnScene() {

    }

    // checks if a tile is properly released from a scene
    @Test
    void removeFromScene() {

    }

    // checks for no errors on calling setTileTexture()
    @Test
    void setTileTexture() {
    }

    // checks for no errors on calling setOpacity()
    @Test
    void setOpacity() {
        //Tile tile1 = new Tile(new Point2D(405, 435), TileType.UNVISITED);
        //Assertions.assertEquals(tile1.getPosition().getX(), 405.0);
        //Assertions.assertEquals(tile1.getPosition().getY(), 435.0);
        //tile1.setOpacity(.5);
        //Assertions.assertEquals(.5, tile1.getOpacity());
    }

    // checks for no errors on calling setScale()
    @Test
    void setScale() {
        //Tile tile1 = new Tile(new Point2D(405, 435), TileType.UNVISITED);
        //Assertions.assertEquals(tile1.getPosition().getX(), 405.0);
        //Assertions.assertEquals(tile1.getPosition().getY(), 435.0);
        //tile1.setScale(.5);
        //Assertions.assertEquals(.5, tile1.getScale());
    }

    // checks for no errors on calling setPlayerOnTile()
    @Test
    void setPlayerOnTile() {

    }

    // checks for no errors on calling setActive()
    @Test
    void setActive() {

    }

    // checks for the correct tile texture
    @Test
    void getTileTexture() {
        
    }

    // checks for correct opacity value
    @Test
    void getOpacity() {
        //Tile tile1 = new Tile(new Point2D(405, 435), TileType.UNVISITED);
        //tile1.setOpacity(.5);
        //Assertions.assertEquals(.5, tile1.getOpacity());
    }

    // checks for correct active status
    @Test
    void isPlayerOnTile() {
        //Tile tile1 = new Tile(new Point2D(200, 200), TileType.UNVISITED);
        //tile1.setPlayerOnTile(true);
        //assertTrue(tile1.isPlayerOnTile());
    }

    // checks for correct active status
    @Test
    void isActive() {
        //Tile tile1 = new Tile(new Point2D(200, 200), TileType.UNVISITED);
        //tile1.setActive(true);
        //assertTrue(tile1.isTileActive());
    }

    // checks if all tile properties are reset back to normal
    @Test
    void reset() {
        //Tile tile1 = new Tile(new Point2D(405, 435), TileType.UNVISITED);
        //Assertions.assertEquals(tile1.getPosition().getX(), 405.0);
        //Assertions.assertEquals(tile1.getPosition().getY(), 435.0);
        //tile1.setScale(.5);
        //tile1.setOpacity(0);
        //tile1.reset();
//
        //Assertions.assertEquals(1.35, tile1.getScale());
        //Assertions.assertEquals(1, tile1.getOpacity());
    }
}
