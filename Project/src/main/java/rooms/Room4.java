package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room4 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> L4_TILES = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile3Pos = L4_TILES.get(3).getPosition();
        Point2D originPos = L4_TILES.get(0).getPosition();

        L4_TILES.set(0, new Tile(tile3Pos, TileType.ORIGIN));

        // inactive
        L4_TILES.set(3, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(5, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(8, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(10, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(13, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(17, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(22, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(24, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        L4_TILES.set(27, new Tile(new Point2D(-1000, 1000), TileType.VISITED));

        // monster
        L4_TILES.set(1, new Tile(L4_TILES.get(1).getPosition(), TileType.MONSTER));
        L4_TILES.set(18, new Tile(L4_TILES.get(18).getPosition(), TileType.MONSTER));
        L4_TILES.set(27, new Tile(L4_TILES.get(27).getPosition(), TileType.MONSTER));

        // gold
        L4_TILES.set(7, new Tile(L4_TILES.get(7).getPosition(), TileType.GOLD));
        L4_TILES.set(19, new Tile(L4_TILES.get(19).getPosition(), TileType.GOLD));

        // mystery
        L4_TILES.set(2, new Tile(L4_TILES.get(2).getPosition(), TileType.MYSTERY));
        L4_TILES.set(15, new Tile(L4_TILES.get(15).getPosition(), TileType.MYSTERY));
        L4_TILES.set(16, new Tile(L4_TILES.get(16).getPosition(), TileType.MYSTERY));

        // exits
        L4_TILES.set(4, new Tile(new Point2D(L4_TILES.get(4).getPosition().getX() - 30, L4_TILES.get(4)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        L4_TILES.set(14, new Tile(new Point2D(L4_TILES.get(14).getPosition().getX() - 30, L4_TILES.get(14)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        L4_TILES.set(20, new Tile(new Point2D(L4_TILES.get(20).getPosition().getX() - 30, L4_TILES.get(20)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        L4_TILES.set(26, new Tile(new Point2D(L4_TILES.get(26).getPosition().getX() - 30, L4_TILES.get(26)
                .getPosition().getY() - 20), TileType.EXIT));

        return L4_TILES;
    }
}
