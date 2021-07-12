package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room14 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(25, tiles);

        int[] unused = {2, 3, 6, 7, 10, 14, 17, 21, 24, 26, 27};
        removeUnused(unused, tiles);

        int[] gold = {11, 22};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {8, 9, 19};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {4, 5, 12, 23};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {1};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {13, 18, 20};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
