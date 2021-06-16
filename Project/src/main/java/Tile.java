import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public class Tile extends Entity {

    public void enterScene() {
        this.setScaleX(2);
        this.setScaleY(2);
        FXGL.run(() -> {
            this.setScaleX(this.getScaleX() - .5);
            this.setScaleY(this.getScaleY() - .5);
        }, Duration.millis(150), 4);
    }

}
