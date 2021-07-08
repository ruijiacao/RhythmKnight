package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room7 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L7_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L7_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L7_ORIGIN.setOrigin(true);
        L7_ORIGIN.setVisited(true);

        L7_TILES.add(L7_ORIGIN);

        return L7_TILES;
    }
}
