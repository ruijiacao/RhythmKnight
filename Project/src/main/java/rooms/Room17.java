package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room17 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile23Pos = tiles.get(23).getPosition();
        Point2D originPos = tiles.get(0).getPosition();
        tiles.set(0, new Tile(tile23Pos, TileType.ORIGIN));

        // inactive
        tiles.set(3, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(10, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(17, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // exits
        tiles.set(23, new Tile(originPos, TileType.EXIT));
        tiles.set(7, new Tile(new Point2D(tiles.get(7).getPosition().getX() - 30, tiles.get(7)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(14, new Tile(new Point2D(tiles.get(14).getPosition().getX() - 30, tiles.get(14)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(21, new Tile(new Point2D(tiles.get(21).getPosition().getX() - 30, tiles.get(21)
                .getPosition().getY() - 20), TileType.EXIT));

        // gold
        tiles.set(12, new Tile(tiles.get(12).getPosition(), TileType.GOLD));
        tiles.set(19, new Tile(tiles.get(19).getPosition(), TileType.GOLD));
        tiles.set(26, new Tile(tiles.get(26).getPosition(), TileType.GOLD));

        // monster
        tiles.set(5, new Tile(tiles.get(5).getPosition(), TileType.MONSTER));
        tiles.set(11, new Tile(tiles.get(11).getPosition(), TileType.MONSTER));
        tiles.set(16, new Tile(tiles.get(16).getPosition(), TileType.MONSTER));
        tiles.set(18, new Tile(tiles.get(18).getPosition(), TileType.MONSTER));

        // mystery
        tiles.set(4, new Tile(tiles.get(4).getPosition(), TileType.MYSTERY));
        tiles.set(25, new Tile(tiles.get(25).getPosition(), TileType.MYSTERY));


        return tiles;
    }
}
