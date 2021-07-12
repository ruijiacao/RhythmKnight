package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room5 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(4, tiles);

        int[] unused = {2, 5, 7, 9, 11, 17, 24, 26};
        removeUnused(unused, tiles);

        int[] gold = {1, 6};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {15, 16, 20, 22};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {19, 21, 23};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {3, 14, 25, 27};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
