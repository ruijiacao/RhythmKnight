import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import players.Player;

class PlayerTest extends ApplicationTest {
    private Player cut;

    @BeforeEach
    void setCut() {
        cut = new Player();
    }

    @Test
    void getGold() {
        assertEquals(cut.getGold(), 0);
    }

    @Test
    void setGold() {
        cut.setGold(15);
        assertEquals(cut.getGold(), 15);
    }

    @Test
    void pickedUpGold() {
        cut.pickedUpGold(15);
        assertEquals(cut.getGold(), 15);
    }

    @Test
    void getMonstersSlain() {
        cut.monsterSlain();
        cut.monsterSlain();
        assertEquals(cut.getMonstersSlain(), 2);
    }

    @Test
    void monsterSlain() {
        assertEquals(cut.getMonstersSlain(), 0);
        cut.monsterSlain();
        assertEquals(cut.getMonstersSlain(), 1);
    }

    @Test
    void setMonstersSlain() {
        assertEquals(cut.getMonstersSlain(), 0);
        cut.setMonstersSlain(6);
        assertEquals(cut.getMonstersSlain(), 6);
    }

    @Test
    void setHealth() {
        cut.setHealth(99);
        assertEquals(cut.getHealth(), 99);
    }

    @Test
    void updateHealth() {
        cut.setHealth(100);
        cut.updateHealth(-47);
        assertEquals(cut.getHealth(), 53);
    }

    @Test
    void setName() {
        cut.setName("Test");
        assertEquals(cut.getName(), "Test");
    }

    @Test
    void setWeapon() {
        cut.setWeapon(2);
        assertEquals(cut.getWeapon(), 2);
    }


    @Test
    void resetStats() {
        cut.setGold(52);
        cut.setMonstersSlain(5);
        cut.updateScore(50);
        cut.resetStats();
        assertEquals(cut.getGold(), 0);
        assertEquals(cut.getScore(), 0);
        assertEquals(cut.getMonstersSlain(), 0);

    }

    @Test
    void getScore() {
        assertEquals(cut.getScore(), 0);
        cut.updateScore(9);
        assertEquals(cut.getScore(), 9);
    }
}