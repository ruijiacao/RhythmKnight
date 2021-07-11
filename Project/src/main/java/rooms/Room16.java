package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room16 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(16, tiles);

        int[] unused = {1, 3, 4, 13, 14, 24, 27};
        removeUnused(unused, tiles);

        int[] gold = {7, 9};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {5, 11, 20, 22};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {21, 23};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {2, 6, 26, 27};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
