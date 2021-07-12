package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room7 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(27, tiles);

        int[] unused = {3, 5, 7, 10, 19, 24, 26};
        removeUnused(unused, tiles);

        int[] gold = {2, 18};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {1, 9, 15};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {12, 14, 21};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {25};
        setTileType(exits, TileType.EXIT, tiles);

        int[] lockedExits = {8, 16, 22};
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);

        return tiles;
    }
}
