package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room11 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L11_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L11_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L11_ORIGIN.setOrigin(true);
        L11_ORIGIN.setVisited(true);

        L11_TILES.add(L11_ORIGIN);

        return L11_TILES;
    }
}
