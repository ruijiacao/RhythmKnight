package initializers;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import settings.GlobalSettings;

/*
========== INITIALIZE THE LEVEL UI ==========
Initializes the UI for a level in the following order:
- Gets the player's name and displays it
- Gets the amount of gold on start based on difficulty and displays it
- Gets the amount of HP on start based on difficulty and displays it
- Gets the selected weapon and displays its visual
 */
public class LevelUIInitializer {
    private static Text userText;
    private static Text goldText;
    private static Text healthText;

    public static void initLevelUI() {
        userText = new Text(GlobalSettings.getPlayerName());
        userText.setX(200);
        userText.setY(1000);
        userText.setScaleX(3);
        userText.setScaleY(3);
        userText.setFill(Color.WHITE);
        FXGL.getGameScene().addUINodes(userText);

        goldText = new Text("Gold: \n" + (3 - GlobalSettings.getDifficulty()) * 10);
        goldText.setX(800);
        goldText.setY(1000);
        goldText.setScaleX(3);
        goldText.setScaleY(3);
        goldText.setFill(Color.GOLD);
        FXGL.getGameScene().addUINodes(goldText);

        healthText = new Text("HP: \n" + (3 - GlobalSettings.getDifficulty()) * 30);
        healthText.setX(1000);
        healthText.setY(1000);
        healthText.setScaleX(3);
        healthText.setScaleY(3);
        healthText.setFill(Color.MEDIUMVIOLETRED);
        FXGL.getGameScene().addUINodes(healthText);

        var weaponDisplay = FXGL.getAssetLoader().loadTexture("weapons/weapon"
                + GlobalSettings.getStartingWeapon() + ".png");
        weaponDisplay.setScaleX(3);
        weaponDisplay.setScaleY(3);
        weaponDisplay.setX(1600);
        weaponDisplay.setY(1080 - 90);
        FXGL.getGameScene().addUINode(weaponDisplay);

    }

    public static void updateGold(int newValue) {
        goldText.setText("Gold: \n" + newValue);
    }
}
