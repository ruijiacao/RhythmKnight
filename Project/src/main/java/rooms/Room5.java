package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room5 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L5_TILES = new TemplateRoom().buildTiles();

        // origin swap
        Point2D originPos = L5_TILES.get(0).getPosition();
        Point2D tile4Pos = L5_TILES.get(4).getPosition();

        L5_TILES.set(0, new Tile(tile4Pos, TileType.ORIGIN));

        // inactive
        L5_TILES.set(4, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(2, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(5, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(7, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(9, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(11, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(17, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L5_TILES.set(26, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // monster
        L5_TILES.set(21, new Tile(L5_TILES.get(21).getPosition(), TileType.MONSTER));
        L5_TILES.set(23, new Tile(L5_TILES.get(23).getPosition(), TileType.MONSTER));
        L5_TILES.set(19, new Tile(L5_TILES.get(19).getPosition(), TileType.MONSTER));

        // gold
        L5_TILES.set(1, new Tile(L5_TILES.get(1).getPosition(), TileType.GOLD));
        L5_TILES.set(6, new Tile(L5_TILES.get(6).getPosition(), TileType.GOLD));

        // mystery
        L5_TILES.set(15, new Tile(L5_TILES.get(15).getPosition(), TileType.MYSTERY));
        L5_TILES.set(16, new Tile(L5_TILES.get(16).getPosition(), TileType.MYSTERY));
        L5_TILES.set(20, new Tile(L5_TILES.get(20).getPosition(), TileType.MYSTERY));
        L5_TILES.set(22, new Tile(L5_TILES.get(22).getPosition(), TileType.MYSTERY));

        // exits
        L5_TILES.set(3, new Tile(new Point2D(L5_TILES.get(3).getPosition().getX() - 30, L5_TILES.get(3)
                .getPosition().getY() - 20), TileType.EXIT));
        L5_TILES.set(14, new Tile(new Point2D(L5_TILES.get(14).getPosition().getX() - 30, L5_TILES.get(14)
                .getPosition().getY() - 20), TileType.EXIT));
        L5_TILES.set(25, new Tile(new Point2D(L5_TILES.get(25).getPosition().getX() - 30, L5_TILES.get(25)
                .getPosition().getY() - 20), TileType.EXIT));
        L5_TILES.set(27, new Tile(new Point2D(L5_TILES.get(27).getPosition().getX() - 30, L5_TILES.get(27)
                .getPosition().getY() - 20), TileType.EXIT));

        return L5_TILES;
    }
}
