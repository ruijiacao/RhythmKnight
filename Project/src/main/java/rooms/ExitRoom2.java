package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class ExitRoom2 implements IRoom {

    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        tiles.set(7, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(14, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(21, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(3, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(6, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(10, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(13, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(17, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(20, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(26, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(23, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(19, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(16, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        tiles.set(22, new Tile(new Point2D(tiles.get(22).getPosition().getX(), tiles.get(22)
                .getPosition().getY()), TileType.UNVISITED));
        tiles.set(18, new Tile(new Point2D(tiles.get(18).getPosition().getX(), tiles.get(18)
                .getPosition().getY()), TileType.UNVISITED));
        tiles.set(15, new Tile(new Point2D(tiles.get(15).getPosition().getX(), tiles.get(15)
                .getPosition().getY()), TileType.UNVISITED));
        tiles.set(12, new Tile(new Point2D(tiles.get(12).getPosition().getX(), tiles.get(12)
                .getPosition().getY()), TileType.UNVISITED));
        tiles.set(9, new Tile(new Point2D(tiles.get(9).getPosition().getX(), tiles.get(9)
                .getPosition().getY()), TileType.UNVISITED));
        tiles.set(5, new Tile(new Point2D(tiles.get(5).getPosition().getX(), tiles.get(5)
                .getPosition().getY()), TileType.UNVISITED));
        tiles.set(4, new Tile(new Point2D(tiles.get(4).getPosition().getX(), tiles.get(4)
                .getPosition().getY()), TileType.UNVISITED));
        tiles.set(8, new Tile(new Point2D(tiles.get(8).getPosition().getX(), tiles.get(8)
                .getPosition().getY()), TileType.UNVISITED));

        int swap = 25;

        Point2D swapPos = tiles.get(swap).getPosition();
        Point2D originPos = tiles.get(0).getPosition();

        tiles.set(0, new Tile(swapPos, TileType.ORIGIN));
        tiles.set(swap, new Tile(originPos, TileType.UNVISITED));

        // exit tiles
        tiles.set(11, new Tile(new Point2D(tiles.get(11).getPosition().getX() - 30, tiles.get(11)
                .getPosition().getY() - 20), TileType.EXIT));

        //Gold tiles
        tiles.set(25, new Tile(new Point2D(tiles.get(25).getPosition().getX(), tiles.get(25)
                .getPosition().getY()), TileType.GOLD));
        tiles.set(2, new Tile(new Point2D(tiles.get(2).getPosition().getX(), tiles.get(2)
                .getPosition().getY()), TileType.GOLD));
        tiles.set(1, new Tile(new Point2D(tiles.get(1).getPosition().getX(), tiles.get(1)
                .getPosition().getY()), TileType.GOLD));
        tiles.set(2, new Tile(new Point2D(tiles.get(2).getPosition().getX(), tiles.get(2)
                .getPosition().getY()), TileType.GOLD));

        return tiles;
    }
    
}
