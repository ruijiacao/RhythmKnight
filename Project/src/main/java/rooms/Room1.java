package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room1 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L1_TILES = new TemplateRoom().buildTiles();

        // origin
        Point2D tile26Pos = L1_TILES.get(26).getPosition();
        Point2D originPos = L1_TILES.get(0).getPosition();

        L1_TILES.set(0, new Tile(tile26Pos, TileType.ORIGIN));

        // inactive
        L1_TILES.set(26, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L1_TILES.set(2, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L1_TILES.set(3, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L1_TILES.set(10, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L1_TILES.set(14, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L1_TILES.set(24, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L1_TILES.set(25, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L1_TILES.set(27, new Tile(new Point2D(-1000, 1000), TileType.VISITED));

        // monster
        L1_TILES.set(5, new Tile(L1_TILES.get(5).getPosition(), TileType.MONSTER));
        L1_TILES.set(11, new Tile(L1_TILES.get(11).getPosition(), TileType.MONSTER));
        L1_TILES.set(20, new Tile(L1_TILES.get(5).getPosition(), TileType.MONSTER));

        // mystery
        L1_TILES.set(4, new Tile(L1_TILES.get(4).getPosition(), TileType.MYSTERY));
        L1_TILES.set(12, new Tile(L1_TILES.get(12).getPosition(), TileType.MYSTERY));
        L1_TILES.set(16, new Tile(L1_TILES.get(16).getPosition(), TileType.MYSTERY));

        // gold
        L1_TILES.set(17, new Tile(L1_TILES.get(17).getPosition(), TileType.GOLD));
        L1_TILES.set(19, new Tile(L1_TILES.get(19).getPosition(), TileType.GOLD));

        // exits
        L1_TILES.set(1, new Tile(new Point2D(L1_TILES.get(1).getPosition().getX() - 30, L1_TILES.get(1)
                .getPosition().getY() - 20), TileType.EXIT));
        L1_TILES.set(6, new Tile(new Point2D(L1_TILES.get(6).getPosition().getX() - 30, L1_TILES.get(6)
                .getPosition().getY() - 20), TileType.EXIT));
        L1_TILES.set(7, new Tile(new Point2D(L1_TILES.get(7).getPosition().getX() - 30, L1_TILES.get(7)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        L1_TILES.set(21, new Tile(new Point2D(L1_TILES.get(21).getPosition().getX() - 30, L1_TILES.get(21)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));

        return L1_TILES;
    }
}
