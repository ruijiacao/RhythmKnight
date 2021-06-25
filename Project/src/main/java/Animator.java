import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class Animator {
    public void pulsateCutout(Texture cutout) {
        cutout.setOpacity(1);
        FXGL.run(() -> {
            cutout.setOpacity(cutout.getOpacity() - 1 / 15.0);
        }, Duration.millis(1), 15);
    }

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