package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room1 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tile = new TemplateRoom().buildTiles();

        // origin
        Point2D tile26Pos = tile.get(26).getPosition();
        Point2D originPos = tile.get(0).getPosition();

        tile.set(0, new Tile(tile26Pos, TileType.ORIGIN));

        // inactive
        tile.set(26, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tile.set(2, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tile.set(3, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tile.set(10, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tile.set(14, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tile.set(24, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tile.set(25, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tile.set(27, new Tile(new Point2D(-1000, 1000), TileType.VISITED));

        // monster
        tile.set(5, new Tile(tile.get(5).getPosition(), TileType.MONSTER));
        tile.set(11, new Tile(tile.get(11).getPosition(), TileType.MONSTER));
        tile.set(20, new Tile(tile.get(5).getPosition(), TileType.MONSTER));

        // mystery
        tile.set(4, new Tile(tile.get(4).getPosition(), TileType.MYSTERY));
        tile.set(12, new Tile(tile.get(12).getPosition(), TileType.MYSTERY));
        tile.set(16, new Tile(tile.get(16).getPosition(), TileType.MYSTERY));

        // gold
        tile.set(17, new Tile(tile.get(17).getPosition(), TileType.GOLD));
        tile.set(19, new Tile(tile.get(19).getPosition(), TileType.GOLD));

        // exits
        tile.set(1, new Tile(new Point2D(tile.get(1).getPosition().getX() - 30, tile.get(1)
                .getPosition().getY() - 20), TileType.EXIT));
        tile.set(6, new Tile(new Point2D(tile.get(6).getPosition().getX() - 30, tile.get(6)
                .getPosition().getY() - 20), TileType.EXIT));
        tile.set(7, new Tile(new Point2D(tile.get(7).getPosition().getX() - 30, tile.get(7)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        tile.set(21, new Tile(new Point2D(tile.get(21).getPosition().getX() - 30, tile.get(21)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));

        return tile;
    }
}
