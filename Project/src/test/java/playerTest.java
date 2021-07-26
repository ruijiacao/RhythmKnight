import static org.junit.jupiter.api.Assertions.*;

import player.player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class playerTest {
    player cut;

    @BeforeEach
    public void setCuT() {
        cut = new player();
    }

    @Test
    void getGold() {
        assertEquals(cut.getGold(), 0);
    }

    @Test
    void setGold() {
        cut.setGold(40);
        assertEquals(cut.getGold(), 40);
    }

    @Test
    void pickedUpGold() {
        cut.pickedUpGold(25);
        assertEquals(cut.getGold(), 25);
    }

    @Test
    void getMonstersSlain() {
        assertEquals(cut.getMonstersSlain(), 0);
    }

    @Test
    void monsterSlain() {
    }

    @Test
    void setMonstersSlain() {
    }

    @Test
    void getHealth() {
    }

    @Test
    void setHealth() {
    }

    @Test
    void updateHealth() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getWeapon() {
    }

    @Test
    void setWeapon() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void resetStats() {
    }

    @Test
    void getScore() {
    }

    @Test
    void updateScore() {
    }
}