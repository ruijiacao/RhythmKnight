package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room13 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(25, tiles);

        int[] unused = {1, 2, 3, 5, 6, 7, 9, 11, 17, 24, 27};
        removeUnused(unused, tiles);

        int[] gold = {15, 21};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {12, 16, 23};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {8, 13, 14, 20};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {4, 10};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {18, 26};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
