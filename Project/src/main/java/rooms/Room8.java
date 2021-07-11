package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room8 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(23, tiles);

        int[] unused = {2, 3, 4, 7, 13, 17, 21, 24, 25, 27};
        removeUnused(unused, tiles);

        int[] gold = {10, 26};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {9, 14, 22};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {5, 6, 12};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {1, 11};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {18, 20};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
