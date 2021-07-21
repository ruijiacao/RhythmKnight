package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class ExitRoom extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        
        ArrayList<Tile> tile = super.buildTiles();
        
        setOrigin(27, TileType.EXITS_DUNGEON, tile);

        int[] unused = {3, 4, 7, 8, 10, 11, 13, 14, 16, 17, 18, 20, 21, 22, 24, 25, 26};
        removeUnused(unused, tile);
        int[] gold = {17, 19};
        setTileType(gold, TileType.GOLD, tile);

        return tile;

    }
}
