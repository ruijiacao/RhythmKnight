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

    public Zombie (Tile currentTile) {
        super(currentTile);
        this.setHealth(120);
    }

    /*
    ===== ZOMBIE ATTACK =====
    Zombies are slow to attack, but their attacks do a lot of damage.
    They also have a lot of health. They attack once every 8 beats.
    ========================
     */
    @Override
    public void attack() {
        if (inCombat()) {
            int playerTile = GlobalSettings.getCurrPlayerTile();
            int currTile = getCurrentTile().getTileID();

            if (playerTile >= currTile - 5 || playerTile <= currTile + 5) {
                Text dmg = new Text("15");
                dmg.setX(GlobalSettings.getPlayerSprite().getX() + 75);
                dmg.setY(GlobalSettings.getPlayerSprite().getY() + 200);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                getAnim().displayDamage(dmg, GlobalSettings.getCurrentMap().getTile(GlobalSettings.getCurrPlayerTile()));
//                GlobalSettings.setPlayerHealth(GlobalSettings.getPlayerHealth() - 15);
//                LevelUIInitializer.updateHealth(GlobalSettings.getPlayerHealth());
                GlobalSettings.getPlayer().updateHealth(-15);
                LevelUIInitializer.updateHealth(GlobalSettings.getPlayer().getHealth());
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-player.wav"));
            }
        }
    }

}
