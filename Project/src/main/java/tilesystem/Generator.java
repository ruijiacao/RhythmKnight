package tilesystem;

import java.io.File;
import java.util.Random;

public class Generator {

    public int genRoomID() {
        Random rand = new Random();
        int newRoom = 1 + rand.nextInt(14);

        return newRoom;
    }
}
