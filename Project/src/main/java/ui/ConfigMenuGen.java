package ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import settings.GlobalSettings;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Collection;

public class ConfigMenuGen implements IGenerator<Node> {

    private Pane root;

    public ConfigMenuGen(Pane root) {
        this.root = root;
    }

    public Collection<Node> componentGen() {
        // Config Window
        Rectangle configWindow = (Rectangle) IGenerator.nodeGen(new Rectangle(1280, 720),
            300, 100, 1);
        configWindow.setFill(Color.WHITE);
        var configUI = FXGL.getAssetLoader().loadTexture("configUI.png");
        configUI.setLayoutX(300);
        configUI.setLayoutY(100);

        // Knight graphic
        var knightSprite = FXGL.getAssetLoader().loadTexture("rhythm-knight.png");
        knightSprite.setLayoutX(400);
        knightSprite.setLayoutY(1080 - 820);
        knightSprite.setScaleX(.5);
        knightSprite.setScaleY(.5);

        // Textbox for name; set initial value if previously chosen
        TextField tfEnterName = (TextField) IGenerator.nodeGen(new TextField(), 465, 715, 2);
        tfEnterName.setAlignment(Pos.CENTER);
        if (GlobalSettings.getPlayer().getName() != null
            && !GlobalSettings.getPlayer().getName().isBlank()) {
            tfEnterName.setText(GlobalSettings.getPlayer().getName());
        }


        // Weapon selection header
        Text weaponSelect = (Text) IGenerator.nodeGen(new Text(), 1060, 360, 1);
        weaponSelect.setText("Select a weapon");
        weaponSelect.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

        // Weapon selection; set initial value if previously chosen
        ComboBox cbWeapons = (ComboBox) IGenerator.nodeGen(new ComboBox(), 1100, 380, 1);
        cbWeapons.getItems().add("Knife");
        cbWeapons.getItems().add("Sword");
        cbWeapons.getItems().add("Hammer");
        if (GlobalSettings.getStartingWeapon() != -1) {
            cbWeapons.setValue(cbWeapons.getItems().get(GlobalSettings.getStartingWeapon()));
        }

        // Difficulty selection header
        Text diffSelect = (Text) IGenerator.nodeGen(new Text(), 1060, 480, 1);
        diffSelect.setText("Select a difficulty");
        diffSelect.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

        // Difficulty Selection; set initial value if previously chosen
        ComboBox cbDiff = (ComboBox) IGenerator.nodeGen(new ComboBox(), 1100, 505, 1);
        cbDiff.getItems().add("Easy");
        cbDiff.getItems().add("Medium");
        cbDiff.getItems().add("Hard");
        if (GlobalSettings.getDifficulty() != -1) {
            cbDiff.setValue(cbDiff.getItems().get(GlobalSettings.getDifficulty()));
        }

        // Close Button
        Button close = (Button) IGenerator.nodeGen(new Button("X"), 350, 150, 2.5);

        // List of all nodes
        Node[] configNodeArray = {configWindow, configUI, close, tfEnterName,
            cbWeapons, cbDiff, weaponSelect, diffSelect, knightSprite};
        ArrayList<Node> configNodes = new ArrayList<>();
        for (Node n : configNodeArray) {
            configNodes.add(n);
        }

        // Exit behavior
        close.setOnMouseClicked(mouseEvent1 -> {
            // Delete nodes
            root.getChildren().removeAll(configNodes);

            // Store player preferences in settings
            GlobalSettings.setPlayerName(tfEnterName.getText());
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
                    break;
                }
                GlobalSettings.setDifficulty(difficulty);
            }
            if (cbWeapons.getValue() != null) {
                int startingWeapon;
                switch ((String) cbWeapons.getValue()) {

                case "Knife":
                    startingWeapon = 0;
                    break;
                case "Sword":
                    startingWeapon = 1;
                    break;
                case "Hammer":
                    startingWeapon = 2;
                    break;
                default:
                    startingWeapon = -1;
                    break;
                }
                GlobalSettings.getPlayer().setWeapon(startingWeapon);
            }
        });
        return configNodes;
    }
}