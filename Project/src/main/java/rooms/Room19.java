package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room19 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(25, TileType.EXIT, tiles);

        int[] unused = {3, 4, 6, 7, 8, 10, 11, 13, 14, 18, 19, 21, 22, 27};
        removeUnused(unused, tiles);

        int[] gold = {15, 26};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {9, 24};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {1, 5, 23};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {2, 8, 17};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
