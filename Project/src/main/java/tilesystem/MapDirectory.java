package tilesystem;

import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;
import rhythm.Conductor;

import java.util.ArrayList;

public class MapDirectory {
    private ArrayList<ArrayList<Tile>> tilemaps;

    public MapDirectory() {
        tilemaps = new ArrayList<>(16);

        // tilemap for start room
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
        Tile ST_EXIT2 = new Tile(new Point2D(210, 200), TileType.EXIT);
        Tile ST_EXIT3 = new Tile(new Point2D(600, 630), TileType.EXIT);
        Tile ST_EXIT4 = new Tile(new Point2D(1340, 630), TileType.EXIT);

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
    public ArrayList<ArrayList<Tile>> getTilemaps() {
        return tilemaps;
    }

    public ArrayList<Tile> getStartMap() {
        return tilemaps.get(0);
    }

    public void displayStartingLayout() {
        Entity layout = new EntityBuilder()
                .view("layouts/start-room.png")
                .buildAndAttach();
    }

    public void displayLayout(int id) {
        Entity layout = new EntityBuilder()
                .view("layouts/layout" + id + ".png")
                .buildAndAttach();
    }
}
