package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room10 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L10_TILES = new ArrayList<>();

        // x + 30, y + 25
        // y + 220 for adjacent tiles south
        // y - 220 for adjacent tiles north
        // x + 190 and y - 110 for adjacent tiles northeast
        // x - 190 and y - 110 for adjacent tiles northwest
        // x + 190 and y + 110 for adjacent tiles southeast
        // x - 190 and y + 110 for adjacent tiles southwest
        Tile L10_ORIGIN = new Tile(new Point2D(780, 415), TileType.ORIGIN);
        L10_ORIGIN.setOrigin(true);
        L10_ORIGIN.setVisited(true);
        

        Tile L10_NORM1 = new Tile(new Point2D(970, 85), TileType.UNVISITED);
        Tile L10_NORM2 = new Tile(new Point2D(590, 85), TileType.UNVISITED);

        // Mystery squares
        Tile L10_NORM3 = new Tile(new Point2D(1160, 195), TileType.UNVISITED);
        Tile L10_NORM4 = new Tile(new Point2D(1160, 635), TileType.UNVISITED);
        Tile L10_NORM5 = new Tile(new Point2D(590, 305), TileType.UNVISITED);
        Tile L10_NORM6 = new Tile(new Point2D(400, 415), TileType.UNVISITED);

        // Lock Squares
        Tile L10_NORM7 = new Tile(new Point2D(400, 635), TileType.UNVISITED);
        Tile L10_NORM8 = new Tile(new Point2D(210, 305), TileType.UNVISITED);
        

        // Monster squares
        Tile L10_ATK1 = new Tile(new Point2D(780, 195), TileType.UNVISITED);
        Tile L10_ATK2 = new Tile(new Point2D(970, 305), TileType.UNVISITED);
        Tile L10_ATK3 = new Tile(new Point2D(970, 525), TileType.UNVISITED);
        Tile L10_ATK4 = new Tile(new Point2D(780, 635), TileType.UNVISITED);
        Tile L10_ATK5 = new Tile(new Point2D(590, 525), TileType.UNVISITED);
        Tile L10_ATK6 = new Tile(new Point2D(590, 305), TileType.UNVISITED);
        Tile L10_ATK7 = new Tile(new Point2D(1160, 415), TileType.UNVISITED);
        Tile L10_ATK8 = new Tile(new Point2D(1350, 745), TileType.UNVISITED);

        // Gold squares
        Tile L10_GLD1 = new Tile(new Point2D(400, 415), TileType.UNVISITED);

        Tile L10_EXIT1 = new Tile(new Point2D(1320, 280), TileType.EXIT);
        L10_EXIT1.setExit(true);
        Tile L10_EXIT2 = new Tile(new Point2D(1510, 610), TileType.EXIT);
        L10_EXIT2.setExit(true);

        
        L10_TILES.add(L10_ORIGIN);
        
        L10_TILES.add(L10_NORM1);
        L10_TILES.add(L10_NORM2);
        L10_TILES.add(L10_NORM3);
        L10_TILES.add(L10_NORM4);
        L10_TILES.add(L10_NORM5);
        L10_TILES.add(L10_NORM6);
        L10_TILES.add(L10_NORM7);
        L10_TILES.add(L10_NORM8);

        L10_TILES.add(L10_ATK1);
        L10_TILES.add(L10_ATK2);
        L10_TILES.add(L10_ATK3);
        L10_TILES.add(L10_ATK4);
        L10_TILES.add(L10_ATK5);
        L10_TILES.add(L10_ATK6);
        L10_TILES.add(L10_ATK7);
        L10_TILES.add(L10_ATK8);


        L10_TILES.add(L10_GLD1);

        L10_TILES.add(L10_EXIT1);
        L10_TILES.add(L10_EXIT2);

        return L10_TILES;
    }
}
