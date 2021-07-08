package tilesystem;

import javafx.scene.text.Text;
import rhythm.Conductor;

import java.util.Random;

public class Generator {

    /*
    ========== GENERATE NEW ROOM ID ==========
    A public method that uses Random to get a
    random layout room id.
    ==========================================
     */
    public static int genRoomID() {
        Random rand = new Random();
        int newRoom = 1 + rand.nextInt(14);

        return newRoom;
    }

    /*
    ========== GENERATE NEW ROOM ==========
    Core method for generating a new room. Works by:
    - Generating a unique room ID using previous method
    - Passes the room ID to the map loader, which loads the map onto the scene
    ========================================
     */
    public static void genNewRoom(Conductor conductor, Text scoreText) {
        int newID = genRoomID();
        MapLoader.loadMap(newID, conductor, scoreText);
    }
}
