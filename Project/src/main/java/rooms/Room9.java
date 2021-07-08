package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room9 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L9_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L9_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L9_ORIGIN.setOrigin(true);
        L9_ORIGIN.setVisited(true);

        L9_TILES.add(L9_ORIGIN);

        return L9_TILES;
    }
}
