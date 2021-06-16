import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;


public class TestMap extends GameApplication {

    @Override
    protected void initSettings(GameSettings game) {
        game.setWidth(1920);
        game.setHeight(1080);
        game.setTitle("Rhythm Knight v0.0.1");
    }

    private Entity hex;
    @Override
    protected void initGame() {
        var hex = FXGL.getAssetLoader().loadTexture("hex.png");
        hex.setX(95);
        hex.setY(355);
        hex.setOpacity(0);

        var hex1 = FXGL.getAssetLoader().loadTexture("hex.png");
        hex1.setX(510);
        hex1.setY(280);
        hex1.setOpacity(0);

        FXGL.getGameScene().addUINodes(hex, hex1);
        Sound snare = FXGL.getAssetLoader().loadSound("snare01.wav");

        enterScene(hex, snare);
        FXGL.runOnce(() -> {enterScene(hex1, snare);}, Duration.millis(300));
    }

    @Override
    protected void initUI() {
        Entity map = new EntityBuilder()
                .view("1-1TileMap.png")
                .buildAndAttach();

    }

    public void enterScene(Texture tile, Sound sfx) {
        tile.setScaleX(2);
        tile.setScaleY(2);
        AtomicInteger frame = new AtomicInteger();

        FXGL.run(() -> {
            frame.addAndGet(1);
            if (frame.get() >= 50 && frame.get() < 60) {
                tile.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                    tile.setOpacity(0);
                    FXGL.getAudioPlayer().playSound(sfx);
                });
            }
            tile.setOpacity(tile.getOpacity() + .016);
            tile.setScaleX(tile.getScaleX() - .016);
            tile.setScaleY(tile.getScaleY() - .016);
        }, Duration.millis(.5), 60);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
