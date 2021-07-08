package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room14 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L14_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L14_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L14_ORIGIN.setOrigin(true);
        L14_ORIGIN.setVisited(true);

        L14_TILES.add(L14_ORIGIN);

        return L14_TILES;
    }
}
