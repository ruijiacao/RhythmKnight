import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import com.almasb.fxgl.time.TimerAction;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.File;

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


        Button enter = new Button("Start New Game");
        enter.setLayoutX(FXGL.getAppWidth() / 2 - 165);
        enter.setLayoutY(FXGL.getAppHeight() / 2 - 10);
        enter.setPrefWidth(330);
        enter.setPrefHeight(65);
        enter.setOpacity(1);
        enter.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

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

            boolean canStart = true;
            if (GlobalSettings.playerName == null || GlobalSettings.playerName.isBlank()) {
                createAlert("", "A name was not selected, please try again");
                canStart = false;
            }
            if (GlobalSettings.difficulty == -1) {
                createAlert("", "A difficulty was not selected, please try again");
                canStart = false;
            }
            if (GlobalSettings.startingWeapon == -1) {
                createAlert("", "A starting weapon was not selected, please try again");
                canStart = false;
            }
            if (canStart) {
                System.out.println("Starting game...");
                fireNewGame();
            }
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

            // Margin constants
            int hMargin = 320;
            int vMargin = 180;

            // Textbox for name
            TextField tfEnterName = new TextField();
            tfEnterName.setLayoutX(400);                // Note: These are not applicable for different resolutions!
            tfEnterName.setLayoutY(1080 - 400);         // Where the second number is the num pixels from bottom of screen
            tfEnterName.setScaleX(2);
            tfEnterName.setScaleY(2);

            // Text for weapon
            Label weapon = new Label("Select Your Weapon: ");
            weapon.setLayoutX(850);
            weapon.setLayoutY(387);
            weapon.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            // Weapon selection
            ComboBox cbWeapons = new ComboBox();
            cbWeapons.setLayoutX(1100);
            cbWeapons.setLayoutY(1080 - 700);
            cbWeapons.getItems().add("Weapon 1");
            cbWeapons.getItems().add("Weapon 2");
            cbWeapons.getItems().add("Weapon 3");

            //Text for Difficulty
            Label diffTxt = new Label("Difficulty Level: ");
            diffTxt.setLayoutX(909);
            diffTxt.setLayoutY(510);
            diffTxt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            // Difficulty selection
            ComboBox cbDiff = new ComboBox();
            cbDiff.setLayoutX(1100);
            cbDiff.setLayoutY(1080 - 575);
            cbDiff.getItems().add("Easy");
            cbDiff.getItems().add("Medium");
            cbDiff.getItems().add("Hard");

            // Close Button
            Button close = new Button("X");
            close.setLayoutX(350);
            close.setLayoutY(150);
            close.setScaleX(2.5);
            close.setScaleY(2.5);

            // Add and remove children
            getContentRoot().getChildren().addAll(configWindow, configUI, close, tfEnterName, cbWeapons, cbDiff, weapon, diffTxt);
            close.setOnMouseClicked(mouseEvent1 -> {
                getContentRoot().getChildren().removeAll(configWindow, configUI, close, tfEnterName, cbWeapons, cbDiff, weapon, diffTxt);
                // Set player name
                GlobalSettings.playerName = tfEnterName.getText();

                // Set difficulty
                int difficulty = -1;
                if (cbDiff.getValue() != null) {
                    switch((String) cbDiff.getValue()) {
                        case "Easy":
                            difficulty = 0;
                            break;
                        case "Medium":
                            difficulty = 1;
                            break;
                        case "Hard":
                            difficulty = 2;
                            break;
                    }
                    GlobalSettings.difficulty = difficulty;
                }
                if (cbWeapons.getValue() != null) {
                    // Set starting weapon
                    int startingWeapon = -1;
                    switch((String) cbWeapons.getValue()) {
                        case "Weapon 0":
                            startingWeapon = 0;
                            break;
                        case "Weapon 1":
                            startingWeapon = 1;
                            break;
                        case "Weapon 2":
                            startingWeapon = 2;
                            break;
                    }
                    GlobalSettings.startingWeapon = startingWeapon;
                }



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
        container1.getChildren().addAll(menu, startButton, configButton, exitButton, selector
        );
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

    public void createAlert(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        System.out.println("Alert created");
        alert.setTitle("Error");
        // Takes either a default message or the inputted
        String headerText = (header.isBlank()) ? "Can't start the game!" : header;
        alert.setHeaderText(headerText);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}