package rhythm;

import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import initializers.Initializer;
import initializers.LevelUIInitializer;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import rooms.TemplateRoom;
import settings.GlobalSettings;
import tilesystem.MapLoader;
import tilesystem.Tile;
import tilesystem.TileType;
import ui.Notifier;

import java.util.Random;


public class Mover {
    private static Conductor conductor;
    private static Text scoreText;
    private static final Animator animator = new Animator();
    private static final Sound click = FXGL.getAssetLoader().loadSound("snare01.wav");

    private static boolean verifyBounds(Tile tile) {
        return tile.getTileID() == GlobalSettings.getCurrPlayerTile() + 1 
                || tile.getTileID() == GlobalSettings.getCurrPlayerTile() - 1 
                || tile.getTileID() == GlobalSettings.getCurrPlayerTile() + 3 
                || tile.getTileID() == GlobalSettings.getCurrPlayerTile() - 3
                || tile.getTileID() == GlobalSettings.getCurrPlayerTile() + 4
                || tile.getTileID() == GlobalSettings.getCurrPlayerTile() - 4;
    }

    private static void goBackInPath() {
        GlobalSettings.setRoomCounter(GlobalSettings.getRoomCounter() - 1);
        if (GlobalSettings.getRoomCounter() == 0) {
            MapLoader.loadMap(0, conductor, scoreText);
        } else {
            MapLoader
                    .loadMap(GlobalSettings.getPath(GlobalSettings.getPathChosen())
                            [GlobalSettings.getRoomCounter()], conductor, scoreText);
        }
    }

    private static void goForwardInPath(Tile exit) {
        if (GlobalSettings.getRoomCounter() == 7 + GlobalSettings.getDifficulty()) {
            Notifier.createWinAlert();
        } else if (GlobalSettings.getRoomCounter() == 6
                + GlobalSettings.getDifficulty()) {
            MapLoader.loadMap(21, conductor, scoreText);
            GlobalSettings.setRoomCounter(7 + GlobalSettings.getDifficulty());
        } else if (GlobalSettings.getRoomCounter() == 0) {
            GlobalSettings.setPathChosen(exit.getPathID());
            GlobalSettings.setRoomCounter(GlobalSettings.getRoomCounter() + 1);
            MapLoader
                    .loadMap(GlobalSettings.getPath(GlobalSettings.getPathChosen())[1],
                            conductor, scoreText);
        } else {
            GlobalSettings.setRoomCounter(GlobalSettings.getRoomCounter() + 1);
            MapLoader
                    .loadMap(GlobalSettings.getPath(GlobalSettings.getPathChosen())
                            [GlobalSettings.getRoomCounter()], conductor, scoreText);
        }
    }

    private static void startAttacking(Tile tile, Text dmg) {
        tile.getMonster().enterBattle();
        int damage = (3 - GlobalSettings.getDifficulty()) * (20 + new Random().nextInt(10));
        tile.getMonster().doDamage(damage);
        dmg.setText(Integer.toString(damage));
        animator.displayDamage(dmg, tile);
        FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-enemy.wav"));
    }

    private  static void attackMonster(Tile tile, Text dmg) {
        int damage = (3 - GlobalSettings.getDifficulty()) * (10 + new Random().nextInt(10));
        tile.getMonster().doDamage(damage);
        dmg.setText(Integer.toString(damage));
        animator.displayDamage(dmg, tile);
        FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-enemy.wav"));
    }

    public static void move(MouseEvent event, Tile tile, Conductor passedInCond, Text passedInScore, int score, int scoreConstant) {
        conductor = passedInCond;
        scoreText = passedInScore;

        if (verifyBounds(tile)) {
            Point2D position;
            position = tile.getPosition();

            if (tile.isExit()) {
                GlobalSettings.getPlayerSprite().setScaleX(.35);
                GlobalSettings.getPlayerSprite().setScaleY(.35);
                goForwardInPath(tile);
            } else if (tile.isOrigin() && GlobalSettings.getRoomCounter() != 0) {
                GlobalSettings.getPlayerSprite().setScaleX(.35);
                GlobalSettings.getPlayerSprite().setScaleY(.35);
                goBackInPath();
            } else if (tile.getMonster() != null && !tile.getMonster().isDefeated()) {
//                position = new TemplateRoom().buildTiles().get(tile.getTileID()).getPosition();
                Text dmg = new Text("0");
                dmg.setX(position.getX());
                dmg.setY(position.getY() - 20);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                if (!tile.getMonster().isInCombat()) {
                    startAttacking(tile, dmg);
                } else {
                    attackMonster(tile, dmg);
                }
            } else if (tile.getMonster() != null && tile.getMonster().isDefeated()) {
                position = tile.getPosition();
                animator.playerMoved();
                animator.pulsateScore(scoreText);
                animator.pulsateTile(tile.getTileTexture());

                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));

//                Tile visited = new Tile(position, TileType.VISITED);
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.setVisited();
                tile.tileClick(conductor, scoreText);
//                visited.tileClick(conductor, scoreText);
                score += 50 + scoreConstant;
                scoreText.setText("Level " + Initializer.getCurrLevel() + " / Floor "
                        + Initializer.getCurrFloor() + "\n" + score);

            } else if (!tile.isVisited()) {
//                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                animator.playerMoved();
                animator.pulsateScore(scoreText);
                animator.pulsateTile(tile.getTileTexture());
                if (tile.getType().equals(TileType.LOCKED_EXIT)) {
                    GlobalSettings.setPlayerPos(new Point2D(position.getX() - 20,
                            position.getY() - 80));
                } else {
                    GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                            position.getY() - 100));
                }

                if (tile.isGold()) {
                    if (tile.getGoldAmount() != 0) {
                        Initializer.setGold(Initializer.getGold() + tile.getGoldAmount());
                        tile.setGoldTaken();
                        LevelUIInitializer.updateGold(Initializer.getGold());
                    }
                }

                if (tile.getType().equals(TileType.LOCKED_EXIT)) {
                    tile.setPosition(new Point2D(position.getX() + 30, position.getY() + 20));
                }
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.setVisited();
                tile.tileClick(conductor, scoreText);

                score += 10 + scoreConstant;
                scoreText.setText("Level " + Initializer.getCurrLevel() + " / Floor "
                        + Initializer.getCurrFloor() + "\n" + score);

                GlobalSettings.setPlayerHealth(GlobalSettings.getPlayerHealth() + new Random().nextInt(11));
                LevelUIInitializer.updateHealth(GlobalSettings.getPlayerHealth());

            } else {
                animator.playerMoved();
                animator.pulsateTile(tile.getTileTexture());
                tile.removeFromScene();
                tile.setTileTexture(FXGL.getAssetLoader().loadTexture("normal-tile.png"));
                tile.displayOnScene();

                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.tileClick(conductor, scoreText);
                if (tile.getType().equals(TileType.LOCKED_EXIT)) {
                    GlobalSettings.setPlayerPos(new Point2D(position.getX() - 20,
                            position.getY() - 80));
                } else {
                    GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                            position.getY() - 100));
                }

            }

            FXGL.getAudioPlayer().playSound(click);
//            tile.setPlayerOnTile(true);
        }
    }
}
