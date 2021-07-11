package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room18 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(26, tiles);

        int[] unused = {3, 10, 21, 24, 25, 26, 27};
        removeUnused(unused, tiles);

        int[] gold = {8, 16};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {12, 17};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {5, 18, 19, 20};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {1, 2, 7, 15};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
