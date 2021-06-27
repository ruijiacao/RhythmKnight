package ui;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import settings.GlobalSettings;

public class AppMainMenu extends FXGLMenu {
    private Texture menu;
    private Texture splash;

    //This pane contains the initial configuration screen
    private Pane container1 = new Pane();

    // This pane contains the welcome screen
    private Pane container2 = new Pane();
    private Pane maincontainer;
    private Button enter;

    public AppMainMenu(MenuType type) {
        super(type);

        //Welcome Screen
        splash = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");

        // menu image
        menu = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");

        // Enter Game
        enter = new Button("Start New Game");
        enter.setLayoutX(FXGL.getAppWidth() / 2 - 175);
        enter.setLayoutY(FXGL.getAppHeight() / 2 - 10);
        enter.setPrefWidth(330);
        enter.setPrefHeight(65);
        enter.setOpacity(1);
        enter.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        enter.setOnAction(e -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            maincontainer.getChildren().add(container1);
        });
        enter.setOnMouseEntered(e -> {
            enter.setOpacity(30);
        });
        enter.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
            enter.setOpacity(1);
        });

        // Start game button
        Button startButton = new Button();
        startButton.setLayoutX(FXGL.getAppWidth() / 2 - 110);
        startButton.setLayoutY(FXGL.getAppHeight() / 2 - 10);
        startButton.setOpacity(1);
        startButton.setText("Proceed");
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        startButton.setOnMouseClicked(mouseEvent -> {
            boolean canStart = true;
            if (GlobalSettings.getPlayerName() == null || GlobalSettings.getPlayerName().isBlank()
                    && GlobalSettings.getDifficulty() == -1
                    && GlobalSettings.getStartingWeapon() == -1) {
                createAlert("", "Please use the configuration menu to set your preferences "
                        + "before starting the game!");
                canStart = false;
            } else {
                if (GlobalSettings.getPlayerName() == null
                    || GlobalSettings.getPlayerName().isBlank()) {
                    createAlert("", "A name was not selected, please try again");
                    canStart = false;
                }
                if (GlobalSettings.getDifficulty() == -1) {
                    createAlert("", "A difficulty was not selected, please try again");
                    canStart = false;
                }
                if (GlobalSettings.getStartingWeapon() == -1) {
                    createAlert("", "A starting weapon was not selected, please try again");
                    canStart = false;
                }
            }
            if (canStart) {
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
                System.out.println("Starting game...");
                fireNewGame();
            }
        });

        // game config button
        Button configButton = new Button();
        configButton.setLayoutX(FXGL.getAppWidth() / 2 - 260);
        configButton.setLayoutY(FXGL.getAppHeight() / 2 + 75);
        configButton.setPrefWidth(540);
        configButton.setPrefHeight(65);
        configButton.setOpacity(1);
        configButton.setText("Game Configuration");
        configButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        configButton.setOnMouseClicked(mouseEvent -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            System.out.println("Opening game config...");

            // Config Window
            Rectangle configWindow = new Rectangle(1280, 720);
            var configUI = FXGL.getAssetLoader().loadTexture("configUI.png");
            configWindow.setLayoutX(300);
            configWindow.setLayoutY(100);
            configWindow.setFill(Color.WHITE);
            configUI.setLayoutX(300);
            configUI.setLayoutY(100);

            // Margin constants: hMargin = 320; vMargin = 180;

            // Knight graphic
            var knightSprite = FXGL.getAssetLoader().loadTexture("rhythm-knight.png");
            knightSprite.setLayoutX(400);
            knightSprite.setLayoutY(1080 - 820);
            knightSprite.setScaleX(.5);
            knightSprite.setScaleY(.5);

            // Textbox for name
            TextField tfEnterName = new TextField();
            tfEnterName.setAlignment(Pos.CENTER);
            // Note: These are not applicable for different resolutions!
            tfEnterName.setLayoutX(465);
            // Where the second number is the num pixels from bottom of screen
            tfEnterName.setLayoutY(1080 - 365);
            tfEnterName.setScaleX(2);
            tfEnterName.setScaleY(2);
            // If the name has been set previously
            if (GlobalSettings.getPlayerName() != null
                && !GlobalSettings.getPlayerName().isBlank()) {
                tfEnterName.setText(GlobalSettings.getPlayerName());
            }

            // Text for weapon selection
            Text weaponSelect = new Text();
            weaponSelect.setLayoutX(1060);
            weaponSelect.setLayoutY(1080 - 720);
            weaponSelect.setText("Select a weapon");
            weaponSelect.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            // Weapon selection
            ComboBox cbWeapons = new ComboBox();
            cbWeapons.setLayoutX(1100);
            cbWeapons.setLayoutY(1080 - 700);
            cbWeapons.getItems().add("Weapon 0");
            cbWeapons.getItems().add("Weapon 1");
            cbWeapons.getItems().add("Weapon 2");
            // Remember previous selection
            if (GlobalSettings.getStartingWeapon() != -1) {
                cbWeapons.setValue(cbWeapons.getItems().get(GlobalSettings.getStartingWeapon()));
            }

            // Text for weapon selection
            Text diffSelect = new Text();
            diffSelect.setLayoutX(1060);
            diffSelect.setLayoutY(1080 - 600);
            diffSelect.setText("Select a difficulty");
            diffSelect.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            // Difficulty Selection
            ComboBox cbDiff = new ComboBox();
            cbDiff.setLayoutX(1100);
            cbDiff.setLayoutY(1080 - 575);
            cbDiff.getItems().add("Easy");
            cbDiff.getItems().add("Medium");
            cbDiff.getItems().add("Hard");
            // Remember previous selection
            if (GlobalSettings.getDifficulty() != -1) {
                cbDiff.setValue(cbDiff.getItems().get(GlobalSettings.getDifficulty()));
            }

            // Close Button
            Button close = new Button("X");
            close.setLayoutX(350);
            close.setLayoutY(150);
            close.setScaleX(2.5);
            close.setScaleY(2.5);

            // Nodes, to be added (and later removed)
            Node[] configNodes = {configWindow, configUI, close, tfEnterName, cbWeapons,
                cbDiff, weaponSelect, diffSelect, knightSprite};
            getContentRoot().getChildren().addAll(configNodes);

            // Exit behavior
            close.setOnMouseClicked(mouseEvent1 -> {
                getContentRoot().getChildren().removeAll(configNodes);
                // Set player name
                GlobalSettings.setPlayerName(tfEnterName.getText());

                // Set difficulty
                int difficulty;
                if (cbDiff.getValue() != null) {
                    switch ((String) cbDiff.getValue()) {

                    case "Easy":
                        difficulty = 0;
                        break;
                    case "Medium":
                        difficulty = 1;
                        break;
                    case "Hard":
                        difficulty = 2;
                        break;
                    default:
                        difficulty = -1;
                    }
                    GlobalSettings.setDifficulty(difficulty);
                }
                if (cbWeapons.getValue() != null) {
                    // Set starting weapon
                    int startingWeapon = -1;
                    switch ((String) cbWeapons.getValue()) {

                    case "Weapon 0":
                        startingWeapon = 0;
                        break;
                    case "Weapon 1":
                        startingWeapon = 1;
                        break;
                    case "Weapon 2":
                        startingWeapon = 2;
                        break;
                    default:
                        startingWeapon = -1;
                    }
                    GlobalSettings.setStartingWeapon(startingWeapon);
                }
            });
        });

        // exit button
        Button exitButton = new Button();
        exitButton.setLayoutX(FXGL.getAppWidth() / 2 - 65);
        exitButton.setLayoutY(FXGL.getAppHeight() / 2 + 165);
        exitButton.setPrefWidth(130);
        exitButton.setPrefHeight(65);
        exitButton.setOpacity(1);
        exitButton.setText("Quit");
        exitButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        exitButton.setOnMouseClicked(mouseEvent -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            System.exit(0);
        });
        container1.getChildren().addAll(menu, startButton, configButton, exitButton);
        container2.getChildren().addAll(splash, enter
        );
        maincontainer = new StackPane(container2);

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

    public Button getEnter() {
        return enter;
    }

}
