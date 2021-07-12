package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room12 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(17, TileType.MYSTERY, tiles);

        int[] unused = {7, 4, 2, 3, 6, 9, 10, 20, 24, 21, 25};
        removeUnused(unused, tiles);

        int[] gold = {12, 19, 23};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {8, 15, 22};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {5, 11, 18, 26};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {1, 27};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {13, 14};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
