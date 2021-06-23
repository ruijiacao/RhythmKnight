import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;

public class Tile {
    private Texture tileTexture;

    public Tile(Texture tileTexture, Point2D position) {
        this.tileTexture = tileTexture;
        tileTexture.setX(position.getX());
        tileTexture.setY(position.getY());
        this.setScale(1.35);
    }

    public void displayOnScene(Conductor conductor, Text scoreText) {
        FXGL.getGameScene().addUINode(tileTexture);
        conductor.checkRhythm(tileTexture, scoreText);
    }

    public void removeFromScene() {
        FXGL.getGameScene().removeUINode(tileTexture);
    }

    public void setTileTexture(Texture tileTexture) {
        this.tileTexture = tileTexture;
    }

    public void setOpacity(double opacity) {
        tileTexture.setOpacity(opacity);
    }

    public void setScale(double scale) {
        tileTexture.setScaleX(scale);
        tileTexture.setScaleY(scale);
    }

    public Texture getTileTexture() {
        return tileTexture;
    }

    public void reset() {
        setScale(1.35);
        setOpacity(1);
    }

}
