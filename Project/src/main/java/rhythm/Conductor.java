package rhythm;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import initializers.LevelUIInitializer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;
import monsters.Monster;
import monsters.Slime;
import monsters.Wizard;
import monsters.Zombie;
import settings.GlobalSettings;
import tilesystem.*;
import ui.Notifier;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;


public class Conductor {

    private static Media ost;
    private static MediaPlayer ostPlayer;
    private static boolean isActive;
    private final int bpm;
    private static int numOfBeats;
    private static double[] beatTimes;
    private final int playerScore;
    private static boolean isOnBeat;
    private AtomicInteger scoreConstant;
    private AtomicInteger currBeat = new AtomicInteger();
    private static Texture cutout;
    private static Text scoreText;

    public Conductor(int bpm, String path, int playerScore) {
        ost = new Media(new File(path).toURI().toString());
        ostPlayer = new MediaPlayer(ost);
        this.bpm = bpm;
        this.playerScore = playerScore;
    }

    /*
    ========== START AND KEEP RHYTHM ==========
    The core method that the game relies on. It works by doing the following:
    - Calculates the amount of beats a single song has
    - Creates an array of size of the number of beats a song has + 1
    - Calculates the exact time a beat will be reached in a song and places that timestamp
      in the array
    - Initially sets that the song is not on a beat
    - Plays the song
    - Every 1/60 seconds, it checks if the current timestamp matches the next beat's
      timestamp in the array
    - Sets the boolean true if it is and false otherwise
    - Calls the Animator class to animate the white cutout border pulsating on every beat.
    =============================================
     */
    public void startAndKeepRhythm(Texture cutoutTexture) {
        cutout = cutoutTexture;

        numOfBeats = (int) (bpm * (ost.getDuration().toSeconds() / 60)) + 1;
        beatTimes = new double[numOfBeats];
        isActive = true;

        System.out.println("Number of beats: " + numOfBeats + " on");
        System.out.println(ost.getDuration().toSeconds());

        int i = 1;
        while (i < beatTimes.length) {
            beatTimes[i] = (60.0 / bpm) * i;
            i++;
        }

        isOnBeat = false;

        ostPlayer.play();
        FXGL.getGameScene().addUINode(cutout);

        currBeat = new AtomicInteger(1);
        Animator animator = new Animator();

        FXGL.getGameTimer().runAtInterval(() -> {
            if (isActive) {
                double currTime = ostPlayer.getCurrentTime().toSeconds();
                TileMap curr = GlobalSettings.getCurrentMap();

                if (currTime >= beatTimes[numOfBeats - 1] - .1) {
                    stopOST();
                    Notifier.createGameOverAlert();
                }

                if (currTime >= beatTimes[currBeat.get()] - .1) {
                    if (currBeat.get() % 4 == 0) {
                        for (Tile tile : curr.getTiles()) {
                            animator.tileDance(tile.getTileTexture());
                        }
                    }
                    animator.playerDance();
                    currBeat.set(currBeat.get() + 1);
                    scoreConstant = new AtomicInteger(15);

                    if (!GlobalSettings.getActiveMonsters().isEmpty()) {
                        for (Monster monster : GlobalSettings.getActiveMonsters()) {
                            if (monster instanceof Slime && currBeat.get() % 2 == 0) {
                                monster.attack();
                            } else if (monster instanceof Zombie && currBeat.get() % 6 == 0) {
                                monster.attack();
                            } else if (monster instanceof Wizard && currBeat.get() % 4 == 0) {
                                monster.attack();
                            }
                        }
                    }

                    FXGL.getGameTimer().runAtInterval(() -> {
                        animator.pulsateCutout(cutout);
                        isOnBeat = true;
                        scoreConstant.set(scoreConstant.get() - 1);
                    }, Duration.millis(1), 15);
                } else {
                    isOnBeat = false;
                    cutout.setOpacity(0);
                }
            }
            LevelUIInitializer.updateTimeElapsed();
        }, Duration.seconds(1 / 60.0));
    }

    /*
    ========== CHECK PLAYER'S RHYTHM ==========
    The core movement method for the game. It works by:
    - Adding a MouseEvent Listener to a passed in Tile
    - When a MouseEvent is fired off, it checks if the player is on beat with the song
    - If the player is on beat, it then checks if the player's requested movement is within
      boundaries
    - If the location is within boundaries, it moves to the tile requested and plays noise
    - If the location is an exit tile, it calls Generator to generate a new dungeon room.
     */
    public void checkRhythm(Tile tile, Text scoreText) {
        Animator anim = new Animator();
        tile.getTileTexture().setOnMouseClicked(mouseEvent -> {
            if (isOnBeat) {
                Mover.move(mouseEvent, tile, this, scoreText, playerScore, scoreConstant.get());
            } else {
                LevelUIInitializer.updateStatus("Offbeat, the screen outline\npulses to the beat!");
            }
        });
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public static void stopOST() {
        ostPlayer.stop();
        isActive = false;
    }

    public static Texture getCutout() {
        return cutout;
    }

    public static void setCutout(Texture cutoutTexture) {
        cutout = cutoutTexture;
    }

    public static MediaPlayer getOstPlayer() {
        return ostPlayer;
    }
}