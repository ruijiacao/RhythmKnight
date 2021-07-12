package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room4 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(3, tiles);

        int[] unused = {3, 5, 8, 10, 13, 17, 22, 24, 27};
        removeUnused(unused, tiles);

        int[] gold = {7, 19};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {2, 15, 16};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {1, 18, 27};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {4, 14, 20, 26};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
