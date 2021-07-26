package rhythm;

import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.FXGL;
import initializers.LevelUIInitializer;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import monsters.Monster;
import settings.GlobalSettings;
import tilesystem.MapLoader;
import tilesystem.Tile;
import tilesystem.TileType;
import ui.Notifier;

import java.util.Random;


public class Mover {
    private static Conductor conductor;
    private static Text scoreText;
    private static final Animator ANIMATOR = new Animator();
    private static final Sound CLICK = FXGL.getAssetLoader().loadSound("snare01.wav");

    private static boolean verifyBounds(Tile tile) {
        return tile.getTileID() == GlobalSettings.getCurrPlayerTile() + 1
                || tile.getTileID() == GlobalSettings.getCurrPlayerTile()
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
            LevelUIInitializer.updateStatus("You escaped the dungeon!");
            Notifier.createWinAlert();
        } else if (GlobalSettings.getRoomCounter() == 6
                + GlobalSettings.getDifficulty()) {
            GlobalSettings.setRoomCounter(7 + GlobalSettings.getDifficulty());
            MapLoader.loadMap(21, conductor, scoreText);
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

    private static void attackMonster(Tile tile, Text dmg) {
        Monster monster = tile.getMonster();
        if (!monster.inCombat()) {
            monster.enterBattle();
        }
        int damage = (3 - GlobalSettings.getDifficulty()) * (10 + new Random().nextInt(10));
        monster.takeDamage(damage);
        dmg.setText(Integer.toString(damage));
        ANIMATOR.displayDamage(dmg, tile);
        FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-enemy.wav"));
    }

    public static void move(MouseEvent event, Tile tile, Conductor passedInCond, Text passedInScore,
        int score, int scoreConstant) {
        conductor = passedInCond;
        scoreText = passedInScore;
        if (verifyBounds(tile)) {
            Point2D position;
            position = tile.getPosition();
            if (tile.isExit()) {
                GlobalSettings.getPlayerSprite().setScaleX(.35);
                GlobalSettings.getPlayerSprite().setScaleY(.35);
                goForwardInPath(tile);
                scoreText.setText("Room " + (GlobalSettings.getRoomCounter() + 1)
                    + "\nScore: " + GlobalSettings.getPlayer().getScore());
                LevelUIInitializer.updateStatus("Moving to new room!");
            } else if (tile.isOrigin() && GlobalSettings.getRoomCounter() != 0) {
                GlobalSettings.getPlayerSprite().setScaleX(.35);
                GlobalSettings.getPlayerSprite().setScaleY(.35);
                goBackInPath();
                scoreText.setText("Room " + (GlobalSettings.getRoomCounter() + 1)
                    + "\nScore: " + GlobalSettings.getPlayer().getScore());
                LevelUIInitializer.updateStatus("Retreating to previous room!");
            } else if (tile.isOrigin()) {
                ANIMATOR.playerMoved();
                ANIMATOR.pulsateTile(tile.getTileTexture());
                tile.removeFromScene();
                tile.setTileTexture(FXGL.getAssetLoader().loadTexture("player.png"));
                tile.displayOnScene();
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));
                tile.tileClick(conductor, scoreText);
            } else if (tile.getMonster() != null && !tile.getMonster().isDefeated()) {
                Text dmg = new Text("0");
                dmg.setX(position.getX());
                dmg.setY(position.getY() - 20);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                attackMonster(tile, dmg);
                LevelUIInitializer.updateStatus("Attacked the monster!");
                if (tile.getMonster().isDefeated()) {
                    GlobalSettings.getActiveMonsters().remove(tile.getMonster());
                    LevelUIInitializer.updateStatus("Monster slain!");
                    ANIMATOR.playerMoved();
                    ANIMATOR.pulsateScore(scoreText);
                    ANIMATOR.pulsateTile(tile.getTileTexture());
                    GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));
                    GlobalSettings.setCurrPlayerTile(tile.getTileID());
                    tile.setVisited();
                    tile.tileClick(conductor, scoreText);
                    score += (50 + scoreConstant);
                    GlobalSettings.getPlayer().updateScore(score);
                    scoreText.setText("Room " + (GlobalSettings.getRoomCounter() + 1)
                        + "\nScore: " + GlobalSettings.getPlayer().getScore());
                    if (GlobalSettings.getActiveMonsters().isEmpty()) {
                        LevelUIInitializer.updateStatus("Monster slain!"
                            + "\nMonsters defeated, doors unlocked!");
                        for (Tile t : GlobalSettings.getCurrentMap().getTiles()) {
                            if (t.getType().equals(TileType.LOCKED_EXIT)) {
                                t.removeFromScene();
                                t.setTileTexture(FXGL.getAssetLoader()
                                    .loadTexture("newStaircase.png"));
                                t.displayOnScene();
                                passedInCond.checkRhythm(t, scoreText);
                                t.setExit(true);
                            }
                        }
                    }
                }
            } else if (tile.getMonster() != null && tile.getMonster().isDefeated()) {
                position = tile.getPosition();
                ANIMATOR.playerMoved();
                ANIMATOR.pulsateScore(scoreText);
                ANIMATOR.pulsateTile(tile.getTileTexture());
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.setVisited();
                tile.tileClick(conductor, scoreText);
            } else if (!tile.isVisited() && !tile.getType().equals(TileType.LOCKED_EXIT)) {
                ANIMATOR.playerMoved();
                ANIMATOR.pulsateScore(scoreText);
                ANIMATOR.pulsateTile(tile.getTileTexture());
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));
                LevelUIInitializer.updateStatus("Explored unvisited tile!");
                if (tile.isGold()) {
                    int gold = tile.getGoldAmount();
                    if (gold != 0) {
                        LevelUIInitializer.updateStatus("Picked up " + gold + " gold!");
                        GlobalSettings.getPlayer().pickedUpGold(gold);
                        tile.setGoldTaken();
                        LevelUIInitializer.updateGold(GlobalSettings.getPlayer().getGold());
                    }
                } else if (tile.getType().equals(TileType.MYSTERY)) {
                    LevelUIInitializer.updateStatus("Found a chest!");
                }
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.setVisited();
                tile.tileClick(conductor, scoreText);
                score += (10 + scoreConstant);
                GlobalSettings.getPlayer().updateScore(score);
                scoreText.setText("Room " + (GlobalSettings.getRoomCounter() + 1)
                    + "\nScore: " + GlobalSettings.getPlayer().getScore());
                GlobalSettings.getPlayer().updateHealth(new Random().nextInt(11));
                LevelUIInitializer.updateHealth(GlobalSettings.getPlayerHealth());
            } else if (tile.getType().equals(TileType.LOCKED_EXIT)) {
                LevelUIInitializer.updateStatus("Defeat all monsters to \nproceed to next room!");
            } else if (tile.isGold()) {
                ANIMATOR.playerMoved();
                ANIMATOR.pulsateTile(tile.getTileTexture());
                tile.removeFromScene();
                tile.setTileTexture(FXGL.getAssetLoader().loadTexture("newGoldTile.png"));
                tile.displayOnScene();
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.tileClick(conductor, scoreText);
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));
                LevelUIInitializer.updateStatus("Gold already picked up!");

            } else if (tile.getType().equals(TileType.MYSTERY)) {
                ANIMATOR.playerMoved();
                ANIMATOR.pulsateTile(tile.getTileTexture());
                tile.removeFromScene();
                tile.setTileTexture(FXGL.getAssetLoader().loadTexture("newMystery.png"));
                tile.displayOnScene();
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.tileClick(conductor, scoreText);
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                    position.getY() - 100));
                LevelUIInitializer.updateStatus("Chest already looted!");
            } else {
                ANIMATOR.playerMoved();
                ANIMATOR.pulsateTile(tile.getTileTexture());
                tile.removeFromScene();
                tile.setTileTexture(FXGL.getAssetLoader().loadTexture("normal-tile.png"));
                tile.displayOnScene();
                LevelUIInitializer.updateStatus("Moved tiles!");
                GlobalSettings.setCurrPlayerTile(tile.getTileID());
                tile.tileClick(conductor, scoreText);
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));
            }
            FXGL.getAudioPlayer().playSound(CLICK);
        }
    }

    public static Text getScoreText() {
        return scoreText;
    }
}
