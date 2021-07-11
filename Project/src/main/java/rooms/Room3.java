package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room3 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        setOrigin(26, TileType.EXIT, tiles);

        int[] unused = {4, 14, 17, 21, 25};
        removeUnused(unused, tiles);
        int[] gold = {2, 16};
        setTileType(gold, TileType.GOLD, tiles);
        int[] mystery = {3, 12, 18};
        setTileType(mystery, TileType.MYSTERY, tiles);
        int[] monster = {1, 8, 10, 15};
        setTileType(monster, TileType.MONSTER, tiles);
        int[] exits = {7, 13, 27};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
