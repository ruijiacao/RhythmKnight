import java.util.LinkedList;
import java.util.List;

public class Measure {
    int bpm;
    LinkedList<Tile> tiles;

    public Measure(int bpm, List<Tile> tiles) {
        this.bpm = bpm;
        this.tiles = new LinkedList<>(tiles);
    }


}
