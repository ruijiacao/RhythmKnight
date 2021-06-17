import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class AppMainMenu extends FXGLMenu {
    public AppMainMenu(MenuType type) {
        super(type);
        // menu image
        var menu = FXGL.getAssetLoader().loadTexture("main-menu.png");

        // selector
        var selector = FXGL.getAssetLoader().loadTexture("rest.png");
        selector.setX(540);
        selector.setY(635);

        // start game button
        Button startButton = new Button();
        startButton.setLayoutX(650);
        startButton.setLayoutY(615);
        startButton.setPrefWidth(330);
        startButton.setPrefHeight(65);
        startButton.setOpacity(0);

        startButton.setOnMouseEntered(mouseEvent -> {
            selector.setX(540);
            selector.setY(635);
        });

        startButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("Starting game...");
        });

        // game config button
        Button configButton = new Button();
        configButton.setLayoutX(650);
        configButton.setLayoutY(700);
        configButton.setPrefWidth(540);
        configButton.setPrefHeight(65);
        configButton.setOpacity(0);

        configButton.setOnMouseEntered(mouseEvent -> {
            selector.setX(540);
            selector.setY(730);
        });

        configButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("Starting game...");
        });

        // exit button
        Button exitButton = new Button();
        exitButton.setLayoutX(650);
        exitButton.setLayoutY(790);
        exitButton.setPrefWidth(130);
        exitButton.setPrefHeight(65);
        exitButton.setOpacity(0);

        exitButton.setOnMouseEntered(mouseEvent -> {
            selector.setX(540);
            selector.setY(800);
        });

        exitButton.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        getContentRoot().getChildren().addAll(menu, startButton, configButton, exitButton, selector);
    }
}

