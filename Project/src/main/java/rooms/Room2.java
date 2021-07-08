package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;
import java.util.ArrayList;

public class Room2 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // removed tiles
        tiles.set(7, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(14, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(21, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(25, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // exit tiles
        tiles.set(4, new Tile(new Point2D(tiles.get(4).getPosition().getX() - 30, tiles.get(4)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(10, new Tile(new Point2D(tiles.get(10).getPosition().getX() - 30, tiles.get(10)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(12, new Tile(new Point2D(tiles.get(12).getPosition().getX() - 30, tiles.get(12)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        tiles.set(22, new Tile(new Point2D(tiles.get(22).getPosition().getX() - 30, tiles.get(22)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));

        // monster tiles
        tiles.set(17, new Tile(tiles.get(17).getPosition(), TileType.MONSTER));
        tiles.set(19, new Tile(tiles.get(19).getPosition(), TileType.MONSTER));
        tiles.set(23, new Tile(tiles.get(23).getPosition(), TileType.MONSTER));

        // mystery tiles
        tiles.set(5, new Tile(tiles.get(5).getPosition(), TileType.MYSTERY));
        tiles.set(11, new Tile(tiles.get(11).getPosition(), TileType.MYSTERY));
        tiles.set(18, new Tile(tiles.get(18).getPosition(), TileType.MYSTERY));

        // gold tiles
        tiles.set(3, new Tile(tiles.get(3).getPosition(), TileType.GOLD));
        tiles.set(16, new Tile(tiles.get(16).getPosition(), TileType.GOLD));
        tiles.set(26, new Tile(tiles.get(26).getPosition(), TileType.GOLD));

        return tiles;
    }
}
