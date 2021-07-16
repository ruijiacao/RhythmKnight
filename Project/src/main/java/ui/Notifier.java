package ui;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import initializers.Initializer;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import rhythm.Conductor;

public class Notifier {
    /*
This method creates an alert when the player reaches the end of the dungeon.
 */
    public static void createWinAlert() {
        /*
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Crawl Complete!");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("You crawled out of the dungeon! " +
                "\nGold collected: " + Initializer.getGold() +
                "\nCompleted in: " + Initializer.getTime().formatTime() +
                "\nRooms explored: " + GlobalSettings.getRoomCounter());
        alert.showAndWait();
        System.exit(0);
         */
        Rectangle dimBG = new Rectangle(1920,1080);
        dimBG.setFill(Color.BLACK);
        dimBG.setOpacity(.25);


        var winAlert = FXGL.getAssetLoader().loadTexture("final-win-screen.png");
        winAlert.setLayoutX(600);
        winAlert.setLayoutY(100);

        var fireworks1 = FXGL.getAssetLoader().loadTexture("fireworks.gif");
        fireworks1.setLayoutX(400);
        fireworks1.setLayoutY(960);
        fireworks1.setScaleX(6);
        fireworks1.setScaleY(6);

        var fireworks2 = FXGL.getAssetLoader().loadTexture("fireworks.gif");
        fireworks2.setLayoutX(1400);
        fireworks2.setLayoutY(960);
        fireworks2.setScaleX(6);
        fireworks2.setScaleY(6);

        winAlert.setScaleX(0);
        winAlert.setScaleY(0);


        Button runAgain = new Button("Run Again!");
        runAgain.setLayoutX(1175);
        runAgain.setLayoutY(475);
        runAgain.setOnMouseClicked(mouseEvent -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            AppMainMenu menu = new AppMainMenu(MenuType.MAIN_MENU);
            FXGL.getAudioPlayer().stopAllSounds();
            menu.fireGame();
        });

        Button close = new Button("Quit");
        close.setLayoutX(1175);
        close.setLayoutY(575);
        close.setOnMouseClicked(mouseEvent -> {
            FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("SelectSFX.mp3"));
            System.exit(0);
        });

        close.setScaleX(0);
        close.setScaleY(0);
        runAgain.setScaleX(0);
        runAgain.setScaleY(0);
        FXGL.getGameTimer().runAtInterval(() -> {
            winAlert.setScaleX(winAlert.getScaleX() + (1 / 20.0));
            winAlert.setScaleY(winAlert.getScaleY() + (1 / 20.0));
            close.setScaleX(close.getScaleX() + (2.5 / 20.0));
            close.setScaleY(close.getScaleY() + (2.5 / 20.0));
            runAgain.setScaleX(runAgain.getScaleX() + (2.5 / 20.0));
            runAgain.setScaleY(runAgain.getScaleY() + (2.5 / 20.0));
        }, Duration.millis(1), 20);

        Conductor.stopOST();
        FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("level-complete.mp3"));
        FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("fireworks.mp3"));
        FXGL.addUINode(dimBG);
        FXGL.addUINode(winAlert);
        FXGL.addUINode(fireworks1);
        FXGL.addUINode(fireworks2);
        FXGL.addUINode(close);
        FXGL.addUINode(runAgain);
    }
}
