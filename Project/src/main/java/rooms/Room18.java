package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room18 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile26Pos = tiles.get(26).getPosition();
        Point2D originPos = tiles.get(0).getPosition();

        tiles.set(0, new Tile(tile26Pos, TileType.ORIGIN));


        // inactive
        tiles.set(26, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(25, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(3, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(10, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(21, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // exits
        tiles.set(1, new Tile(new Point2D(tiles.get(1).getPosition().getX() - 30, tiles.get(1)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(2, new Tile(new Point2D(tiles.get(2).getPosition().getX() - 30, tiles.get(2)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(7, new Tile(new Point2D(tiles.get(7).getPosition().getX() - 30, tiles.get(7)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(15, new Tile(new Point2D(tiles.get(15).getPosition().getX() - 30, tiles.get(15)
                .getPosition().getY() - 20), TileType.EXIT));

        // gold
        tiles.set(8, new Tile(tiles.get(8).getPosition(), TileType.GOLD));
        tiles.set(16, new Tile(tiles.get(16).getPosition(), TileType.GOLD));

        // monster
        tiles.set(5, new Tile(tiles.get(5).getPosition(), TileType.MONSTER));
        tiles.set(18, new Tile(tiles.get(18).getPosition(), TileType.MONSTER));
        tiles.set(19, new Tile(tiles.get(19).getPosition(), TileType.MONSTER));
        tiles.set(20, new Tile(tiles.get(20).getPosition(), TileType.MONSTER));

        // mystery
        tiles.set(12, new Tile(tiles.get(12).getPosition(), TileType.MYSTERY));
        tiles.set(17, new Tile(tiles.get(17).getPosition(), TileType.MYSTERY));

        return tiles;
    }
}
