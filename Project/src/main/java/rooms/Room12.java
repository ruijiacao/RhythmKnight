package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room12 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L12_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L12_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L12_ORIGIN.setOrigin(true);
        L12_ORIGIN.setVisited(true);

        L12_TILES.add(L12_ORIGIN);

        return L12_TILES;
    }
}
