import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;

public class Player {
    private String textureName;
    private String username;
    private Texture sprite;

    public Player(Texture sprite, Tile originTile) {
        this.sprite = sprite;
        this.username = GlobalSettings.playerName;

        sprite.setX(originTile.getPosition().getX() - 35);
        sprite.setY(originTile.getPosition().getY() - 95);
        sprite.setScaleX(.35);
        sprite.setScaleY(.35);

        originTile.setPlayerOnTile(true);
        FXGL.getGameScene().addUINodes(sprite);
    }

    public void showOnTile(Tile tile) {

    }
}
