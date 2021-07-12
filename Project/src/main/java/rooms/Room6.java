package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room6 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        int[] unused = {4, 7, 21, 24, 27, 14, 26, 22, 25};
        removeUnused(unused, tiles);

        int[] gold = {5, 13};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {11, 17};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {15, 20};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {5, 13};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {10, 16};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
