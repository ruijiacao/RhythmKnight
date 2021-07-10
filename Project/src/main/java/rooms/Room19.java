package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room19 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile25Pos = tiles.get(25).getPosition();
        Point2D originPos = tiles.get(0).getPosition();

        tiles.set(0, new Tile(tile25Pos, TileType.ORIGIN));


        // inactive
        tiles.set(3, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(4, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(6, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(7, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(8, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(10, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(11, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(13, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(14, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(18, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(19, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(21, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(22, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, 1000), TileType.VISITED));

        // exits
        tiles.set(25, new Tile(originPos, TileType.EXIT));
        tiles.set(2, new Tile(new Point2D(tiles.get(2).getPosition().getX() - 30, tiles.get(2)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(17, new Tile(new Point2D(tiles.get(17).getPosition().getX() - 30, tiles.get(17)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(8, new Tile(new Point2D(tiles.get(8).getPosition().getX() - 30, tiles.get(8)
                .getPosition().getY() - 20), TileType.EXIT));

        // gold
        tiles.set(15, new Tile(tiles.get(15).getPosition(), TileType.GOLD));
        tiles.set(26, new Tile(tiles.get(26).getPosition(), TileType.GOLD));

        // monster
        tiles.set(1, new Tile(tiles.get(1).getPosition(), TileType.MONSTER));
        tiles.set(5, new Tile(tiles.get(5).getPosition(), TileType.MONSTER));
        tiles.set(23, new Tile(tiles.get(23).getPosition(), TileType.MONSTER));

        // mystery
        tiles.set(9, new Tile(tiles.get(9).getPosition(), TileType.MYSTERY));
        tiles.set(24, new Tile(tiles.get(24).getPosition(), TileType.MYSTERY));

        return tiles;
    }
}
