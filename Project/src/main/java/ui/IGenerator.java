package ui;

import javafx.scene.Node;

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

}
