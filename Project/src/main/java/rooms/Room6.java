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
        tiles.set(26, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(22, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        tiles.set(25, new Tile(new Point2D(-1000, -1000), TileType.VISITED));

        // exit tiles
        tiles.set(18, new Tile(new Point2D(tiles.get(18).getPosition().getX() - 30, tiles.get(18)
                .getPosition().getY() - 20), TileType.EXIT));
        tiles.set(23, new Tile(new Point2D(tiles.get(23).getPosition().getX() - 30, tiles.get(23)
                .getPosition().getY() - 20), TileType.EXIT));

        //Monster tiles
        tiles.set(20, new Tile(new Point2D(tiles.get(20).getPosition().getX() , tiles.get(20)
                .getPosition().getY()), TileType.MONSTER));
        tiles.set(15, new Tile(new Point2D(tiles.get(15).getPosition().getX() , tiles.get(15)
                .getPosition().getY()), TileType.MONSTER));

        //Mystery tiles
        tiles.set(17, new Tile(new Point2D(tiles.get(17).getPosition().getX() , tiles.get(17)
                .getPosition().getY() ), TileType.MYSTERY));
        tiles.set(11, new Tile(new Point2D(tiles.get(11).getPosition().getX() , tiles.get(11)
                .getPosition().getY() ), TileType.MYSTERY));

        //Gold tiles
        tiles.set(5, new Tile(new Point2D(tiles.get(5).getPosition().getX() , tiles.get(5)
                .getPosition().getY() ), TileType.GOLD));
        tiles.set(13, new Tile(new Point2D(tiles.get(13).getPosition().getX() , tiles.get(13)
                .getPosition().getY() ), TileType.GOLD));

        // Locked_Exit
        tiles.set(16, new Tile(new Point2D(tiles.get(16).getPosition().getX() - 30, tiles.get(16)
                .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        tiles.set(10, new Tile(new Point2D(tiles.get(10).getPosition().getX() -30, tiles.get(10)
                .getPosition().getY() -20), TileType.LOCKED_EXIT));

        return tiles;
    }
}
