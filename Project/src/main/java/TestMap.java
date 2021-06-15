import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class TestMap extends GameApplication {
    Entity hex;
    Entity map;
    Rectangle hitbox;

    @Override
    protected void initSettings(GameSettings game) {
        game.setWidth(1920);
        game.setHeight(1080);
        game.setTitle("Rhythm Knight v0.0.1");
    }

    @Override
    protected void initUI() {
        map = new EntityBuilder()
                .view("1-1TileMap.png")
                .buildAndAttach();

        hex = new EntityBuilder()
                .at(95, 355)
                .view("hex.png")
                .buildAndAttach();

        hex.getViewComponent().addOnClickHandler(mouseEvent -> {
            hex.setOpacity(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
