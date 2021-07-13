package songs;

import java.io.File;

public class SongList {
    private static Song[] songs = new Song[5];

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
                                + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";
                    case 2:
                        return "src" + File.separator + "main" + File.separator + "resources"
                        + File.separator + "assets" + File.separator + "sounds" + File.separator
                        + "Diodes.mp3";
                    case 3:
                        return "." + File.separator + "src" + File.separator + "main" + File.separator
                                + "resources" + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "Diodes.mp3";
                    default:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "Diodes.mp3";
                }
            }

            @Override
            public int getBpm() {
                return 135;
            }
        };

        songs[1] = new Song() {
            @Override
            public String getPath() {
                switch (dir) {
                    case 1:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "UnderPressure.mp3";
                    case 2:
                        return "src" + File.separator + "main" + File.separator + "resources"
                                + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "UnderPressure.mp3";
                    case 3:
                        return "." + File.separator + "src" + File.separator + "main" + File.separator
                                + "resources" + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "UnderPressure.mp3";
                    default:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "UnderPressure.mp3";
                }
            }

            @Override
            public int getBpm() {
                return 100;
            }
        };

        songs[2] = new Song() {
            @Override
            public String getPath() {
                switch (dir) {
                    case 1:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "BlastVelocity.mp3";
                    case 2:
                        return "src" + File.separator + "main" + File.separator + "resources"
                                + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "BlastVelocity.mp3";
                    case 3:
                        return "." + File.separator + "src" + File.separator + "main" + File.separator
                                + "resources" + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "BlastVelocity.mp3";
                    default:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "BlastVelocity.mp3";
                }
            }

            @Override
            public int getBpm() {
                return 120;
            }
        };

        songs[3] = new Song() {
            @Override
            public String getPath() {
                switch (dir) {
                    case 1:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "TheRhythmWizard.mp3";
                    case 2:
                        return "src" + File.separator + "main" + File.separator + "resources"
                                + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "TheRhythmWizard.mp3";
                    case 3:
                        return "." + File.separator + "src" + File.separator + "main" + File.separator
                                + "resources" + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "TheRhythmWizard.mp3";
                    default:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "TheRhythmWizard.mp3";
                }
            }

            @Override
            public int getBpm() {
                return 100;
            }
        };

        songs[4] = new Song() {
            @Override
            public String getPath() {
                switch (dir) {
                    case 1:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "Tutorial.mp3";
                    case 2:
                        return "src" + File.separator + "main" + File.separator + "resources"
                                + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "Tutorial.mp3";
                    case 3:
                        return "." + File.separator + "src" + File.separator + "main" + File.separator
                                + "resources" + File.separator + "assets" + File.separator + "sounds" + File.separator
                                + "Tutorial.mp3";
                    default:
                        return "Project" + File.separator
                                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                                + "assets" + File.separator + "sounds" + File.separator + "Tutorial.mp3";
                }
            }

            @Override
            public int getBpm() {
                return 120;
            }
        };
    }

    public static Song[] getSongs() {
        init();
        return songs;
    }
}
