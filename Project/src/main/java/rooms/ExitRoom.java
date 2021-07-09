package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class ExitRoom implements IRoom{
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();
        removeTiles(tiles);
        goldTiles(tiles);

        int swap = (27);

        Point2D swapPos = tiles.get(swap).getPosition();

        tiles.set(0, new Tile(swapPos, TileType.ORIGIN));
        tiles.set(swap, new Tile(new Point2D(1505, 25), TileType.EXIT));
        return tiles;
    }

    private void goldTiles(ArrayList<Tile> tiles) {
        tiles.set(5, new Tile(tiles.get(5).getPosition(), TileType.GOLD));
        tiles.set(15, new Tile(tiles.get(15).getPosition(), TileType.GOLD));
        tiles.set(23, new Tile(tiles.get(23).getPosition(), TileType.GOLD));
    }

    private void removeTiles(ArrayList<Tile> tiles) {
        tiles.set(3, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(4, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(7, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(8, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(10, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(11, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(13, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(14, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(16, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(17, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(18, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(20, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(21, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(22, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(25, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(26, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
    }
}
