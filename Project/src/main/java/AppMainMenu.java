import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AppMainMenu extends FXGLMenu {
    private Texture menu;
    private Texture splash;
    //This pane contains the initial configuration screen
    private Pane container1 = new Pane();
    // This pane contains the welcome screen
    private Pane container2 = new Pane();
    private Pane maincontainer;

    public AppMainMenu(MenuType type) {
        super(type);

        //Welcome Screen
        splash = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");

        // Enter Game
        Button enter = new Button("Start New Game");
        enter.setLayoutX(FXGL.getAppWidth() / 2 - 165);
        enter.setLayoutY(FXGL.getAppHeight() / 2 - 10);
        enter.setPrefWidth(330);
        enter.setPrefHeight(65);
        enter.setOpacity(1);
        enter.setFont(Font.font("Times New Roman", 30));
        enter.setStyle("-fx-text-weight: Bold");

        // menu image
        menu = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");

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
        startButton.setOpacity(1);
        startButton.setText("Proceed!");
        startButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        startButton.setOnMouseEntered(mouseEvent -> {
            selector.setX(540);
            selector.setY(635);
        });

        startButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("Starting game...");
            fireNewGame();
        });

        // game config button
        Button configButton = new Button();
        configButton.setLayoutX(650);
        configButton.setLayoutY(700);
        configButton.setPrefWidth(540);
        configButton.setPrefHeight(65);
        configButton.setOpacity(1);
        configButton.setText("Game Configuration");
        configButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

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
        Button exitButton = new Button();
        exitButton.setLayoutX(650);
        exitButton.setLayoutY(790);
        exitButton.setPrefWidth(130);
        exitButton.setPrefHeight(65);
        exitButton.setOpacity(1);
        exitButton.setText("Quit");
        exitButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        exitButton.setOnMouseEntered(mouseEvent -> {
            selector.setX(540);
            selector.setY(800);
        });

        exitButton.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });
        container1.getChildren().addAll(menu, startButton, configButton, exitButton, selector);
        container2.getChildren().addAll(splash, enter
        );
        maincontainer = new StackPane(container2);
        enter.setOnAction(e -> {
            maincontainer.getChildren().add(container1);
        });
        enter.setOnMouseEntered(e -> {
            enter.setOpacity(30);
        });
        enter.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
            enter.setOpacity(1);
        });

        getContentRoot().getChildren().addAll(maincontainer);
    }
}