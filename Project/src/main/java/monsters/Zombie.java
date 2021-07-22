package monsters;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import initializers.LevelUIInitializer;
import javafx.scene.text.Text;
import rhythm.Animator;
import rhythm.Conductor;
import settings.GlobalSettings;
import songs.Song;
import songs.SongList;
import tilesystem.Tile;
import tilesystem.TileType;
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
    private Animator anim;

    public Zombie (Tile currentTile) {
        this.currentTile = currentTile;
        health = 120;
        anim = new Animator();
    }

    /*
    ===== ZOMBIE ATTACK =====
    Zombies are slow to attack, but their attacks do a lot of damage.
    They also have a lot of health. They attack once every 8 beats.
    ========================
     */
    @Override
    public void attack() {
        if (isInCombat) {
            int playerTile = GlobalSettings.getCurrPlayerTile();
            int currTile = currentTile.getTileID();

            if (playerTile >= currTile - 5 || playerTile <= currTile + 5) {
                Text dmg = new Text("15");
                dmg.setX(GlobalSettings.getPlayerSprite().getX() + 75);
                dmg.setY(GlobalSettings.getPlayerSprite().getY() + 200);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                anim.displayDamage(dmg, GlobalSettings.getCurrentMap().getTile(GlobalSettings.getCurrPlayerTile()));
                GlobalSettings.setPlayerHealth(GlobalSettings.getPlayerHealth() - 15);
                LevelUIInitializer.updateHealth(GlobalSettings.getPlayerHealth());
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-player.wav"));
            }
        }
    }

    private void checkHealth() {
        if (health <= 0) {
            isDefeated = true;
            isInCombat = false;
            GlobalSettings.setMonstersKilled(GlobalSettings.getMonstersKilled() + 1);
            GlobalSettings.getActiveMonsters().remove(this);
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
