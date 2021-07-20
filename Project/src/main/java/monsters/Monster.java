package monsters;

import com.almasb.fxgl.app.scene.GameView;
import tilesystem.Tile;

public abstract class Monster {
    public abstract void enterBattle();
    public abstract void attack();
    public abstract boolean isInCombat();
    public abstract void doDamage(int hp);
    public abstract boolean isDefeated();
    public abstract Tile getCurrentTile();
}
