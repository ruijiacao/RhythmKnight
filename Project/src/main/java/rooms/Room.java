package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;
import tilesystem.TileType;

import java.util.ArrayList;

public class Room {

    private int origin;
    private int[] unused;
    private int[] gold;
    private int[] monster;
    private int[] exits;
    private int[] mystery;
    private int[] lockedExits;
    private ArrayList<Tile> tiles = new ArrayList<>();

    public Room (int[][] allData) {
        if (allData[0] == null) {
            this.origin = -1;
        } else {
            this.origin = allData[0][0];
        }
        this.unused = allData[1];
        this.gold = allData[2];
        this.monster = allData[3];
        this.exits = allData[4];
        this.mystery = allData[5];
        this.lockedExits = allData[6];
    }

    public Room (int[] unused,
                 int[] gold,
                 int[] monster,
                 int[] exits,
                 int[] mystery,
                 int[] lockedExits) {
        this(-1, unused, gold, monster, exits, mystery, lockedExits);
    }

    public Room (int origin,
                 int[] unused,
                 int[] gold,
                 int[] monster,
                 int[] exits,
                 int[] mystery,
                 int[] lockedExits) {
        this.origin = origin;
        this.unused = unused;
        this.gold = gold;
        this.monster = monster;
        this.exits = exits;
        this.mystery = mystery;
        this.lockedExits = lockedExits;
    }

    public ArrayList<Tile> buildTemplate() {
        // x + 30, y + 25
        // y + 220 for adjacent tiles south
        // y - 220 for adjacent tiles north
        // y - 110 and x + 190 for adjacent tiles northeast
        // y - 110 and x - 190 for adjacent tiles northwest
        // y + 110 and x + 190 for adjacent tiles southeast
        // y + 110 and x - 190 for adjacent tiles southwest

        ArrayList<Point2D> positions = new ArrayList<>();

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

    void setOrigin(int tilePos, ArrayList<Tile> map) {
        if (origin != -1) {
            Point2D swapTilePos = map.get(tilePos).getPosition();
            map.remove(0);
            map.add(0, new Tile(swapTilePos, TileType.ORIGIN));
            map.remove(tilePos);
            map.add(tilePos, new Tile(new Point2D(-1000, -1000), TileType.INVISIBLE));
            map.get(0).setTileID(tilePos);
            map.get(tilePos).setTileID(0);
            map.get(0).setTileID(tilePos);
            map.get(tilePos).setTileID(0);
        }
    }

    void setTileType(int[] cellsNum, TileType type, ArrayList<Tile> map) {
        if (cellsNum != null) {
            for (int i : cellsNum) {
                map.set(i, new Tile((map.get(i).getPosition()), type));
                map.get(i).setTileID(i);
            }
        }
    }

    void removeUnused(int[] cellsNum, ArrayList<Tile> map) {
        if (cellsNum != null) {
            for (int i : cellsNum) {
                map.set(i, new Tile(new Point2D(-1000, -1000), TileType.INVISIBLE));
            }
        }
    }

    public ArrayList<Tile> buildTiles() {
        tiles = buildTemplate();
        setOrigin(origin, tiles);

        removeUnused(unused, tiles);
        setTileType(gold, TileType.GOLD, tiles);
        setTileType(monster, TileType.MONSTER, tiles);
        setTileType(exits, TileType.EXIT, tiles);
        setTileType(lockedExits, TileType.LOCKED_EXIT, tiles);
        setTileType(mystery, TileType.MYSTERY, tiles);

        return tiles;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
