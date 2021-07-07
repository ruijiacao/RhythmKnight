package tilesystem;


import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.text.Text;
import rhythm.Conductor;
import settings.GlobalSettings;

import java.util.ArrayList;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class MapLoader {
    /*
    =========== LOAD A MAP ONTO THE SCENE ==========
    Core method for loading a map onto a scene. Works by:
    - Clearing the scene of all elements
    - Fetches an ArrayList of all Tiles for the passed in room ID from MapDirectory
    - Displays the layout background of the room ID passed in
    - Displays the Level UI of the new room
    - Sets the player's Entity and origin location in the new room
    =================================================
     */
    public static void loadMap(int id, Conductor conductor, Text scoreText) {
        clearScene();

        MapDirectory maps = new MapDirectory();

        Texture newRoomLayout = FXGL.getAssetLoader().loadTexture("layouts/dungeon/layout" + id + ".png");
        Entity layout = new EntityBuilder()
                .view(newRoomLayout)
                .buildAndAttach();

        ArrayList<Tile> newTiles = maps.getIDLayout(id);

        TileMap map = new TileMap(maps.getIDLayout(id), conductor, scoreText);

        var playerSprite = FXGL.getAssetLoader().loadTexture("rhythm-knight.png");

        double x = (maps.getMapOrigin(0).getX() - 35);
        double y = (maps.getMapOrigin(0).getY() - 95);
        playerSprite.setX(x);
        playerSprite.setY(y);
        playerSprite.setScaleX(.35);
        playerSprite.setScaleY(.35);
        Entity playerEntity = FXGL.entityBuilder()
                .at(x, y)
                .viewWithBBox(playerSprite)
                .buildAndAttach();
        playerEntity.setScaleX(.35);
        playerEntity.setScaleY(.35);
        getGameWorld().addEntity(playerEntity);
        GameView view = new GameView(playerSprite, 2);
        getGameScene().addGameView(view);
        GlobalSettings.setPlayerSprite(playerSprite);

        Entity uiBg = new EntityBuilder()
                .view("UI-Layout.png")
                .buildAndAttach();
    }

    private static void clearScene() {
        FXGL.getGameScene().clearGameViews();
    }
}
