package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room10 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(12, tiles);

        int[] unused = {10, 21, 23, 24, 25, 26, 27};
        removeUnused(unused, tiles);

        int[] gold = {19};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {4, 6, 17, 18};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {3, 5, 8, 9, 11, 13, 15, 16};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {1, 2};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {20, 22};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
