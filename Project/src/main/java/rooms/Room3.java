package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room3 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L3_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L3_ORIGIN = new Tile(new Point2D(195, 360), TileType.ORIGIN);
        L3_ORIGIN.setOrigin(true);
        L3_ORIGIN.setVisited(true);

        L3_TILES.add(L3_ORIGIN);

        return L3_TILES;
    }
}
