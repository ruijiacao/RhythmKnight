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

public class Wizard extends Monster {
    private Entity wizard;
    private ArrayList<Tile> map;
    private Tile currentTile;
    private boolean isInCombat;
    private int health;
    private Conductor conductor;

    public Wizard (Tile currentTile, Conductor conductor) {
        wizard = new EntityBuilder()
                .view(FXGL.getAssetLoader().loadTexture("slime.gif"))
                .buildAndAttach();
        wizard.setX(currentTile.getPosition().getX());
        wizard.setY(currentTile.getPosition().getY());
        map = GlobalSettings.getCurrentMap();
        this.currentTile = currentTile;
        health = 100;
        this.conductor = conductor;
    }

    /*
    ===== WIZARD ATTACK =====
    When attacking a wizard, they will change the song and the tempo.
    They attack once every 4 beats and do medium damage.
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
        Random rand = new Random();
        Song newSong = SongList.getSongs()[rand.nextInt(5)];
        int score = conductor.getPlayerScore();
        conductor = new Conductor(newSong.getBpm(), newSong.getPath(), conductor.getPlayerScore());
        conductor.startAndKeepRhythm(FXGL.getAssetLoader().loadTexture("newCutout.png"));
        for (Tile tile : map) {
            conductor.checkRhythm(tile, new Text("Level 1 / Floor 1 \n" + score));
        }
    }

    public boolean isInCombat() {
        return isInCombat;
    }

    public void exitCombat() {
        isInCombat = false;
    }
}
