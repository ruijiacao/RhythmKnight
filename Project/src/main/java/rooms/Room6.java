package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room6 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L6_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L6_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L6_ORIGIN.setOrigin(true);
        L6_ORIGIN.setVisited(true);

        L6_TILES.add(L6_ORIGIN);

        return L6_TILES;
    }
}
