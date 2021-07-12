package rooms;

import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class StartingRoom extends TemplateRoom {

    @Override
    public ArrayList<Tile> buildTiles() {
        // x + 30, y + 25
        ArrayList<Tile> stTiles = super.buildTiles();
        setOrigin(11, TileType.EXIT, stTiles);

        int[] unused = {1, 3, 6, 9, 10, 13, 17, 19, 20, 22, 23, 24, 25, 26, 27};
        removeUnused(unused, stTiles);
        int[] gold = {8};
        setTileType(gold, TileType.GOLD, stTiles);
        int[] monster = {4, 5, 12, 18};
        setTileType(monster, TileType.MONSTER, stTiles);
        int[] exits = {2, 16, 21};
        setTileType(exits, TileType.EXIT, stTiles);

        Tile e1 = stTiles.get(11);
        e1.setPathID(1);

        Tile e2 = stTiles.get(21);
        e2.setPathID(2);

        Tile e3 = stTiles.get(16);
        e3.setPathID(3);

        Tile e4 = stTiles.get(2);
        e4.setPathID(4);

        return stTiles;
    }
}
