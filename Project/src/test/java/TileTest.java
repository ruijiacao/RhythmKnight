import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import tilesystem.Tile;

import static org.testfx.api.FxAssert.verifyThat;

public class TileTest extends ApplicationTest{

    @BeforeAll
    public static void testSetUp() throws Exception {
        GameApp.main(new String[0]);
    }

    @Test
    public void testConstructor() {
        Tile tile1 = new Tile(FXGL.getAssetLoader().loadTexture("unvisited.png"), new Point2D(405, 435));
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
    }

    // checks for no errors on calling setScale()
    @Test
    void setScale() {
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

    }

    // checks for correct active status
    @Test
    void isPlayerOnTile() {

    }

    // checks for correct active status
    @Test
    void isActive() {

    }

    // checks if all tile properties are reset back to normal
    @Test
    void reset() {
    }
}