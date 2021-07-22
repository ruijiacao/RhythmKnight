package monsters;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
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

public class Wizard extends Monster {
    private ArrayList<Tile> map;
    private Tile currentTile;
    private boolean isInCombat;
    private int health;
    private boolean isDefeated;
    private Animator anim;

    public Wizard (Tile currentTile) {
        this.currentTile = currentTile;
        health = 100;
        anim = new Animator();
    }

    /*
    ===== WIZARD ATTACK =====
    When attacking a wizard, they will change the song and the tempo.
    They attack once every 4 beats and do medium damage.
    ========================
     */
    @Override
    public void attack() {
        if (isInCombat) {
            int playerTile = GlobalSettings.getCurrPlayerTile();
            int currTile = currentTile.getTileID();

            if (playerTile >= currTile - 5 || playerTile <= currTile + 5) {
                Text dmg = new Text("10");
                dmg.setX(GlobalSettings.getPlayerSprite().getX() + 75);
                dmg.setY(GlobalSettings.getPlayerSprite().getY() + 200);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                anim.displayDamage(dmg, GlobalSettings.getCurrentMap().getTile(GlobalSettings.getCurrPlayerTile()));
                GlobalSettings.setPlayerHealth(GlobalSettings.getPlayerHealth() - 10);
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

    public void exitCombat() {

        isInCombat = false;
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
