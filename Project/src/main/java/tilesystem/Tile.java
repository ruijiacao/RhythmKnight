package tilesystem;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;
import monsters.Monster;
import monsters.Slime;
import monsters.Wizard;
import monsters.Zombie;
import rhythm.Conductor;

import java.util.Random;
import settings.GlobalSettings;

public class Tile {
    private Texture tileTexture;
    private boolean isActive;
    private boolean playerOnTile;
    private boolean isOrigin;
    private boolean visited;
    private boolean isExit;
    private boolean isGold;
    private int goldAmount;
    private Conductor passedInConductor;
    private Text passedInText;
    private Point2D position;
    private TileType type;
    private int pathID;
    private int tileID;
    private boolean isMonster;
    private Monster monster;

    public Tile(Point2D position, TileType type) {
        switch (type) {
//        case UNVISITED:
//            tileTexture = FXGL.getAssetLoader().loadTexture("newUnvisitedTile.png");
//            tileTexture.setX(position.getX());
//            tileTexture.setY(position.getY());
//            break;
//        case VISITED:
//            tileTexture = FXGL.getAssetLoader().loadTexture("normal-tile.png");
//            tileTexture.setX(position.getX());
//            tileTexture.setY(position.getY());
//            visited = true;
//            break;
        case INVISIBLE:

            break;
        case EXIT:
            tileTexture = FXGL.getAssetLoader().loadTexture("newStaircase.png");
            tileTexture.setX(position.getX() - 30);
            tileTexture.setY(position.getY() - 20);
            visited = true;
            this.setExit(true);
            break;
        case ORIGIN:
            tileTexture = FXGL.getAssetLoader().loadTexture("player.png");
            tileTexture.setX(position.getX());
            tileTexture.setY(position.getY());
            isOrigin = true;
            visited = true;
            break;
        case MONSTER:
            Random rand = new Random();
            int monsterID = rand.nextInt(3);
            isMonster = true;
            visited = true;
            if (monsterID == 0) {
                tileTexture = FXGL.getAssetLoader().loadTexture("slime-tile.gif");
                tileTexture.setX(position.getX());
                tileTexture.setY(position.getY());
                Slime slime = new Slime(this);
                monster = slime;
            } else if (monsterID == 1) {
                tileTexture = FXGL.getAssetLoader().loadTexture("zombie-tile.gif");
                tileTexture.setX(position.getX());
                tileTexture.setY(position.getY());
                Zombie zombie = new Zombie(this);
                monster = zombie;
            } else {
                tileTexture = FXGL.getAssetLoader().loadTexture("wizard-tile.gif");
                tileTexture.setX(position.getX());
                tileTexture.setY(position.getY());
                Wizard wizard = new Wizard(this);
                monster = wizard;
            }
            break;
        case GOLD:
            tileTexture = FXGL.getAssetLoader().loadTexture("newGoldTile.png");
            tileTexture.setX(position.getX());
            tileTexture.setY(position.getY());
            isGold = true;
            setGoldAmount(15);
            visited = false;
            break;
        case MYSTERY:
            tileTexture = FXGL.getAssetLoader().loadTexture("newMystery.png");
            tileTexture.setX(position.getX());
            tileTexture.setY(position.getY());
            visited = false;
            break;
        case LOCKED_EXIT:
            tileTexture = FXGL.getAssetLoader().loadTexture("lockedExitTile.png");
            tileTexture.setX(position.getX() - 30);
            tileTexture.setY(position.getY() - 20);
            visited = true;
            break;
        case EXITS_DUNGEON:
            tileTexture = FXGL.getAssetLoader().loadTexture("exitDungeonTile.png");
            tileTexture.setX(position.getX());
            tileTexture.setY(position.getY());
            isExit = true;
            visited = true;
            break;
        default:
            visited = false;
        }
        if (!visited) {
            tileTexture = FXGL.getAssetLoader().loadTexture("newUnvisitedTile.png");
            tileTexture.setX(position.getX());
            tileTexture.setY(position.getY());
        }
        this.position = position;
        this.setScale(1.35);
        isActive = false;
        playerOnTile = false;
        this.type = type;
    }
    public Tile(Point2D position) {
        visited = false;
        tileTexture = FXGL.getAssetLoader().loadTexture("newUnvisitedTile.png");
        tileTexture.setX(position.getX());
        tileTexture.setY(position.getY());
        this.position = position;
        this.setScale(1.35);
        isActive = false;
        playerOnTile = false;
        this.type = TileType.NORMAL;
    }

    public void displayOnScene() {
        GameView gameView = new GameView(tileTexture, 1);
        tileTexture.setX(position.getX());
        tileTexture.setY(position.getY());
        this.setScale(1.35);
        FXGL.getGameScene().addGameView(gameView);
//        isActive = true;
    }


    public void tileClick(Conductor conductor, Text scoreText) {
        passedInConductor = conductor;
        passedInText = scoreText;
        conductor.checkRhythm(this, scoreText);
    }

    public void removeFromScene() {
        FXGL.getGameScene().removeUINode(tileTexture);
        tileTexture.setOnMouseClicked(mouseEvent -> { });
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

    public void setVisited() {
        this.visited = true;
        removeFromScene();
        setTileTexture(FXGL.getAssetLoader().loadTexture("normal-tile.png"));
        displayOnScene();
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

    public void setGold(boolean gold) {
        isGold = gold;
    }

    public boolean isGold() {
        return isGold;
    }

    public int getPathID() {
        return pathID;
    }

    public void setPathID(int pathID) {
        this.pathID = pathID;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    public int getTileID() {
        return tileID;
    }

    public boolean isMonster() {
        return isMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    public void setGoldTaken() {
        setGoldAmount(0);
    }

    public void refresh() {
        removeFromScene();
//        setTileTexture(FXGL.getAssetLoader().loadTexture("normal-tile.png"));
        displayOnScene();
    }
}