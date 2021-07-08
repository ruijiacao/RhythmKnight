package tilesystem;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;
import rhythm.Conductor;

public class Tile {
    private Texture tileTexture;
    private boolean isActive;
    private boolean playerOnTile;
    private boolean isOrigin;
    private boolean visited;
    private boolean isExit;
    private Conductor passedInConductor;
    private Text passedInText;
    private Point2D position;
    private TileType type;

    public Tile(Point2D position, TileType type) {
        switch(type) {
            case UNVISITED:
                tileTexture = FXGL.getAssetLoader().loadTexture("unvisited.png");
                tileTexture.setX(position.getX());
                tileTexture.setY(position.getY());
                break;
            case VISITED:
                tileTexture = FXGL.getAssetLoader().loadTexture("hex.png");
                tileTexture.setX(position.getX());
                tileTexture.setY(position.getY());
                break;
            case EXIT:
                tileTexture = FXGL.getAssetLoader().loadTexture("stairs.png");
                tileTexture.setX(position.getX());
                tileTexture.setY(position.getY());
                this.setExit(true);
                break;
            case ORIGIN:
                tileTexture = FXGL.getAssetLoader().loadTexture("player.png");
                tileTexture.setX(position.getX());
                tileTexture.setY(position.getY());
        }
        this.position = position;
        this.setScale(1.35);
        isActive = false;
        playerOnTile = false;
    }

    public void displayOnScene(Conductor conductor, Text scoreText) {
        GameView gameView = new GameView(tileTexture, 1);
        FXGL.getGameScene().addGameView(gameView);
        conductor.checkRhythm(this, scoreText);
        isActive = true;
        passedInConductor = conductor;
        passedInText = scoreText;
    }

    public void removeFromScene() {
        FXGL.getGameScene().removeUINode(tileTexture);
        tileTexture.setOnMouseClicked(mouseEvent -> { });
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

    public void setActive(boolean status) {
        isActive = status;
    }

    public void setPlayerOnTile(boolean status) {
        playerOnTile = status;
        if (playerOnTile) {
            tileTexture = FXGL.getAssetLoader().loadTexture("player.png");
        }
    }

    public Texture getTileTexture() {
        return tileTexture;
    }

    public double getOpacity() {
        return tileTexture.getOpacity();
    }

    public double getScale() {
        return tileTexture.getScaleX();
    }

    public Point2D getPosition() {
        return new Point2D(tileTexture.getX(), tileTexture.getY());
    }

    public TileType getType() {
        return type;
    }

    public boolean isPlayerOnTile() {
        return playerOnTile;
    }

    public boolean isTileActive() {
        return isActive;
    }

    public boolean isOrigin() {
        return isOrigin;
    }

    public void setOrigin(boolean origin) {
        isOrigin = origin;
    }

    public void reset() {
        setScale(1.35);
        setOpacity(1);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }
}