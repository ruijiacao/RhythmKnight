package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room9 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(27, TileType.EXIT, tiles);

        int[] unused = {4, 6, 7, 9, 10, 11, 13, 14, 18, 20, 21, 25};
        removeUnused(unused, tiles);

        int[] gold = {5, 16};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {12, 17, 19};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {1, 2, 15, 26};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {3};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {22, 24};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
