package monsters;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import initializers.LevelUIInitializer;
import javafx.scene.text.Text;
import rhythm.Animator;
import settings.GlobalSettings;
import tilesystem.Tile;
import ui.Notifier;

import java.util.ArrayList;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

public class Slime extends Monster {
    private Texture texture;
    private ArrayList<Tile> map;
    private Tile currentTile;
    private boolean isInCombat;
    private int health;
    private GameView view;
    private boolean isDefeated;
    private Animator anim;

    public Slime (Tile currentTile) {
        System.out.println(currentTile.getPosition().toString());
        this.currentTile = currentTile;
        health = 50;
        anim = new Animator();
    }

    /*
    ===== SLIME ATTACK =====
    Slimes are tiny blobs, making them very agile yet easy to kill.
    Because of their tininess, they can deal small amounts of damage on every beat.
    They also have small HP themselves, making them easy to kill in 1 or 2 hits.
    ========================
     */
    @Override
    public void attack() {
        if (isInCombat) {
            int playerTile = GlobalSettings.getCurrPlayerTile();
            int currTile = currentTile.getTileID();

            if (playerTile >= currTile - 5 || playerTile <= currTile + 5) {
                Text dmg = new Text("2");
                dmg.setX(GlobalSettings.getPlayerSprite().getX() + 75);
                dmg.setY(GlobalSettings.getPlayerSprite().getY() + 200);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                anim.displayDamage(dmg, GlobalSettings.getCurrentMap().getTile(GlobalSettings.getCurrPlayerTile()));
                GlobalSettings.setPlayerHealth(GlobalSettings.getPlayerHealth() - 2);
                LevelUIInitializer.updateHealth(GlobalSettings.getPlayerHealth());
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-player.wav"));
            }
        }
    }


    private void checkHealth() {
        if (health <= 0) {
            isDefeated = true;
            isInCombat = false;
        }
    }

    @Override
    public void enterBattle() {
        isInCombat = true;
    }

    public boolean isInCombat() {
        return isInCombat;
    }

    public void exitCombat() {
        isInCombat = false;
    }

    public Texture getTexture() {
        return texture;
    }

    public void doDamage(int dmg) {
        health = health - dmg;
        checkHealth();
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }
}
