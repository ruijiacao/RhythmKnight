package ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Collection;

public class StartMenuGen implements IGenerator<Node> {

    private Pane root;

    public StartMenuGen(Pane root) {
        this.root = root;
    }

    // Main menu, not splash
    public Collection<Node> componentGen() {
        // menu image
        var menu = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");

        // Start game button
        Button startButton = (Button) IGenerator.nodeGen(new Button(), FXGL.getAppWidth() / 2 - 110,
                FXGL.getAppHeight() / 2 - 10, 1);
        startButton.setOpacity(1);
        startButton.setText("Proceed");
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        // game config button
        Button configButton = (Button) IGenerator.nodeGen(new Button(),
            FXGL.getAppWidth() / 2 - 260,
                FXGL.getAppHeight() / 2 + 75, 1);
        configButton.setPrefWidth(540);
        configButton.setPrefHeight(65);
        configButton.setOpacity(1);
        configButton.setText("Game Configuration");
        configButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        configButton.setOnMouseClicked(mouseEvent -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            System.out.println("Opening game config...");


            //    {configWindow, configUI, close, tfEnterName, cbWeapons, cbDiff, weaponSelect,
            //    diffSelect, knightSprite}

            ConfigMenuGen configMenu = new ConfigMenuGen(root);
            ArrayList<Node> configNodes = (ArrayList<Node>) configMenu.componentGen();
            root.getChildren().addAll(configNodes);

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

        // List of all nodes
        Node[] startArray = {menu, startButton, configButton, exitButton};
        ArrayList<Node> startNodes = new ArrayList<>();
        for (Node n : startArray) {
            startNodes.add(n);
        }

        return startNodes;
    }

}
