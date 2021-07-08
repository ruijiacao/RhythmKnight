package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room13 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        //change the origin
        int swap = (25);

        Point2D swapPos = tiles.get(swap).getPosition();
        Point2D originPos = tiles.get(0).getPosition();

        tiles.set(0, new Tile(swapPos, TileType.ORIGIN));
        tiles.set(swap, new Tile(new Point2D(-1000,-1000), TileType.UNVISITED));

        // removed tiles
        tiles.set(1, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(2, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(3, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(5, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(6, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(7, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(9, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(11, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(17, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        //combat tiles
        tiles.set(8, new Tile(tiles.get(8).getPosition(), TileType.MONSTER));
        tiles.set(13, new Tile(tiles.get(13).getPosition(), TileType.MONSTER));
        tiles.set(14, new Tile(tiles.get(14).getPosition(), TileType.MONSTER));
        tiles.set(20, new Tile(tiles.get(20).getPosition(), TileType.MONSTER));


        //gold tiles
        tiles.set(15, new Tile(tiles.get(15).getPosition(), TileType.GOLD));
        tiles.set(21, new Tile(tiles.get(21).getPosition(), TileType.GOLD));

        //mystery tiles
        tiles.set(12, new Tile(tiles.get(12).getPosition(), TileType.MYSTERY));
        tiles.set(16, new Tile(tiles.get(16).getPosition(), TileType.MYSTERY));
        tiles.set(23, new Tile(tiles.get(23).getPosition(), TileType.MYSTERY));

        // exit tiles
        tiles.set(4, new Tile(new Point2D(tiles.get(4).getPosition().getX() - 30, tiles.get(4)
            .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(10, new Tile(new Point2D(tiles.get(10).getPosition().getX() - 30, tiles.get(10)
            .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(18, new Tile(new Point2D(tiles.get(18).getPosition().getX() - 30, tiles.get(18)
            .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(26, new Tile(new Point2D(tiles.get(26).getPosition().getX() - 30, tiles.get(26)
            .getPosition().getY() - 20), TileType.EXIT));


        return tiles;
    }
}
