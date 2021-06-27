package tilesystem;

import javafx.scene.text.Text;
import rhythm.Conductor;

import java.util.List;

public class TileMap {
    private int size = 0;
    private Conductor conductor;
    private Text scoreText;

    public TileMap(Conductor conductor, Text scoreText) {
        this.conductor = conductor;
        this.scoreText = scoreText;
    }

    public TileMap(List<Tile> tiles, Conductor conductor, Text scoreText) {
        this.conductor = conductor;
        this.scoreText = scoreText;
        for (Tile tile : tiles) {
            addTile(tile);
        }
    }

    public void addTile(Tile tile) {
        tile.displayOnScene(conductor, scoreText);
        size++;
    }

    public void removeTile(Tile tile) {
        tile.removeFromScene();
        size--;
    }
}