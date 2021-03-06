package monsters;

import com.almasb.fxgl.texture.Texture;
import rhythm.Animator;
import settings.GlobalSettings;
import tilesystem.Tile;

public abstract class Monster {
    private Texture texture;
    private boolean slain = false;
    private int health;
    private boolean inCombat;
    private Tile tile;
    private Animator anim;

    public Monster(Tile currentTile) {
        tile = currentTile;
        anim = new Animator();
    }

    public abstract void attack();

    public void enterBattle() {
        inCombat = true;
    };

    public boolean inCombat() {
        return inCombat;
    };

    public void takeDamage(int hp) {
        health -= hp;
        checkHealth();
    };

    public boolean isDefeated() {
        return (this.slain);
    };

    public void setSlain(Boolean status) {
        this.slain = status;
    }

    public void slain() {
        this.inCombat = false;
        this.slain = true;
        GlobalSettings.getPlayer().monsterSlain();

    }

    public void setHealth(int health) {
        this.health = health;
    }

    private void checkHealth() {
        if (this.getHealth() <= 0) {
            inCombat = false;
            this.slain();
        }
    }

    public int getHealth() {
        return health;
    }

    public Tile getCurrentTile() {
        return tile;
    };

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Animator getAnim() {
        return anim;
    }

    public void setInCombat(Boolean status) {
        this.inCombat = status;
    }
}
