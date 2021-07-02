package tilesystem;

import java.io.File;
import java.util.Random;

public class Generator {

    public String genNewRoom() {
        Random rand = new Random();
        int newRoom = 1 + rand.nextInt(14);
        String path = "layouts" + File.pathSeparator +
                "dungeon" + File.pathSeparator + "layout" + newRoom + ".png";

        return path;

    }
}
