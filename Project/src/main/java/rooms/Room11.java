package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room11 implements IRoom {
    @Override
    public ArrayList<Tile> buildTiles() {
        ArrayList<Tile> tiles = new TemplateRoom().buildTiles();

        // origin swap
        Point2D tile1Pos = tiles.get(1).getPosition();
        Point2D originPos = tiles.get(0).getPosition();
        tiles.set(0, new Tile(tile1Pos, TileType.ORIGIN));
        tiles.set(1, new Tile(originPos, TileType.MYSTERY));

        // removed tiles
        int[] unused = {7, 14, 18, 21, 26, 23, 17, 9, 10, 6, 3};
        for (int i : unused) {
            tiles.set(i, new Tile(new Point2D(-1000, -1000), TileType.VISITED));
        }

        //combat tiles
        int[] combat = {22, 24};
        for (int i : combat) {
            tiles.set(i, new Tile(tiles.get(i).getPosition(), TileType.MONSTER));
        }

        //gold tiles
        int[] gold = {13, 2};
        for (int i : gold) {
            tiles.set(i, new Tile(tiles.get(i).getPosition(), TileType.GOLD));
        }

        //mystery tiles
        int[] mystery = {11, 19};
        // tile at index 0 handled already above
        for (int i : mystery) {
            tiles.set(i, new Tile(tiles.get(i).getPosition(), TileType.MYSTERY));
        }

        // exit tiles
        int[] locked = {5, 15};
        for (int i : locked) {
            tiles.set(i, new Tile(new Point2D(tiles.get(i).getPosition().getX() - 30, tiles.get(i)
                    .getPosition().getY() - 20), TileType.LOCKED_EXIT));
        }
        int[] exits = {25, 27};
        for (int i : exits) {
            tiles.set(i, new Tile(new Point2D(tiles.get(i).getPosition().getX() - 30, tiles.get(i)
                    .getPosition().getY() - 20), TileType.EXIT));
        }

        return tiles;
    }
}
