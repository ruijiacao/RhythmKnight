package ui;

import javafx.scene.Node;
import javafx.scene.control.Alert;

import java.util.Collection;

public interface IGenerator<E> {

    public Collection<E> componentGen();

    public static Node nodeGen(Node node, int xpos, int ypos, double scale) {
        node.setLayoutX(xpos);
        node.setLayoutY(ypos);
        node.setScaleX(scale);
        node.setScaleY(scale);
        return node;
    }

    public static void createAlert(String header, String msg) {
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
