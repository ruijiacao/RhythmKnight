package tilesystem;

import javafx.geometry.Point2D;
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
        tilemaps = new ArrayList<>(16);

        /*
        ===== START =====
         */
        ArrayList<Tile> ST_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile ST_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        ST_ORIGIN.setOrigin(true);
        ST_ORIGIN.setVisited(true);

        Tile ST_NORM1 = new Tile(new Point2D(620, 225), TileType.UNVISITED);
        Tile ST_NORM2 = new Tile(new Point2D(995, 215), TileType.UNVISITED);
        Tile ST_NORM3 = new Tile(new Point2D(620, 440), TileType.UNVISITED);

        Tile ST_ATK1 = new Tile(new Point2D(1180, 325), TileType.UNVISITED);
        Tile ST_ATK2 = new Tile(new Point2D(1185, 545), TileType.UNVISITED);
        Tile ST_ATK3 = new Tile(new Point2D(430, 330), TileType.UNVISITED);
        Tile ST_ATK4 = new Tile(new Point2D(810, 545), TileType.UNVISITED);

        Tile ST_GLD1 = new Tile(new Point2D(1000, 435), TileType.UNVISITED);

        Tile ST_EXIT1 = new Tile(new Point2D(1340, 190), TileType.EXIT);
        ST_EXIT1.setExit(true);
        Tile ST_EXIT2 = new Tile(new Point2D(210, 200), TileType.EXIT);
        ST_EXIT2.setExit(true);
        Tile ST_EXIT3 = new Tile(new Point2D(600, 630), TileType.EXIT);
        ST_EXIT3.setExit(true);
        Tile ST_EXIT4 = new Tile(new Point2D(1340, 630), TileType.EXIT);
        ST_EXIT4.setExit(true);

        ST_TILES.add(ST_ORIGIN);

        ST_TILES.add(ST_NORM1);
        ST_TILES.add(ST_NORM2);
        ST_TILES.add(ST_NORM3);

        ST_TILES.add(ST_ATK1);
        ST_TILES.add(ST_ATK2);
        ST_TILES.add(ST_ATK3);
        ST_TILES.add(ST_ATK4);

        ST_TILES.add(ST_GLD1);

        ST_TILES.add(ST_EXIT1);
        ST_TILES.add(ST_EXIT2);
        ST_TILES.add(ST_EXIT3);
        ST_TILES.add(ST_EXIT4);

        tilemaps.add(0, ST_TILES);

        /*
        ===== LAYOUT 1 =====
         */
        ArrayList<Tile> L1_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L1_ORIGIN = new Tile(new Point2D(220, 375), TileType.ORIGIN);
        L1_ORIGIN.setOrigin(true);
        L1_ORIGIN.setVisited(true);

        L1_TILES.add(L1_ORIGIN);

        tilemaps.add(1, L1_TILES);

        /*
        ===== LAYOUT 2 =====
         */
        ArrayList<Tile> L2_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L2_ORIGIN = new Tile(new Point2D(1535, 45), TileType.ORIGIN);
        L2_ORIGIN.setOrigin(true);
        L2_ORIGIN.setVisited(true);

        L2_TILES.add(L2_ORIGIN);

        tilemaps.add(2, L2_TILES);

        /*
        ===== LAYOUT 3 =====
         */
        ArrayList<Tile> L3_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L3_ORIGIN = new Tile(new Point2D(195, 360), TileType.ORIGIN);
        L3_ORIGIN.setOrigin(true);
        L3_ORIGIN.setVisited(true);

        L3_TILES.add(L3_ORIGIN);

        tilemaps.add(3, L3_TILES);

        /*
        ===== LAYOUT 4 =====
         */
        ArrayList<Tile> L4_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L4_ORIGIN = new Tile(new Point2D(1585, 755), TileType.ORIGIN);
        L4_ORIGIN.setOrigin(true);
        L4_ORIGIN.setVisited(true);

        L4_TILES.add(L4_ORIGIN);

        tilemaps.add(4, L4_TILES);

        /*
        ===== LAYOUT 5 =====
         */
        ArrayList<Tile> L5_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L5_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L5_ORIGIN.setOrigin(true);
        L5_ORIGIN.setVisited(true);

        L5_TILES.add(L5_ORIGIN);

        tilemaps.add(5, L5_TILES);

        /*
        ===== LAYOUT 6 =====
         */
        ArrayList<Tile> L6_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L6_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L6_ORIGIN.setOrigin(true);
        L6_ORIGIN.setVisited(true);

        L6_TILES.add(L6_ORIGIN);

        tilemaps.add(6, L6_TILES);

        /*
        ===== LAYOUT 7 =====
         */
        ArrayList<Tile> L7_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L7_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L7_ORIGIN.setOrigin(true);
        L7_ORIGIN.setVisited(true);

        L7_TILES.add(L7_ORIGIN);

        tilemaps.add(7, L7_TILES);

        /*
        ===== LAYOUT 8 =====
         */
        ArrayList<Tile> L8_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L8_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L8_ORIGIN.setOrigin(true);
        L8_ORIGIN.setVisited(true);

        L8_TILES.add(L8_ORIGIN);

        tilemaps.add(8, L8_TILES);

        /*
        ===== LAYOUT 9 =====
         */
        ArrayList<Tile> L9_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L9_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L9_ORIGIN.setOrigin(true);
        L9_ORIGIN.setVisited(true);

        L9_TILES.add(L9_ORIGIN);

        tilemaps.add(9, L9_TILES);

        /*
        ===== LAYOUT 10 =====
         */
        ArrayList<Tile> L10_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L10_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L10_ORIGIN.setOrigin(true);
        L10_ORIGIN.setVisited(true);

        L10_TILES.add(L10_ORIGIN);

        tilemaps.add(10, L10_TILES);

        /*
        ===== LAYOUT 11 =====
         */
        ArrayList<Tile> L11_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L11_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L11_ORIGIN.setOrigin(true);
        L11_ORIGIN.setVisited(true);

        L11_TILES.add(L11_ORIGIN);

        tilemaps.add(11, L11_TILES);

        /*
        ===== LAYOUT 12 =====
         */
        ArrayList<Tile> L12_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L12_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L12_ORIGIN.setOrigin(true);
        L12_ORIGIN.setVisited(true);

        L12_TILES.add(L12_ORIGIN);

        tilemaps.add(12, L12_TILES);

        /*
        ===== LAYOUT 13 =====
         */
        ArrayList<Tile> L13_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L13_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L13_ORIGIN.setOrigin(true);
        L13_ORIGIN.setVisited(true);

        L13_TILES.add(L13_ORIGIN);

        tilemaps.add(13, L13_TILES);

        /*
        ===== LAYOUT 14 =====
         */
        ArrayList<Tile> L14_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L14_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L14_ORIGIN.setOrigin(true);
        L14_ORIGIN.setVisited(true);

        L14_TILES.add(L14_ORIGIN);

        tilemaps.add(14, L14_TILES);

        /*
        ===== LAYOUT 15 =====
         */
        ArrayList<Tile> L15_TILES = new ArrayList<>();

        // x + 30, y + 25
        Tile L15_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L15_ORIGIN.setOrigin(true);
        L15_ORIGIN.setVisited(true);

        L15_TILES.add(L15_ORIGIN);

        tilemaps.add(15, L15_TILES);

    }
    public ArrayList<ArrayList<Tile>> getTilemaps() {
        return tilemaps;
    }

    public ArrayList<Tile> getStartMap() {
        return tilemaps.get(0);
    }

    public ArrayList<Tile> getIDLayout(int id) {return tilemaps.get(id); }

    public Point2D getMapOrigin(int id) {return tilemaps.get(id).get(0).getPosition();}
}
