package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room11 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(1, TileType.MYSTERY, tiles);

        int[] unused = {3, 6, 7, 9, 10, 14, 17, 18, 21, 23, 26};
        removeUnused(unused, tiles);

        int[] gold = {2, 13};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {11, 19};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {22, 24};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {25, 27};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {5, 15};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
