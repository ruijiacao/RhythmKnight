package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room1 extends TemplateRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tile = super.buildTiles();
        setOrigin(26, tile);

        int[] unused = {2, 3, 10, 22, 14, 24, 25, 27};
        removeUnused(unused, tile);
        int[] gold = {17, 19};
        setTileType(gold, TileType.GOLD, tile);
        int[] monster = {5, 11, 20};
        setTileType(monster, TileType.MONSTER, tile);
        int[] exits = {1, 6, 7, 21};
        setTileType(exits, TileType.EXIT, tile);

        return tile;
    }
}
