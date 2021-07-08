package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room4 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L4_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L4_ORIGIN = new Tile(new Point2D(1585, 755), TileType.ORIGIN);
        L4_ORIGIN.setOrigin(true);
        L4_ORIGIN.setVisited(true);

        L4_TILES.add(L4_ORIGIN);

        return L4_TILES;
    }
}
