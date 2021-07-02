package rhythm;

import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
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

    public void startAndKeepRhythm(Texture cutout) {
        numOfBeats = (int) (bpm * (ost.getDuration().toSeconds() / 60)) + 1;
        beatTimes = new double[numOfBeats];

        int i = 1;
        while (i < beatTimes.length) {
            beatTimes[i] = (60.0 / bpm) * i;
            i++;
        }

        System.out.println();

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

    public void checkRhythm(Tile tile, Text scoreText) {
        tile.getTileTexture().setOnMouseClicked(mouseEvent -> {
            Animator animator = new Animator();
            if (isOnBeat) {
                if (mouseEvent.getX() - 120 > GlobalSettings.getPlayerSprite().getX() - 600 &&
                        mouseEvent.getX() + 120 < GlobalSettings.getPlayerSprite().getX() + 600 &&
                        mouseEvent.getY() - 170 > GlobalSettings.getPlayerSprite().getY() - 600 &&
                        mouseEvent.getY() - 170 < GlobalSettings.getPlayerSprite().getY() + 600) {
                    GlobalSettings.setPlayerPos(new Point2D(mouseEvent.getX() - 120, mouseEvent.getY() - 170));
                    playerScore += 10 + scoreConstant.get();
                    scoreText.setText("Level " + Initializer.getCurrLevel() + " / Floor "
                            + Initializer.getCurrFloor() + "\n" + Integer.toString(playerScore));
                    animator.pulsateScore(scoreText);
                    animator.pulsateTile(tile.getTileTexture());
                    FXGL.getAudioPlayer().playSound(hit);
                    tile.setPlayerOnTile(true);
                }
            }
        });
    }

}