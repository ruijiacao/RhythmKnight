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
        tiles.set(26, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // exit tiles
        tiles.set(4, new Tile(new Point2D(tiles.get(4).getPosition().getX() - 30, tiles.get(4)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(10, new Tile(new Point2D(tiles.get(10).getPosition().getX() - 30, tiles.get(10)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(12, new Tile(new Point2D(tiles.get(12).getPosition().getX() - 30, tiles.get(12)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(22, new Tile(new Point2D(tiles.get(22).getPosition().getX() - 30, tiles.get(22)
                .getPosition().getY() - 20), TileType.EXIT));

        return tiles;
    }
}
