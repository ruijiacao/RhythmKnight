package monsters;

import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.text.Text;
import rhythm.Conductor;
import settings.GlobalSettings;
import songs.Song;
import songs.SongList;
import tilesystem.Tile;

import java.util.ArrayList;
import java.util.Random;

public class Zombie extends Monster {
    private Entity wizard;
    private ArrayList<Tile> map;
    private Tile currentTile;
    private boolean isInCombat;
    private int health;

    public Zombie (Tile currentTile) {
        wizard = new EntityBuilder()
                .view(FXGL.getAssetLoader().loadTexture("slime.gif"))
                .buildAndAttach();
        wizard.setX(currentTile.getPosition().getX());
        wizard.setY(currentTile.getPosition().getY());
        map = GlobalSettings.getCurrentMap();
        this.currentTile = currentTile;
        health = 200;
    }

    /*
    ===== ZOMBIE ATTACK =====
    Zombies are slow to attack, but their attacks do a lot of damage.
    They also have a lot of health. They attack once every 8 beats.
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
            // it's dead :O
            // play death animation and take it off the scene
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
}
