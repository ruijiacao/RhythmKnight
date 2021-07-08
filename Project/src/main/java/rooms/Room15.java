package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room15 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L15_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L15_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L15_ORIGIN.setOrigin(true);
        L15_ORIGIN.setVisited(true);

        L15_TILES.add(L15_ORIGIN);

        return L15_TILES;
    }
}
