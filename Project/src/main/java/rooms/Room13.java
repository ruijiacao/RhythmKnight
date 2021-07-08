package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room13 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L13_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L13_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L13_ORIGIN.setOrigin(true);
        L13_ORIGIN.setVisited(true);

        L13_TILES.add(L13_ORIGIN);

        return L13_TILES;
    }
}
