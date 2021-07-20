package monsters;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.text.Text;
import rhythm.Conductor;
import settings.GlobalSettings;
import songs.Song;
import songs.SongList;
import tilesystem.Tile;
import ui.Notifier;

import java.util.ArrayList;
import java.util.Random;

public class Zombie extends Monster {
    private Entity zombie;
    private ArrayList<Tile> map;
    private Tile currentTile;
    private boolean isInCombat;
    private int health;
    private boolean isDefeated;
    private GameView view;

    public Zombie (Tile currentTile) {
        this.currentTile = currentTile;
        health = 120;
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

    public boolean isDefeated() {
        return isDefeated;
    }

    public void doDamage(int dmg) {
        health = health - dmg;
        checkHealth();
    }

    public Tile getCurrentTile() {
        return currentTile;
    }
}
