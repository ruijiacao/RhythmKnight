package ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Collection;

public class SplashGen implements IGenerator<Node> {

    private Pane root;
    private Pane container1;

    public SplashGen(Pane root, Pane container1) {
        this.root = root;
        this.container1 = container1;
    }

    public Collection<Node> componentGen() {
        //Welcome Screen
        Texture splash = FXGL.getAssetLoader().loadTexture("logo-with-menu.png");

        // Enter Game
        Button enter = (Button) IGenerator.nodeGen(new Button("Start New Game"),
            FXGL.getAppWidth() / 2 - 175,
                FXGL.getAppHeight() / 2 - 10, 1);
        enter.setPrefWidth(330);
        enter.setPrefHeight(65);
        enter.setOpacity(1);
        enter.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        enter.setOnAction(e -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            root.getChildren().add(container1);
        });
        enter.setOnMouseEntered(e -> {
            enter.setOpacity(30);
        });
        enter.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
            enter.setOpacity(1);
        });

        // List of all nodes
        Node[] splashArr = {splash, enter};
        ArrayList<Node> splashNodes = new ArrayList<>();
        for (Node n : splashArr) {
            splashNodes.add(n);
        }

        return splashNodes;

    }
}
