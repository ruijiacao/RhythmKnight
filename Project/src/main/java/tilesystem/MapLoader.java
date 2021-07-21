package tilesystem;


import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.text.Text;
import javafx.util.Duration;
import monsters.Monster;
import rhythm.Animator;
import rhythm.Conductor;
import settings.GlobalSettings;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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

        Texture newRoomLayout = FXGL.getAssetLoader().loadTexture("newDungeonBG.png");
        Entity layout = new EntityBuilder()
                .view(newRoomLayout)
                .buildAndAttach();

        TileMap tileMap = GlobalSettings.getMapDirectory().getIDLayout(id);

        for (Tile tile : tileMap.getTiles()) {
            if (tile.isMonster()) {
                GlobalSettings.addActiveMonster(tile.getMonster());
            }
        }

        tileMap.displayTiles();
        tileMap.addTileListeners(conductor, scoreText);

        var playerSprite = FXGL.getAssetLoader().loadTexture("rhythm-knight.png");

        double x = (GlobalSettings.getMapDirectory().getMapOrigin(id).getX() - 35);
        double y = (GlobalSettings.getMapDirectory().getMapOrigin(id).getY() - 95);
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
        GlobalSettings.setCurrentMap(tileMap);
        GlobalSettings.setCurrPlayerTile(0);

        AtomicInteger i = new AtomicInteger();
        Animator anim = new Animator();
        FXGL.run(() -> {
            anim.tileDance(GlobalSettings.getCurrentMap().getTile(i.get()).getTileTexture());
            i.set(i.get() + 1);
        }, Duration.millis(1), 27);
    }

    private static void clearScene() {
        FXGL.getGameScene().clearGameViews();
        GlobalSettings.clearActiveMonsters();
    }
}
