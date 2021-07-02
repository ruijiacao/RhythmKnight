package tilesystem;

import java.util.ArrayList;

public class MapDirectory {
    private static ArrayList<TileMap> tilemaps;

    public MapDirectory() {
        tilemaps = new ArrayList<>(16);
        tilemaps.add(0, null);

        // tilemap for layout 1

        // tilemap for layout 2

        // tilemap for layout 3

        // tilemap for layout 4

        // tilemap for layout 5

        // tilemap for layout 6

        // tilemap for layout 7

        // tilemap for layout 8

        // tilemap for layout 9

        // tilemap for layout 10

        // tilemap for layout 11

        // tilemap for layout 12

        // tilemap for layout 13

        // tilemap for layout 14

        // tilemap for layout 15

    }
    public static ArrayList<TileMap> getTilemaps() {
        return tilemaps;
    }
}
