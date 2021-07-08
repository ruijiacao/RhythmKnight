package rhythm;

import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import initializers.Level_UI_Initializer;
import javafx.geometry.Point2D;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;
import settings.GlobalSettings;
import tilesystem.*;
import initializers.Initializer;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;


public class Conductor {

    private static Media ost;
    private static MediaPlayer ostPlayer;
    private int bpm;
    private int numOfBeats;
    private double[] beatTimes;
    private Sound hit;
    private int playerScore;
    private boolean isOnBeat;
    private AtomicInteger scoreConstant;

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
    - Calculates the exact time a beat will be reached in a song and places that timestamp in the array
    - Initially sets that the song is not on a beat
    - Plays the song
    - Every 1/60 seconds, it checks if the current timestamp matches the next beat's timestamp in the array
    - Sets the boolean true if it is and false otherwise
    - Calls the Animator class to animate the white cutout border pulsating on every beat.
    =============================================
     */
    public void startAndKeepRhythm(Texture cutout) {
        numOfBeats = (int) (bpm * (ost.getDuration().toSeconds() / 60)) + 1;
        beatTimes = new double[numOfBeats];

        int i = 1;
        while (i < beatTimes.length) {
            beatTimes[i] = (60.0 / bpm) * i;
            i++;
        }

        hit = FXGL.getAssetLoader().loadSound("snare01.wav");
        isOnBeat = false;

        ostPlayer.play();
        FXGL.getGameScene().addUINode(cutout);

        AtomicInteger currBeat = new AtomicInteger(1);
        Animator animator = new Animator();

        FXGL.getGameTimer().runAtInterval(() -> {
            double currTime = ostPlayer.getCurrentTime().toSeconds();

            if (currTime >= beatTimes[currBeat.get()] - .1) {
                currBeat.set(currBeat.get() + 1);
                scoreConstant = new AtomicInteger(15);

                FXGL.getGameTimer().runAtInterval(() -> {
                    animator.pulsateCutout(cutout);
                    isOnBeat = true;
                    scoreConstant.set(scoreConstant.get() - 1);
                }, Duration.millis(1), 15);
            } else {
                isOnBeat = false;
                cutout.setOpacity(0);
            }
        }, Duration.seconds(1 / 60.0));
    }

    /*
    ========== CHECK PLAYER'S RHYTHM ==========
    The core movement method for the game. It works by:
    - Adding a MouseEvent Listener to a passed in Tile
    - When a MouseEvent is fired off, it checks if the player is on beat with the song
    - If the player is on beat, it then checks if the player's requested movement is within boundaries
    - If the location is within boundaries, it moves to the tile requested and plays noise
    - If the location is an exit tile, it calls Generator to generate a new dungeon room.
     */
    public void checkRhythm(Tile tile, Text scoreText) {
        tile.getTileTexture().setOnMouseClicked(mouseEvent -> {
            Animator animator = new Animator();
            if (isOnBeat) {
                if (mouseEvent.getX() - 120 > GlobalSettings.getPlayerSprite().getX() - 600 &&
                        mouseEvent.getX() + 120 < GlobalSettings.getPlayerSprite().getX() + 600 &&
                        mouseEvent.getY() - 170 > GlobalSettings.getPlayerSprite().getY() - 600 &&
                        mouseEvent.getY() - 170 < GlobalSettings.getPlayerSprite().getY() + 600) {

                    Point2D position = tile.getPosition();

                    GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50, position.getY() - 100));

                    animator.pulsateScore(scoreText);
                    animator.pulsateTile(tile.getTileTexture());

                    if (tile.isOrigin()) {
                        tile.removeFromScene();
                        Tile visited = new Tile(position, TileType.ORIGIN);
                        visited.setOrigin(true);
                        visited.setVisited(true);
                        visited.displayOnScene(this, scoreText);
                    } else if (!tile.isVisited()) {
                        if (tile.isGold()) {
                            Initializer.setGold(Initializer.getGold() + 15);
                            Level_UI_Initializer.updateGold(Initializer.getGold());
                        }

                        tile.removeFromScene();
                        Tile visited = new Tile(position, TileType.VISITED);
                        visited.displayOnScene(this, scoreText);

                        playerScore += 10 + scoreConstant.get();
                        scoreText.setText("Level " + Initializer.getCurrLevel() + " / Floor "
                                + Initializer.getCurrFloor() + "\n" + Integer.toString(playerScore));

                        tile.setVisited(true);
                    }

                    if (tile.isExit()) {
                        Generator.genNewRoom(this, scoreText);
                    }

                    FXGL.getAudioPlayer().playSound(hit);
                    tile.setPlayerOnTile(true);
                }
            }
        });
    }

}