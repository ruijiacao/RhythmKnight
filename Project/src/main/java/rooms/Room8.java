package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room8 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L8_TILES = new ArrayList<>();

        // x + 30, y + 25
        // y + 220 for adjacent tiles south
        // y - 220 for adjacent tiles north
        // x + 190 and y - 110 for adjacent tiles northeast
        // x - 190 and y - 110 for adjacent tiles northwest
        // x + 190 and y + 110 for adjacent tiles southeast
        // x - 190 and y + 110 for adjacent tiles southwest
        Tile L8_ORIGIN = new Tile(new Point2D(350, 535), TileType.ORIGIN);
        L8_ORIGIN.setOrigin(true);
        L8_ORIGIN.setVisited(true);

        // Normal Squares
        Tile L8_NORM1 = new Tile(new Point2D(540, 425), TileType.UNVISITED);
        Tile L8_NORM2 = new Tile(new Point2D(730, 535), TileType.UNVISITED);
        Tile L8_NORM3 = new Tile(new Point2D(730, 315), TileType.UNVISITED);
        Tile L8_NORM4 = new Tile(new Point2D(920, 205), TileType.UNVISITED);

        // Mystery squares
        Tile L8_NORM5 = new Tile(new Point2D(350, 315), TileType.UNVISITED);
        Tile L8_NORM6 = new Tile(new Point2D(730, 95), TileType.UNVISITED);
        Tile L8_NORM7 = new Tile(new Point2D(1110, 315), TileType.UNVISITED);

        // Lock Squares
        Tile L8_NORM8 = new Tile(new Point2D(540, 205), TileType.UNVISITED);
        Tile L8_NORM9 = new Tile(new Point2D(540, 645), TileType.UNVISITED);
        
        // Monster Squares
        Tile L8_ATK1 = new Tile(new Point2D(920, 425), TileType.UNVISITED);
        Tile L8_ATK2 = new Tile(new Point2D(1300, 425), TileType.UNVISITED);
        Tile L8_ATK3 = new Tile(new Point2D(1300, 645), TileType.UNVISITED);

        // Gold Squares
        Tile L8_GLD1 = new Tile(new Point2D(160, 425), TileType.UNVISITED);
        Tile L8_GLD2 = new Tile(new Point2D(1110, 535), TileType.UNVISITED);

        Tile L8_EXIT1 = new Tile(new Point2D(1080, 730), TileType.EXIT);
        L8_EXIT1.setExit(true);
        Tile L8_EXIT2 = new Tile(new Point2D(1460, 290), TileType.EXIT);
        L8_EXIT2.setExit(true);

        L8_TILES.add(L8_ORIGIN);

        L8_TILES.add(L8_NORM1);
        L8_TILES.add(L8_NORM2);
        L8_TILES.add(L8_NORM3);
        L8_TILES.add(L8_NORM4);
        L8_TILES.add(L8_NORM5);
        L8_TILES.add(L8_NORM6);
        L8_TILES.add(L8_NORM7);
        L8_TILES.add(L8_NORM8);
        L8_TILES.add(L8_NORM9);

        L8_TILES.add(L8_ATK1);
        L8_TILES.add(L8_ATK2);
        L8_TILES.add(L8_ATK3);

        L8_TILES.add(L8_GLD1);
        L8_TILES.add(L8_GLD2);

        L8_TILES.add(L8_EXIT1);
        L8_TILES.add(L8_EXIT2);

        return L8_TILES;
    }
}
