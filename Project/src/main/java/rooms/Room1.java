package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room1 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L1_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L1_ORIGIN = new Tile(new Point2D(220, 375), TileType.ORIGIN);
        L1_ORIGIN.setOrigin(true);
        L1_ORIGIN.setVisited(true);

        L1_TILES.add(L1_ORIGIN);

        return L1_TILES;
    }
}
