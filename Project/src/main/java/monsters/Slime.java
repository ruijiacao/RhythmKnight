package monsters;

import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.dsl.FXGL;
import initializers.LevelUIInitializer;
import javafx.scene.text.Text;
import settings.GlobalSettings;
import tilesystem.Tile;

public class Slime extends Monster {
    private GameView view;

    public Slime(Tile currentTile) {
        super(currentTile);
        this.setHealth(50);
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
        if (inCombat()) {
            int playerTile = GlobalSettings.getCurrPlayerTile();
            int currTile = getCurrentTile().getTileID();

            if (playerTile >= currTile - 5 || playerTile <= currTile + 5) {
                Text dmg = new Text("5");
                dmg.setX(GlobalSettings.getPlayerSprite().getX() + 75);
                dmg.setY(GlobalSettings.getPlayerSprite().getY() + 200);
                FXGL.getGameScene().addUINode(dmg);
                dmg.setScaleX(3);
                dmg.setScaleY(3);
                this.getAnim().displayDamage(dmg,
                    GlobalSettings.getCurrentMap().getTile(GlobalSettings.getCurrPlayerTile()));
                GlobalSettings.getPlayer().updateHealth(-5);
                LevelUIInitializer.updateHealth(GlobalSettings.getPlayer().getHealth());
                FXGL.getAudioPlayer().playSound(FXGL.getAssetLoader().loadSound("hit-player.wav"));
            }
        }
    }
}
