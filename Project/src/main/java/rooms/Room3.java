package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room3 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L3_TILES = new TemplateRoom().buildTiles();

        // origin
        Point2D tile26Pos = L3_TILES.get(26).getPosition();
        Point2D originPos = L3_TILES.get(0).getPosition();

        L3_TILES.set(0, new Tile(tile26Pos, TileType.ORIGIN));

        // exit tiles
        L3_TILES.set(26, new Tile(new Point2D(originPos.getX() - 30, originPos.getY() - 20), TileType.LOCKED_EXIT));
        L3_TILES.set(7, new Tile(new Point2D(L3_TILES.get(7).getPosition().getX() - 30, L3_TILES.get(7)
                .getPosition().getY() - 20), TileType.EXIT));
        L3_TILES.set(13, new Tile(new Point2D(L3_TILES.get(13).getPosition().getX() - 30, L3_TILES.get(13)
                .getPosition().getY() - 20), TileType.EXIT));
        L3_TILES.set(27, new Tile(new Point2D(L3_TILES.get(27).getPosition().getX() - 30, L3_TILES.get(27)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));

        // inactive
        L3_TILES.set(4, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L3_TILES.set(14, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L3_TILES.set(17, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L3_TILES.set(21, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        L3_TILES.set(25, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // monster tiles
        L3_TILES.set(1, new Tile(L3_TILES.get(1).getPosition(), TileType.MONSTER));
        L3_TILES.set(8, new Tile(L3_TILES.get(8).getPosition(), TileType.MONSTER));
        L3_TILES.set(10, new Tile(L3_TILES.get(10).getPosition(), TileType.MONSTER));
        L3_TILES.set(15, new Tile(L3_TILES.get(15).getPosition(), TileType.MONSTER));

        // gold tiles
        L3_TILES.set(2, new Tile(L3_TILES.get(2).getPosition(), TileType.GOLD));
        L3_TILES.set(16, new Tile(L3_TILES.get(16).getPosition(), TileType.GOLD));

        // mystery tiles
        L3_TILES.set(3, new Tile(L3_TILES.get(1).getPosition(), TileType.MYSTERY));
        L3_TILES.set(12, new Tile(L3_TILES.get(12).getPosition(), TileType.MYSTERY));
        L3_TILES.set(18, new Tile(L3_TILES.get(18).getPosition(), TileType.MYSTERY));

        return L3_TILES;
    }
}
