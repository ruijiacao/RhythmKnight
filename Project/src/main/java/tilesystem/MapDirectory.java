package tilesystem;

import javafx.geometry.Point2D;
import rhythm.Conductor;
import rooms.*;

import java.util.ArrayList;

/*
===== HOW TO MAP LAYOUT IMAGES TO TILES =====
1) Open up any image editor of your choice (preferably Photoshop)
2) Open up a layout image with all the tiles
3) Select a tile you want to map. Grab the coordinates of the top left corner of the tile
4) Add 30 to the x coordinate and 25 to the y coordinate
5) Instantiate a new tile with the coordinates calculated and the type of tile it is
6) Add the tile to the ArrayList for that level
==============================================
 */
public class MapDirectory {
    private ArrayList<TileMap> tilemaps;

    public MapDirectory() {
        ArrayList<Room> rooms = new ArrayList<>();

        Room start = new Room(new int[][] {new int[]{11},
                new int[]{1, 3, 6, 9, 10, 13, 17, 19, 20, 22, 23, 24, 25, 26, 27},
                new int[]{8}, new int[]{4, 5, 12, 18},
                new int[]{2, 16, 21}, null, null});
        rooms.add(start);
        Room room1 = new Room(new int[][] {new int[]{26}, new int[]{2, 3, 10, 22, 14, 24, 25, 27},
                new int[]{17, 19}, new int[]{5, 11, 20}, new int[]{1, 6, 7, 21}, null, null});
        rooms.add(room1);
        Room room2 = new Room(new int[][] {null, new int[]{7, 14, 21, 24, 25, 27},
                new int[]{3, 16, 26}, new int[]{17, 19, 23},
                new int[]{4, 10, 12, 22}, new int[]{5, 11, 18}, null});
        rooms.add(room2);
        Room room3 = new Room(new int[][] {new int[]{26}, new int[]{4, 14, 17, 21, 25},
                new int[]{2, 16}, new int[]{1, 8, 10, 15}, new int[]{7, 13, 27}, new int[]{3, 12, 18}, null});
        rooms.add(room3);

        Room room4 = new Room(new int[][] {new int[]{3}, new int[]{3, 5, 8, 10, 13, 17, 22, 24, 27},
                new int[]{7, 19}, new int[]{1, 18, 27}, new int[]{4, 14, 20, 26}, new int[]{2, 15, 16}, null});
        rooms.add(room4);
        Room room5 = new Room(new int[][] {new int[]{4}, new int[]{2, 5, 7, 9, 11, 17, 24, 26},
                new int[]{1, 6}, new int[]{19, 21, 23}, new int[]{3, 14, 25, 27}, new int[]{15, 16, 20, 22}, null});
        rooms.add(room5);
        Room room6 = new Room(new int[][] {null, new int[]{4, 7, 21, 24, 27, 14, 26, 22, 25},
                new int[]{5, 13}, new int[]{15, 20}, new int[]{5, 13}, new int[]{11, 17}, new int[]{10, 16}});
        rooms.add(room6);
        Room room7 = new Room(new int[][] {new int[]{27}, new int[]{3, 5, 7, 10, 19, 24, 26},
                new int[]{2, 18}, new int[]{12, 14, 21}, new int[]{25}, new int[]{1, 9, 15}, new int[]{8, 16, 22}});
        rooms.add(room7);
        Room room8 = new Room(new int[][] {new int[]{23}, new int[]{2, 3, 4, 7, 13, 17, 21, 24, 25, 27},
                new int[]{10, 26}, new int[]{5, 6, 12}, new int[]{1, 11}, new int[]{9, 14, 22}, new int[]{18, 20}});
        rooms.add(room8);

        Room room9 = new Room(new int[][] {new int[]{27}, new int[]{4, 6, 7, 9, 10, 11, 13, 14, 18, 20, 21, 25},
                new int[]{5, 16}, new int[]{1, 2, 15, 26}, new int[]{3}, new int[]{12, 17, 19}, new int[]{22, 24}});
        rooms.add(room9);
        Room room10 = new Room(new int[][] {new int[]{12}, new int[]{10, 21, 23, 24, 25, 26, 27},
                new int[]{19}, new int[]{3, 5, 8, 9, 11, 13, 15, 16}, new int[]{1, 2},
                new int[]{4, 6, 17, 18}, new int[]{20, 22}});
        rooms.add(room10);
        Room room11 = new Room(new int[][] {new int[]{1}, new int[]{3, 6, 7, 9, 10, 14, 17, 18, 21, 23, 26},
                new int[]{2, 13}, new int[]{22, 24}, new int[]{25, 27}, new int[]{11, 19}, new int[]{5, 15}});
        rooms.add(room11);
        Room room12 = new Room(new int[][] {new int[]{17}, new int[]{7, 4, 2, 3, 6, 9, 10, 20, 24, 21, 25},
                new int[]{12, 19, 23}, new int[]{5, 11, 18, 26}, new int[]{1, 27},
                new int[]{8, 15, 22}, new int[]{13, 14}});
        rooms.add(room12);
        Room room13 = new Room(new int[][] {new int[]{25}, new int[]{1, 2, 3, 5, 6, 7, 9, 11, 17, 24, 27},
                new int[]{15, 21}, new int[]{8, 13, 14, 20}, new int[]{4, 10},
                new int[]{12, 16, 23}, new int[]{18, 26}});
        rooms.add(room13);
        Room room14 = new Room(new int[][] {new int[]{25}, new int[]{2, 3, 6, 7, 10, 14, 17, 21, 24, 26, 27},
                new int[]{11, 22}, new int[]{4, 5, 12, 23}, new int[]{1},
                new int[]{8, 9, 19}, new int[]{13, 18, 20}});
        rooms.add(room14);
        Room room15 = new Room(new int[][] {new int[]{22}, new int[]{3, 5, 10, 17, 21, 23, 24, 27},
                new int[]{8}, new int[]{1, 6, 16}, new int[]{2}, new int[]{7, 15, 20, 26}, new int[]{13, 19, 25}});
        rooms.add(room15);
        Room room16 = new Room(new int[][] {new int[]{16}, new int[]{1, 3, 4, 13, 14, 24, 27},
                new int[]{7, 9}, new int[]{21, 23}, new int[]{2, 6, 26, 27}, new int[]{5, 11, 20, 22}, null});
        rooms.add(room16);
        //Room start = new Room(new int[][] {new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}});
        // origin
        //      unused
        //      gold
        //      monster
        //      exits
        //      mystery
        //      lockedExits
        Room room17 = new Room(new int[][] {new int[]{23}, new int[]{3, 10, 17},
                new int[]{12, 19, 26}, new int[]{5, 11, 16, 18}, new int[]{7, 14, 21}, new int[]{4, 25}, null});
        rooms.add(room17);
        Room room18 = new Room(new int[][] {new int[]{26}, new int[]{3, 10, 21, 24, 25, 26, 27},
                new int[]{8, 16}, new int[]{5, 18, 19, 20}, new int[]{1, 2, 7, 15}, new int[]{12, 17}, null});
        rooms.add(room18);
        Room room19 = new Room(new int[][] {new int[]{25}, new int[]{3, 4, 6, 7, 8, 10, 11, 13, 14, 18, 19, 21, 22, 27},
                new int[]{15, 26}, new int[]{1, 5, 23}, new int[]{2, 8, 17}, new int[]{9, 24}, null});
        rooms.add(room19);
        Room room20 = new Room(new int[][] {new int[]{2}, new int[]{4, 15, 17, 20, 21, 23, 24, 25, 26, 27},
                new int[]{10, 12}, new int[]{6, 16, 18}, new int[]{1, 7, 19, 22}, new int[]{5, 13}, null});
        rooms.add(room20);
        Room exit = new Room(new int[][] {new int[]{27},
                new int[]{3, 4, 7, 8, 10, 11, 13, 14, 16, 17, 18, 20, 21, 22, 24, 25, 26},
                new int[]{17, 19}, new int[]{1, 2, 5, 6, 9, 12, 15, 23}, null, null, null});
        rooms.add(exit);
        Room exit2 = new Room(new int[][] {new int[]{25},
                new int[]{7, 14, 21, 3, 6, 10, 13, 17, 20, 24, 27, 26, 23, 19, 16}, new int[]{2, 1, 3}, null,
                null, null, null});
        rooms.add(exit2);

        tilemaps = new ArrayList<>();
        int i = 0;
        while (i < 23) {
            tilemaps.add(i, new TileMap(i, rooms.get(i).buildTiles()));
            i++;
        }
        // Link exits to randomized path mechanism
        tilemaps.get(0).getTiles().get(11).setPathID(1);
        tilemaps.get(0).getTiles().get(21).setPathID(2);
        tilemaps.get(0).getTiles().get(16).setPathID(3);
        tilemaps.get(0).getTiles().get(2).setPathID(4);
    }


    public TileMap getStartMap() {
        return tilemaps.get(0);
    }

    public TileMap getIDLayout(int id) {
        return tilemaps.get(id);
    }


    public Point2D getMapOrigin(int id) {
        return tilemaps.get(id).getTiles().get(0).getPosition();
    }

    public int getMapOriginTileID(int id) {
        return tilemaps.get(id).getTiles().get(0).getTileID();
    }
}
