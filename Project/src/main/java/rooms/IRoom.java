package rooms;

import javafx.geometry.Point2D;
import tilesystem.Tile;

import java.util.ArrayList;

public interface IRoom {
    ArrayList<Tile> buildTiles();
}
