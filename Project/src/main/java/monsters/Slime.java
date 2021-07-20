package monsters;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
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

    public Slime (Tile currentTile) {
        System.out.println(currentTile.getPosition().toString());
        this.currentTile = currentTile;
        health = 50;
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
        int playerTile = GlobalSettings.getCurrPlayerTile();
        int currTile = currentTile.getTileID();

        if (currTile - 1 == playerTile || currTile - 4 == playerTile || currTile - 3 == playerTile ||
        currTile + 1 == playerTile || currTile + 4 == playerTile || currTile + 3 == playerTile) {
            // decrease health
        }
    }

    private void checkHealth() {
        if (health <= 0) {
            isDefeated = true;
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
