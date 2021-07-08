package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class TemplateRoom implements IRoom {

    ArrayList<Tile> tiles = new ArrayList<>();
    ArrayList<Point2D> positions = new ArrayList<>();

    @Override
    public ArrayList<Tile> buildTiles() {
        // x + 30, y + 25
        // y + 220 for adjacent tiles south
        // y - 220 for adjacent tiles north
        // y - 110 and x + 190 for adjacent tiles northeast
        // y - 110 and x - 190 for adjacent tiles northwest
        // y + 110 and x + 190 for adjacent tiles southeast
        // y + 110 and x - 190 for adjacent tiles southwest

        Tile origin = new Tile(new Point2D(1535, 45), TileType.ORIGIN);
        origin.setOrigin(true);
        origin.setVisited(true);
        tiles.add(origin);

        Point2D currPos = new Point2D(1535, 45);
        positions.add(currPos);

        for (int column = 8; column >= 1; column--) {
            Point2D firstInRow = currPos;

            if (column % 2 == 0) {
                for (int row = 1; row <= 4; row++) {
                    if (!positions.contains(currPos)) {
                        Tile newTile = new Tile(currPos, TileType.UNVISITED);
                        tiles.add(newTile);
                        positions.add(currPos);
                    }
                    currPos = new Point2D(currPos.getX(), currPos.getY() + 220);
                }
                currPos = new Point2D(firstInRow.getX() - 190, firstInRow.getY() + 110);
            } else {
                for (int row = 1; row <= 3; row++) {
                    if (!positions.contains(currPos)) {
                        Tile newTile = new Tile(currPos, TileType.UNVISITED);
                        tiles.add(newTile);
                        positions.add(currPos);
                    }
                    currPos = new Point2D(currPos.getX(), currPos.getY() + 220);
                }
                currPos = new Point2D(firstInRow.getX() - 190, firstInRow.getY() - 110);
            }
        }

        return tiles;
    }
}
