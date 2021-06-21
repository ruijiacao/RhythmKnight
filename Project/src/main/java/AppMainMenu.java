import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class AppMainMenu extends FXGLMenu {
    public AppMainMenu(MenuType type) {
        super(type);
        // menu image
        var menu = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");

        // selector
        var selector = FXGL.getAssetLoader().loadTexture("rest.png");
        selector.setX(540);
        selector.setY(635);

        // start game button
        Button startButton = new Button("Start Game");
        startButton.setLayoutX(650);
        startButton.setLayoutY(615);
        startButton.setPrefWidth(330);
        startButton.setPrefHeight(65);
        startButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        startButton.setOpacity(1);

        startButton.setOnMouseEntered(mouseEvent -> {
            selector.setX(540);
            selector.setY(635);
        });

        startButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("Starting game...");
            fireNewGame();
        });

        // game config button
        Button configButton = new Button("Game Config");
        configButton.setLayoutX(650);
        configButton.setLayoutY(700);
        configButton.setPrefWidth(540);
        configButton.setPrefHeight(65);
        configButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        configButton.setOpacity(1);

        configButton.setOnMouseEntered(mouseEvent -> {
            selector.setX(540);
            selector.setY(730);
        });

        configButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("Opening game config...");

            // Config Window
            Rectangle configWindow = new Rectangle(1280, 720);
            var configUI = FXGL.getAssetLoader().loadTexture("configUI.png");
            configWindow.setLayoutX(300);
            configWindow.setLayoutY(100);
            configWindow.setFill(Color.WHITE);
            configUI.setLayoutX(300);
            configUI.setLayoutY(100);

            // Close Button
            Button close = new Button("X");
            close.setLayoutX(350);
            close.setLayoutY(150);
            close.setScaleX(2.5);
            close.setScaleY(2.5);
            getContentRoot().getChildren().addAll(configWindow, configUI, close);

            close.setOnMouseClicked(mouseEvent1 -> {
                getContentRoot().getChildren().removeAll(configWindow, configUI, close);
            });
        });

        // exit button
        Button exitButton = new Button("Quit");
        exitButton.setLayoutX(650);
        exitButton.setLayoutY(790);
        exitButton.setPrefWidth(130);
        exitButton.setPrefHeight(65);
        exitButton.setOpacity(1);
        exitButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

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

