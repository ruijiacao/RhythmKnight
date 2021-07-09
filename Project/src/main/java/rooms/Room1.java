package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room1 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> TILES = new TemplateRoom().buildTiles();

        // origin
        Point2D tile26Pos = TILES.get(26).getPosition();
        Point2D originPos = TILES.get(0).getPosition();

        TILES.set(0, new Tile(tile26Pos, TileType.ORIGIN));

        // inactive
        TILES.set(26, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        TILES.set(2, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        TILES.set(3, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        TILES.set(10, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        TILES.set(14, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        TILES.set(24, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        TILES.set(25, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        TILES.set(27, new Tile(new Point2D(-1000, 1000), TileType.VISITED));

        // monster
        TILES.set(5, new Tile(TILES.get(5).getPosition(), TileType.MONSTER));
        TILES.set(11, new Tile(TILES.get(11).getPosition(), TileType.MONSTER));
        TILES.set(20, new Tile(TILES.get(5).getPosition(), TileType.MONSTER));

        // mystery
        TILES.set(4, new Tile(TILES.get(4).getPosition(), TileType.MYSTERY));
        TILES.set(12, new Tile(TILES.get(12).getPosition(), TileType.MYSTERY));
        TILES.set(16, new Tile(TILES.get(16).getPosition(), TileType.MYSTERY));

        // gold
        TILES.set(17, new Tile(TILES.get(17).getPosition(), TileType.GOLD));
        TILES.set(19, new Tile(TILES.get(19).getPosition(), TileType.GOLD));

        // exits
        TILES.set(1, new Tile(new Point2D(TILES.get(1).getPosition().getX() - 30, TILES.get(1)
                .getPosition().getY() - 20), TileType.EXIT));
        TILES.set(6, new Tile(new Point2D(TILES.get(6).getPosition().getX() - 30, TILES.get(6)
                .getPosition().getY() - 20), TileType.EXIT));
        TILES.set(7, new Tile(new Point2D(TILES.get(7).getPosition().getX() - 30, TILES.get(7)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        TILES.set(21, new Tile(new Point2D(TILES.get(21).getPosition().getX() - 30, TILES.get(21)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));

        return TILES;
    }
}
