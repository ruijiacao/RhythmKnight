package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room20 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(2, tiles);

        int[] unused = {4, 15, 17, 20, 21, 23, 24, 25, 26, 27};
        removeUnused(unused, tiles);

        int[] gold = {10, 12};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {5, 13};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {6, 16, 18};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {1, 7, 19, 22};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
