package ui;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import settings.GlobalSettings;

import java.util.ArrayList;

public class AppMainMenu extends FXGLMenu {

    public AppMainMenu(MenuType type) {
        super(type);

        // Create Menus
        StartMenuGen startMenuGen = new StartMenuGen(getContentRoot());
        ArrayList<Node> startMenuNodes = (ArrayList<Node>) startMenuGen.componentGen();
        // Append protected "fireGame" method behavior to startButton
        startMenuNodes.get(1).setOnMouseClicked(mouseEvent -> {
            if (GlobalSettings.canStart()) {
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
                System.out.println("Starting game...");
                fireNewGame();
            }
        });

        // Nest Main Menu inside of Splash Menu
        Pane mainMenuContainer = new Pane();
        mainMenuContainer.getChildren().addAll(startMenuNodes);
        SplashGen splashGen = new SplashGen(getContentRoot(), mainMenuContainer);

        // Adds splash screen (with nested other menus) to the root
        getContentRoot().getChildren().addAll(splashGen.componentGen());
    }

}
