package ui;

import initializers.Initializer;
import javafx.scene.control.Alert;

public class Notifier {
    /*
This method creates an alert when the player reaches the end of the dungeon.
 */
    public static void createWinAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Crawl Complete!");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("You crawled out of the dungeon! \nGold collected: "
                + Initializer.getGold());
        alert.showAndWait();
        System.exit(0);
    }
}
