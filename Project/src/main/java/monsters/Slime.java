package monsters;

import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import settings.GlobalSettings;
import tilesystem.Tile;

import java.util.ArrayList;

public class Slime extends Monster {
    private Entity slime;
    private ArrayList<Tile> map;
    private Tile currentTile;
    private boolean isInCombat;
    private int health;

    public Slime (Tile currentTile) {
        slime = new EntityBuilder()
                .view(FXGL.getAssetLoader().loadTexture("slime.gif"))
                .buildAndAttach();
        slime.setX(currentTile.getPosition().getX());
        slime.setY(currentTile.getPosition().getY());
        map = GlobalSettings.getCurrentMap();
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
