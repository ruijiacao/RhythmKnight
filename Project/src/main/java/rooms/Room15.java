package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room15 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(22, tiles);

        int[] unused = {3, 5, 10, 17, 21, 23, 24, 27};
        removeUnused(unused, tiles);

        int[] gold = {8};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {7, 15, 20, 26};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {1, 6, 16};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {2};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {13, 19, 25};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
