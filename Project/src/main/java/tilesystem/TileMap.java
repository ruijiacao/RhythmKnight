package tilesystem;

import javafx.scene.text.Text;
import rhythm.Conductor;

import java.util.List;

public class TileMap {
    private int id;
    private int size = 0;
    private List<Tile> tiles;


    public TileMap(int id, List<Tile> tiles) {
        this.id = id;
        this.tiles = tiles;
        this.size = tiles.size();
    }

    public void displayTiles() {
        for (Tile tile: tiles
        ) {
            tile.displayOnScene();
        }
    }

    public void addTileListeners(Conductor conductor, Text scoreText) {
        for (Tile tile: tiles
        ) {
            tile.tileClick(conductor, scoreText);
        }
    }


    public void addTile(Tile tile) {
        tiles.add(tile);
        size++;
    }

    public void removeTile(Tile tile) {
        tiles.remove(tile);
        tile.removeFromScene();
        size--;
    }

    public int getId() {
        return id;
    }

    public Tile getTile(int id) {
        return tiles.get(id);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public int getSize() {
        return size;
    }
}