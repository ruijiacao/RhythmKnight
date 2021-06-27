package tilesystem;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;
import rhythm.Conductor;

public class Tile {
    private Texture tileTexture;
    private boolean isActive;
    private boolean playerOnTile;
    private Conductor passedInConductor;
    private Text passedInText;

    public Tile(Texture tileTexture, Point2D position) {
        this.tileTexture = tileTexture;
        tileTexture.setX(position.getX());
        tileTexture.setY(position.getY());
        this.setScale(1.35);
        isActive = false;
        playerOnTile = false;
    }

    public void displayOnScene(Conductor conductor, Text scoreText) {
        FXGL.getGameScene().addUINode(tileTexture);
        conductor.checkRhythm(this, scoreText);
        isActive = true;
        passedInConductor = conductor;
        passedInText = scoreText;
    }

    public void removeFromScene() {
        FXGL.getGameScene().removeUINode(tileTexture);
        tileTexture.setOnMouseClicked(mouseEvent -> {});
        isActive = false;
        playerOnTile = false;
    }

    public void setTileTexture(Texture tileTexture) {
        this.tileTexture = tileTexture;
        removeFromScene();
        displayOnScene(passedInConductor, passedInText);
    }

    public void setOpacity(double opacity) {
        tileTexture.setOpacity(opacity);
    }

    public void setScale(double scale) {
        tileTexture.setScaleX(scale);
        tileTexture.setScaleY(scale);
    }

    public void setActive(boolean status) {isActive = status;}

    public void setPlayerOnTile(boolean status) {
        playerOnTile = status;
        if (playerOnTile = true) {
            tileTexture = FXGL.getAssetLoader().loadTexture("player.png");
        }
    }

    public Texture getTileTexture() {
        return tileTexture;
    }

    public double getOpacity() { return tileTexture.getOpacity(); }

    public double getScale() { return tileTexture.getScaleX(); }

    public Point2D getPosition() {return new Point2D(tileTexture.getX(), tileTexture.getY());}

    public boolean isPlayerOnTile() {return playerOnTile;}

    public boolean isTileActive() {return isActive;}

    public void reset() {
        setScale(1.35);
        setOpacity(1);
    }

}