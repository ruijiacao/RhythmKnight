package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room8 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L8_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L8_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L8_ORIGIN.setOrigin(true);
        L8_ORIGIN.setVisited(true);

        L8_TILES.add(L8_ORIGIN);

        return L8_TILES;
    }
}
