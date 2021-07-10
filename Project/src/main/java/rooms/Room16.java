package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room16 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile16Pos = tiles.get(16).getPosition();
        Point2D originPos = tiles.get(0).getPosition();

        tiles.set(0, new Tile(tile16Pos, TileType.ORIGIN));


        // inactive
        tiles.set(16, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(1, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(3, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(4, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(13, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(14, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, 1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, 1000), TileType.VISITED));

        // exits
        tiles.set(2, new Tile(new Point2D(tiles.get(2).getPosition().getX() - 30, tiles.get(2)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(6, new Tile(new Point2D(tiles.get(6).getPosition().getX() - 30, tiles.get(6)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(26, new Tile(new Point2D(tiles.get(26).getPosition().getX() - 30, tiles.get(26)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(27, new Tile(new Point2D(tiles.get(27).getPosition().getX() - 30, tiles.get(27)
                .getPosition().getY() - 20), TileType.EXIT));

        // gold
        tiles.set(7, new Tile(tiles.get(7).getPosition(), TileType.GOLD));
        tiles.set(9, new Tile(tiles.get(7).getPosition(), TileType.GOLD));

        // monster
        tiles.set(21, new Tile(tiles.get(21).getPosition(), TileType.MONSTER));
        tiles.set(23, new Tile(tiles.get(23).getPosition(), TileType.MONSTER));

        // mystery
        tiles.set(5, new Tile(tiles.get(5).getPosition(), TileType.MYSTERY));
        tiles.set(11, new Tile(tiles.get(11).getPosition(), TileType.MYSTERY));
        tiles.set(22, new Tile(tiles.get(11).getPosition(), TileType.MYSTERY));
        tiles.set(20, new Tile(tiles.get(11).getPosition(), TileType.MYSTERY));

        return tiles;
    }
}
