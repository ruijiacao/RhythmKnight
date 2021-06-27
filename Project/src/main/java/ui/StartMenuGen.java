package ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Collection;

public class StartMenuGen implements IGenerator<Node> {

    private Pane root;
    private Pane maincontainer;
    private Pane container1;
    private Pane container2;

    public Collection<Node> splashGen() {
        return null;
    }

    // Main menu, not splash
    public Collection<Node> componentGenC1() {
        // menu image
        menu = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");
    }
    public Collection<Node> componentGen() {
        return null;
    }

}
