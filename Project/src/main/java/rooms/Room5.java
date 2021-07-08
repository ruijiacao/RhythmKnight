package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room5 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L5_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L5_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L5_ORIGIN.setOrigin(true);
        L5_ORIGIN.setVisited(true);

        L5_TILES.add(L5_ORIGIN);

        return L5_TILES;
    }
}
