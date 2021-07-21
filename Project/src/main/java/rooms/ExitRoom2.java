package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class ExitRoom2 extends TemplateRoom {

    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        ArrayList<Tile> tile = super.buildTiles();
        
        setOrigin(25, TileType.EXITS_DUNGEON, tile);

        int[] unused = {7, 14, 21, 3, 6, 10, 13, 17, 20, 24, 27, 26, 23, 19, 16};
        removeUnused(unused, tile);
        int[] gold = {2, 1, 3};
        setTileType(gold, TileType.GOLD, tile);

        return tile;

    }
    
}
