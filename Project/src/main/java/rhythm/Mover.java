package rhythm;

import com.almasb.fxgl.audio.Sound;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import initializers.Initializer;
import initializers.LevelUIInitializer;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import settings.GlobalSettings;
import tilesystem.MapLoader;
import tilesystem.Tile;
import tilesystem.TileType;
import ui.Notifier;


public class Mover {
    private static Conductor conductor;
    private static Text scoreText;
    private static final Animator animator = new Animator();
    private static final Sound click = FXGL.getAssetLoader().loadSound("snare01.wav");

    private static boolean verifyBounds(MouseEvent point) {
        return point.getX() > GlobalSettings.getPlayerSprite().getX() - 450
                && point.getX() < GlobalSettings.getPlayerSprite().getX() + 450
                && point.getY() > GlobalSettings.getPlayerSprite().getY() - 450
                && point.getY() < GlobalSettings.getPlayerSprite().getY() + 450;
    }

    private static void goBackInPath(Tile origin) {
        origin.removeFromScene();
        Tile visited = new Tile(origin.getPosition(), TileType.ORIGIN);
        visited.setOrigin(true);
        visited.setVisited(true);
        visited.displayOnScene(conductor, scoreText);
        GlobalSettings.setRoomCounter(GlobalSettings.getRoomCounter() - 1);
        if (GlobalSettings.getRoomCounter() == 0) {
            MapLoader.loadMap(0, conductor, scoreText);
        } else {
            MapLoader
                    .loadMap(GlobalSettings.getPath(GlobalSettings.getPathChosen())
                            [GlobalSettings.getRoomCounter() - 1], conductor, scoreText);
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

    public static void move(MouseEvent event, Tile tile, Conductor passedInCond, Text passedInScore, int score, int scoreConstant) {
        conductor = passedInCond;
        scoreText = passedInScore;

        if (verifyBounds(event)) {
            Point2D position = tile.getPosition();
            if (tile.getType().equals(TileType.LOCKED_EXIT)) {
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 20,
                        position.getY() - 80));
            } else {
                GlobalSettings.setPlayerPos(new Point2D(position.getX() - 50,
                        position.getY() - 100));
            }

            if (tile.isExit()) {
                GlobalSettings.getPlayerSprite().setScaleX(.35);
                GlobalSettings.getPlayerSprite().setScaleY(.35);
                goForwardInPath(tile);
            } else if (tile.isOrigin() && GlobalSettings.getRoomCounter() != 0) {
                GlobalSettings.getPlayerSprite().setScaleX(.35);
                GlobalSettings.getPlayerSprite().setScaleY(.35);
                goBackInPath(tile);
            } else if (!tile.isVisited()) {
                animator.playerMoved();
                animator.pulsateScore(scoreText);
                animator.pulsateTile(tile.getTileTexture());

                if (tile.isGold()) {
                    Initializer.setGold(Initializer.getGold() + 15);
                    LevelUIInitializer.updateGold(Initializer.getGold());
                }
                tile.removeFromScene();
                Tile visited;
                if (tile.getType().equals(TileType.LOCKED_EXIT)) {
                    visited = new Tile(new Point2D((position.getX() + 30),
                            (position.getY() + 20)), TileType.VISITED);
                } else {
                    visited = new Tile(position, TileType.VISITED);
                }

                visited.displayOnScene(conductor, scoreText);
                score += 10 + scoreConstant;
                scoreText.setText("Level " + Initializer.getCurrLevel() + " / Floor "
                        + Initializer.getCurrFloor() + "\n" + score);

                visited.setVisited(true);
            } else {
                animator.playerMoved();
                tile.removeFromScene();
                Tile visited;
                visited = new Tile(tile.getPosition(), TileType.VISITED);
                visited.displayOnScene(conductor, scoreText);
            }

            FXGL.getAudioPlayer().playSound(click);
            tile.setPlayerOnTile(true);
            GlobalSettings.setCurrPlayerTile(tile.getTileID());
        }
    }
}
