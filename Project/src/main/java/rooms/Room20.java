package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room20 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile3Pos = tiles.get(3).getPosition();
        Point2D originPos = tiles.get(0).getPosition();

        tiles.set(0, new Tile(tile3Pos, TileType.ORIGIN));


        // inactive
        tiles.set(3, new Tile(originPos, TileType.VISITED));
        tiles.set(19, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // exits
        tiles.set(2, new Tile(new Point2D(tiles.get(2).getPosition().getX() - 30, tiles.get(2)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(14, new Tile(new Point2D(tiles.get(14).getPosition().getX() - 30, tiles.get(14)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(26, new Tile(new Point2D(tiles.get(26).getPosition().getX() - 30, tiles.get(26)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(23, new Tile(new Point2D(tiles.get(23).getPosition().getX() - 30, tiles.get(23)
                .getPosition().getY() - 20), TileType.EXIT));

        // gold
        tiles.set(17, new Tile(tiles.get(17).getPosition(), TileType.GOLD));
        tiles.set(10, new Tile(tiles.get(10).getPosition(), TileType.GOLD));

        // monster
        tiles.set(17, new Tile(tiles.get(9).getPosition(), TileType.MONSTER));
        tiles.set(10, new Tile(tiles.get(20).getPosition(), TileType.MONSTER));
        tiles.set(22, new Tile(tiles.get(20).getPosition(), TileType.MONSTER));

        // mystery
        tiles.set(8, new Tile(tiles.get(8).getPosition(), TileType.MYSTERY));
        tiles.set(13, new Tile(tiles.get(13).getPosition(), TileType.MYSTERY));


        return tiles;
    }
}
