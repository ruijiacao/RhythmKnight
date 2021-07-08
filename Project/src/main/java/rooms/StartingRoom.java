package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class StartingRoom implements IRoom {
    ArrayList<Tile> ST_TILES = new ArrayList<>();

    @Override
    public ArrayList<Tile> buildTiles() {
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

        return ST_TILES;
    }
}
