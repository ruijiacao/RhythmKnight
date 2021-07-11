package rooms;

import tilesystem.Tile;
import tilesystem.TileType;
import java.util.ArrayList;

public class Room2 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        int[] unused = {7, 14, 21, 24, 25, 27};
        removeUnused(unused, tiles);
        int[] gold = {3, 16, 26};
        setTileType(gold, TileType.GOLD, tiles);
        int[] mystery = {5, 11, 18};
        setTileType(mystery, TileType.MYSTERY, tiles);
        int[] monster = {17, 19, 23};
        setTileType(monster, TileType.MONSTER, tiles);
        int[] exits = {4, 10, 12, 22};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
