package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room15 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        //change the origin
        int swap = (22);

        Point2D swapPos = tiles.get(swap).getPosition();
        Point2D originPos = tiles.get(0).getPosition();

        tiles.set(0, new Tile(swapPos, TileType.ORIGIN));
        tiles.set(swap, new Tile(new Point2D(-1000,-1000), TileType.UNVISITED));

        // removed tiles
        tiles.set(3, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(5, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(10, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(17, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(21, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(23, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        //combat tiles
        tiles.set(1, new Tile(tiles.get(1).getPosition(), TileType.MONSTER));
        tiles.set(6, new Tile(tiles.get(6).getPosition(), TileType.MONSTER));
        tiles.set(16, new Tile(tiles.get(16).getPosition(), TileType.MONSTER));


        //gold tiles
        tiles.set(8, new Tile(tiles.get(8).getPosition(), TileType.GOLD));

        //mystery tiles
        tiles.set(7, new Tile(tiles.get(7).getPosition(), TileType.MYSTERY));
        tiles.set(15, new Tile(tiles.get(15).getPosition(), TileType.MYSTERY));
        tiles.set(20, new Tile(tiles.get(20).getPosition(), TileType.MYSTERY));
        tiles.set(26, new Tile(tiles.get(26).getPosition(), TileType.MYSTERY));

        // exit tiles
        tiles.set(2, new Tile(new Point2D(tiles.get(2).getPosition().getX() - 30, tiles.get(2)
            .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(13, new Tile(new Point2D(tiles.get(13).getPosition().getX() - 30, tiles.get(13)
            .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(19, new Tile(new Point2D(tiles.get(19).getPosition().getX() - 30, tiles.get(19)
            .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(25, new Tile(new Point2D(tiles.get(25).getPosition().getX() - 30, tiles.get(25)
            .getPosition().getY() - 20), TileType.EXIT));

        return tiles;
    }
}
