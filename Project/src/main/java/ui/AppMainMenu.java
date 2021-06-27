package ui;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder;
import settings.GlobalSettings;

import java.util.ArrayList;

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
        enter = (Button) IGenerator.nodeGen(new Button("Start New Game"), FXGL.getAppWidth() / 2 - 175,
                FXGL.getAppHeight() / 2 - 10, 1);
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
        Button startButton = (Button) IGenerator.nodeGen(new Button(), FXGL.getAppWidth() / 2 - 110,
                FXGL.getAppHeight() / 2 - 10, 1);
        startButton.setOpacity(1);
        startButton.setText("Proceed");
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        startButton.setOnMouseClicked(mouseEvent -> {
            boolean canStart = true;
            if (GlobalSettings.playerName == null || GlobalSettings.playerName.isBlank()
                    && GlobalSettings.difficulty == -1
                    && GlobalSettings.startingWeapon == -1) {
                createAlert("", "Please use the configuration menu to set your preferences "
                        + "before starting the game!");
                canStart = false;
            }
            else {
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
            }
            if (canStart) {
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
                System.out.println("Starting game...");
                fireNewGame();
            }
        });

        // game config button
        Button configButton = (Button) IGenerator.nodeGen(new Button(), FXGL.getAppWidth() / 2 - 260,
                FXGL.getAppHeight() / 2 + 75, 1);
        configButton.setPrefWidth(540);
        configButton.setPrefHeight(65);
        configButton.setOpacity(1);
        configButton.setText("Game Configuration");
        configButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        configButton.setOnMouseClicked(mouseEvent -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            System.out.println("Opening game config...");

            // Nodes, to be added (and later removed)
            // {configWindow, configUI, close, tfEnterName, cbWeapons, cbDiff, weaponSelect, diffSelect, knightSprite}
            ConfigMenuGen configMenu = new ConfigMenuGen(getContentRoot());
            ArrayList<Node> configNodes = (ArrayList<Node>) configMenu.componentGen();
            getContentRoot().getChildren().addAll(configNodes);

        });

        // exit button
        Button exitButton = (Button) IGenerator.nodeGen(new Button(), FXGL.getAppWidth() / 2 - 65,
                FXGL.getAppHeight() / 2 + 165, 1);
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
        container2.getChildren().addAll(splash, enter);
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
