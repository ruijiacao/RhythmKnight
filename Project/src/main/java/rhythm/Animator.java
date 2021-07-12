package rhythm;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class Animator {
    /*
    ========== PULSATE THE CUTOUT ==========
    Pulsates the white border cutout during
    every beat by decreasing its opacity for
    15 frames. The first frame of every 15
    frame interval is reset to 100% opacity.
    =========================================
     */
    public void pulsateCutout(Texture cutout) {
        cutout.setOpacity(1);
        FXGL.run(() -> {
            cutout.setOpacity(cutout.getOpacity() - 1 / 15.0);
        }, Duration.millis(1), 15);
    }

    /*
    ========== PULSATE A TILE ==========
    When a tile is clicked on, a small animation
    of a Tile increasing in size and decreasing
    in opacity over a 15 frame interval is played.
    ====================================
     */
    public void pulsateTile(Texture tile) {
        FXGL.run(() -> {
            tile.setScaleX(tile.getScaleX() + 1 / 15.0);
            tile.setScaleY(tile.getScaleX() + 1 / 15.0);
            tile.setOpacity(tile.getOpacity() - 1 / 15.0);
        }, Duration.millis(1), 15);
        tile.setScaleX(1.35);
        tile.setScaleY(1.35);
        tile.setOpacity(1);
    }

    /*
    ============ PULSATE THE SCORE ==========
    When a new tile is explored, the score
    moves along with the beat and a new
    score value is added to it.
    ==========================================
     */
    public void pulsateScore(Text score) {
        score.setScaleX(2);
        score.setScaleY(2);
        AtomicInteger frame = new AtomicInteger(0);

        FXGL.run(() -> {
            frame.addAndGet(1);
            if (frame.get() == 30) {
                score.setScaleX(3);
                score.setScaleY(3);
                frame.set(0);
            }
            score.setScaleX(score.getScaleX() + .03);
            score.setScaleY(score.getScaleY() + .03);
        }, Duration.millis(1), 30);
    }
}