package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class TemplateRoom implements IRoom {

    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Point2D> positions = new ArrayList<>();

    @Override
    public ArrayList<Tile> buildTiles() {
        // x + 30, y + 25
        // y + 220 for adjacent tiles south
        // y - 220 for adjacent tiles north
        // y - 110 and x + 190 for adjacent tiles northeast
        // y - 110 and x - 190 for adjacent tiles northwest
        // y + 110 and x + 190 for adjacent tiles southeast
        // y + 110 and x - 190 for adjacent tiles southwest

        int i = 0;
        Tile origin = new Tile(new Point2D(1535, 45), TileType.ORIGIN);
        tiles.add(origin);
        origin.setTileID(i);
        i++;

        Point2D currPos = new Point2D(1535, 45);
        positions.add(currPos);

        for (int column = 8; column >= 1; column--) {
            Point2D firstInRow = currPos;

            if (column % 2 == 0) {
                for (int row = 1; row <= 4; row++) {
                    if (!positions.contains(currPos)) {
                        Tile newTile = new Tile(currPos);
                        tiles.add(newTile);
                        positions.add(currPos);
                        newTile.setTileID(i);
                        i++;
                    }
                    currPos = new Point2D(currPos.getX(), currPos.getY() + 220);
                }
                currPos = new Point2D(firstInRow.getX() - 190, firstInRow.getY() + 110);
            } else {
                for (int row = 1; row <= 3; row++) {
                    if (!positions.contains(currPos)) {
                        Tile newTile = new Tile(currPos);
                        tiles.add(newTile);
                        positions.add(currPos);
                        newTile.setTileID(i);
                        i++;
                    }
                    currPos = new Point2D(currPos.getX(), currPos.getY() + 220);
                }
                currPos = new Point2D(firstInRow.getX() - 190, firstInRow.getY() - 110);
            }
        }

        return tiles;
    }

    static void setOrigin(int tilePos, TileType type, ArrayList<Tile> map) {
        Point2D swapTilePos = map.get(tilePos).getPosition();
        Point2D originPos = map.get(0).getPosition();
        map.set(0, new Tile(swapTilePos, TileType.ORIGIN));
        map.set(tilePos, new Tile(originPos, type));
        map.get(0).setTileID(0);
    }

    static void setOrigin(int tilePos, ArrayList<Tile> map) {
        Point2D swapTilePos = map.get(tilePos).getPosition();
        map.set(0, new Tile(swapTilePos, TileType.ORIGIN));
        map.set(tilePos, new Tile(new Point2D(-1000, -1000), TileType.INVISIBLE));
        map.get(0).setTileID(0);
    }

    static void setTileType(int[] cellsNum, TileType type, ArrayList<Tile> map) {
        for (int i : cellsNum) {
            map.set(i, new Tile((map.get(i).getPosition()), type));
            map.get(i).setTileID(i);
        }

    }

    static void removeUnused(int[] cellsNum, ArrayList<Tile> map) {
        for (int i : cellsNum) {
            map.set(i, new Tile(new Point2D(-1000, -1000), TileType.INVISIBLE));
        }
    }

}
