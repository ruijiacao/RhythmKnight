package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room12 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile17Pos = tiles.get(17).getPosition();
        tiles.set(0, new Tile(tile17Pos, TileType.ORIGIN));

        // Pesky extra tile in layout
        tiles.add(new Tile( new Point2D(tiles.get(1).getPosition().getX() - 8 * 190, tiles.get(1).getPosition().getY()), TileType.VISITED));

        // removed tiles
        int[] unused = {7, 4, 2, 3, 6, 9, 10, 20, 24, 27, 21, 25};
        for (int i : unused) {
            tiles.set(i, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        }

        //combat tiles
        int[] combat = {5, 11, 18, 26};
        for (int i : combat) {
            tiles.set(i, new Tile(tiles.get(i).getPosition(), TileType.MONSTER));
        }

        //gold tiles
        int[] gold = {12, 19, 23};
        for (int i : gold) {
            tiles.set(i, new Tile(tiles.get(i).getPosition(), TileType.GOLD));
        }

        //mystery tiles
        int[] mystery = {8, 15, 22};
        // tile at index 0 handled already above
        for (int i : mystery) {
            tiles.set(i, new Tile(tiles.get(i).getPosition(), TileType.MYSTERY));
        }

        // exit tiles
        int[] locked = {13, 14};
        for (int i : locked) {
            tiles.set(i, new Tile(new Point2D(tiles.get(i).getPosition().getX() - 30, tiles.get(i)
                    .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        }
        int[] exits = {1, 28};
        for (int i : exits) {
            tiles.set(i, new Tile(new Point2D(tiles.get(i).getPosition().getX() - 30, tiles.get(i)
                    .getPosition().getY() - 20), TileType.EXIT));
        }

        return tiles;
    }
}
