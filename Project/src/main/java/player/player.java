package player;

import com.almasb.fxgl.ui.Position;
import ui.Notifier;


public class player {

    private int score;
    private int gold;
    private int monstersSlain;
    private int health;
    private String name;
    private int weapon;
    private Position position;

    public player() {
        this.name = null;
        this.gold = 0;
        this.monstersSlain = 0;
        this.score = 0;
        this.weapon = -1;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void pickedUpGold(int gold) {
        this.gold += gold;
    }

    public int getMonstersSlain() {
        return monstersSlain;
    }

    public void monsterSlain(){
        monstersSlain++;
    }

    public void setMonstersSlain(int monstersSlain) {
        this.monstersSlain = monstersSlain;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void updateHealth(int health) {
        this.health += health;
        if (this.health <= 0) {
            Notifier.createGameOverAlert();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void resetStats() {
        this.score = 0;
        this.gold = 0;
        this.monstersSlain = 0;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score += score;
    }
}
