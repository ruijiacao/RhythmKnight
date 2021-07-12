package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room17 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = super.buildTiles();

        setOrigin(23, TileType.EXIT, tiles);

        int[] unused = {3, 10, 17};
        removeUnused(unused, tiles);

        int[] gold = {12, 19, 26};
        setTileType(gold, TileType.GOLD, tiles);

        int[] mystery = {4, 25};
        setTileType(mystery, TileType.MYSTERY, tiles);

        int[] monster = {5, 11, 16, 18};
        setTileType(monster, TileType.MONSTER, tiles);

        int[] exits = {7, 14, 21};
        setTileType(exits, TileType.EXIT, tiles);

        return tiles;
    }
}
