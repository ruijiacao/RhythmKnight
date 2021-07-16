package songs;

import java.io.File;

public class CustomSongList {
    private static Song[] songs = new Song[1];

    // check the switch statements below to determine which return statement to use
    // based on your directory settings

    private static final int dir = 1;

    private static void init() {
        songs[0] = new Song() {
            @Override
            public String getPath() {
                switch (dir) {
                    case 1:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "custom" + File.separator
                                + "Arlow - Freefall.mp3";
                    case 2:
                        return "src" + File.separator + "main" + File.separator + "resources"
                                + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "custom" + File.separator + "Arlow - Freefall.mp3";
                    case 3:
                        return "." + File.separator + "src" + File.separator + "main" + File.separator
                                + "resources" + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "custom" + File.separator + "Arlow - Freefall.mp3";
                    default:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "custom" + File.separator
                                + "Arlow - Freefall.mp3";
                }
            }

            @Override
            public int getBpm() {
                return 87;
            }
        };
    }

    public static Song[] getSongs() {
        init();
        return songs;
    }
}
