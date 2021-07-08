package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room10 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L10_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L10_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L10_ORIGIN.setOrigin(true);
        L10_ORIGIN.setVisited(true);

        L10_TILES.add(L10_ORIGIN);

        return L10_TILES;
    }
}
