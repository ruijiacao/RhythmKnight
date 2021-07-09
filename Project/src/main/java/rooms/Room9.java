package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room9 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L9_TILES = new ArrayList<>();

        // x + 30, y + 25
        // y + 220 for adjacent tiles south
        // y - 220 for adjacent tiles north
        // x + 190 and y - 110 for adjacent tiles northeast
        // x - 190 and y - 110 for adjacent tiles northwest
        // x + 190 and y + 110 for adjacent tiles southeast
        // x - 190 and y + 110 for adjacent tiles southwest
        Tile L9_ORIGIN = new Tile(new Point2D(810, 325), TileType.ORIGIN);
        L9_ORIGIN.setOrigin(true);
        L9_ORIGIN.setVisited(true);

        Tile L9_NORM1 = new Tile(new Point2D(355, 508), TileType.UNVISITED);
        Tile L9_NORM2 = new Tile(new Point2D(1115, 288), TileType.UNVISITED);
        Tile L9_NORM3 = new Tile(new Point2D(733, 315), TileType.UNVISITED);

        // Mystery squares
        Tile L9_NORM4 = new Tile(new Point2D(545, 398), TileType.UNVISITED);
        Tile L9_NORM5 = new Tile(new Point2D(735, 728), TileType.UNVISITED);
        Tile L9_NORM6 = new Tile(new Point2D(925, 398), TileType.UNVISITED);

        // Lock Squares
        Tile L9_NORM7 = new Tile(new Point2D(355, 288), TileType.UNVISITED);
        Tile L9_NORM8 = new Tile(new Point2D(355, 728), TileType.UNVISITED);
        

        // Monster squares
        Tile L9_ATK1 = new Tile(new Point2D(165, 398), TileType.UNVISITED);
        Tile L9_ATK2 = new Tile(new Point2D(735, 288), TileType.UNVISITED);
        Tile L9_ATK3 = new Tile(new Point2D(1495, 288), TileType.UNVISITED);
        Tile L9_ATK4 = new Tile(new Point2D(1495, 508), TileType.UNVISITED);

        // Gold squares
        Tile L9_GLD1 = new Tile(new Point2D(735, 508), TileType.UNVISITED);
        Tile L9_GLD2 = new Tile(new Point2D(1305, 398), TileType.UNVISITED);

        Tile L9_EXIT1 = new Tile(new Point2D(1465, 703), TileType.EXIT);
        L9_EXIT1.setExit(true);
        Tile L9_EXIT2 = new Tile(new Point2D(1465, 43), TileType.EXIT);
        L9_EXIT2.setExit(true);

        L9_TILES.add(L9_ORIGIN);

        L9_TILES.add(L9_NORM1);
        L9_TILES.add(L9_NORM2);
        L9_TILES.add(L9_NORM3);
        L9_TILES.add(L9_NORM4);
        L9_TILES.add(L9_NORM5);
        L9_TILES.add(L9_NORM6);
        L9_TILES.add(L9_NORM7);
        L9_TILES.add(L9_NORM8);

        L9_TILES.add(L9_ATK1);
        L9_TILES.add(L9_ATK2);
        L9_TILES.add(L9_ATK3);
        L9_TILES.add(L9_ATK4);


        L9_TILES.add(L9_GLD1);
        L9_TILES.add(L9_GLD2);

        L9_TILES.add(L9_EXIT1);
        L9_TILES.add(L9_EXIT2);

        return L9_TILES;
    }
}
