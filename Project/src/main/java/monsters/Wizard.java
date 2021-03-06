package monsters;

import com.almasb.fxgl.dsl.FXGL;
import initializers.LevelUIInitializer;
import javafx.scene.text.Text;
import settings.GlobalSettings;
import tilesystem.Tile;

public class Wizard extends Monster {

    public Wizard(Tile currentTile) {
        super(currentTile);
        this.setHealth(100);
    }

    /*
    ===== WIZARD ATTACK =====
    When attacking a wizard, they will change the song and the tempo.
    They attack once every 4 beats and do medium damage.
    ========================
     */
    @Override
    public void attack() {
        if (inCombat()) {
            int playerTile = GlobalSettings.getCurrPlayerTile();
            int currTile = getCurrentTile().getTileID();

            if (playerTile >= currTile - 5 || playerTile <= currTile + 5) {
                Text dmg = new Text("10");
                dmg.setX(GlobalSettings.getPlayerSprite().getX() + 75);
                dmg.setY(GlobalSettings.getPlayerSprite().getY() + 200);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                getAnim().displayDamage(dmg, GlobalSettings.getCurrentMap()
                    .getTile(GlobalSettings.getCurrPlayerTile()));
                GlobalSettings.getPlayer().updateHealth(-10);
                LevelUIInitializer.updateHealth(GlobalSettings.getPlayer().getHealth());
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-player.wav"));
            }
        }
    }
}
