package tilesystem;

import javafx.geometry.Point2D;
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
    private ArrayList<ArrayList<Tile>> tilemaps;

    public MapDirectory() {
        ArrayList<IRoom> rooms = new ArrayList<>();
        IRoom start = new StartingRoom();
        rooms.add(start);
        IRoom room1 = new Room1();
        rooms.add(room1);
        IRoom room2 = new Room2();
        rooms.add(room2);
        IRoom room3 = new Room3();
        rooms.add(room3);
        IRoom room4 = new Room4();
        rooms.add(room4);
        IRoom room5 = new Room5();
        rooms.add(room5);
        IRoom room6 = new Room6();
        rooms.add(room6);
        IRoom room7 = new Room7();
        rooms.add(room7);
        IRoom room8 = new Room8();
        rooms.add(room8);
        IRoom room9 = new Room9();
        rooms.add(room9);
        IRoom room10 = new Room10();
        rooms.add(room10);
        IRoom room11 = new Room11();
        rooms.add(room11);
        IRoom room12 = new Room12();
        rooms.add(room12);
        IRoom room13 = new Room13();
        rooms.add(room13);
        IRoom room14 = new Room14();
        rooms.add(room14);
        IRoom room15 = new Room15();
        rooms.add(room15);
        IRoom exit = new ExitRoom();
        rooms.add(exit);
        IRoom exit2 = new ExitRoom2();
        rooms.add(exit2);

        tilemaps = new ArrayList<>();
        int i = 0;
        while (i < 18) {
            tilemaps.add(i, rooms.get(i).buildTiles());
            i++;
        }
    }
    public ArrayList<ArrayList<Tile>> getTilemaps() {
        return tilemaps;
    }

    public ArrayList<Tile> getStartMap() {
        return tilemaps.get(0);
    }

    public ArrayList<Tile> getIDLayout(int id) {
        return tilemaps.get(id);
    }

    public Point2D getMapOrigin(int id) {
        return tilemaps.get(id).get(0).getPosition();
    }
}
