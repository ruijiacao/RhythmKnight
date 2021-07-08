package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room6 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        tiles.set(4, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(7, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(21, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(24, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(27, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(14, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // exit tiles
        tiles.set(25, new Tile(new Point2D(tiles.get(25).getPosition().getX() - 30, tiles.get(25)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(23, new Tile(new Point2D(tiles.get(23).getPosition().getX() - 30, tiles.get(23)
                .getPosition().getY() - 20), TileType.EXIT));

        //Monster tiles
        tiles.set(20, new Tile(new Point2D(tiles.get(20).getPosition().getX() - 30, tiles.get(20)
                .getPosition().getY() - 20), TileType.MONSTER));

        return tiles;
    }
}
